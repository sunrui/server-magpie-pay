package com.project.spider.controller.spider;

import com.project.spider.controller.spider.req.SaveToProdReq;
import com.project.spider.controller.spider.res.PostSaveToProdRes;
import com.project.spider.controller.spider.res.ProductPageVo;
import com.project.spider.core.db.spider.entity.ProdProduct;
import com.project.spider.core.db.spider.entity.SpiderProduct;
import com.project.spider.core.db.spider.service.ProdProductService;
import com.project.spider.core.db.spider.service.SpiderProductService;
import com.project.spider.core.db.spider.service.SpiderPutOnService;
import com.project.spider.core.job.cache.SpiderCacheJob;
import com.project.spider.core.db.menu.model.ProdCategoryMenu;
import com.project.spider.core.db.menu.service.ProdCategoryService;
import com.project.spider.core.spider.SpiderRefer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("spider")
public class SpiderController {
	@Autowired
	private SpiderProductService spiderProductService;
	@Autowired
	private SpiderCacheJob spiderCacheJob;
	@Autowired
	private SpiderPutOnService spiderPutOnService;
	@Autowired
	private ProdCategoryService prodCategoryService;
	@Autowired
	private ProdProductService prodProductService;

	@GetMapping("prod/menu")
	public List<ProdCategoryMenu> getAllMenu() {
		return prodCategoryService.findAllMenu();
	}

	@GetMapping("product/spider/{spiderProductUuid}")
	public SpiderProduct getProductSpiderOne(@PathVariable("spiderProductUuid") String spiderProductUuid) {
		return spiderProductService.findByUuid(spiderProductUuid);
	}

	@GetMapping("product/prod/{prodProductUuid}")
	public ProdProduct getProductProdOne(@PathVariable("prodProductUuid") String prodProductUuid) {
		return prodProductService.findByUuid(prodProductUuid);
	}

	@GetMapping("product")
	public ProductPageVo getProduct(@RequestParam("page") Integer page,
	                                @RequestParam(name = "size", required = false, defaultValue = "24") Integer size,
	                                @RequestParam("marketingType") Integer marketingType,
	                                @RequestParam(name = "isPutOn", required = false) Boolean isPutOn,
	                                @RequestParam(name = "spiderRefer", required = false, defaultValue = "JOLLY_CHIC") SpiderRefer spiderRefer,
	                                @RequestParam(value = "forceUpdate", required = false, defaultValue = "false") Boolean forceUpdate) {
		if (Boolean.FALSE.equals(forceUpdate) && size.equals(SpiderCacheJob.PAGE_SIZE) && marketingType == 0) {
			ProductPageVo productPageVo = spiderCacheJob.getMarketingType0(page);
			if (productPageVo != null) {
				return productPageVo;
			}
		}

		Page<SpiderProduct> spiderProductPage;

		if (isPutOn != null) {
			spiderProductPage = spiderProductService.findAllBySpiderReferAndMarketingTypeAndIsPutOn(spiderRefer, marketingType, isPutOn, page, size);
		} else {
			spiderProductPage = spiderProductService.findAllBySpiderReferAndMarketingType(spiderRefer, marketingType, page, size);
		}

		ProductPageVo productPageVo = new ProductPageVo();
		productPageVo.setData(spiderProductPage.getContent());
		productPageVo.setCurrentPage(page);
		productPageVo.setCurrentSize(spiderProductPage.getNumberOfElements());
		productPageVo.setTotalPage(spiderProductPage.getTotalPages());
		productPageVo.setTotalSize(spiderProductPage.getTotalElements());

		return productPageVo;
	}

	@PostMapping("puton/{spiderProductId}")
	public PostSaveToProdRes saveToProd(@PathVariable("spiderProductId") Integer spiderProductId,
	                                    @Validated @RequestBody SaveToProdReq saveToProdReq) {
		if (saveToProdReq == null || !StringUtils.hasText(saveToProdReq.getCategoryNo())) {
			PostSaveToProdRes postSaveToProdRes = new PostSaveToProdRes();
			postSaveToProdRes.setCategoryNoNeeded(true);
			return postSaveToProdRes;
		}

		SpiderProduct spiderProduct = spiderProductService.findById(spiderProductId);
		if (spiderProduct == null) {
			PostSaveToProdRes postSaveToProdRes = new PostSaveToProdRes();
			postSaveToProdRes.setSpiderProductIdNotExist(true);
			postSaveToProdRes.setIsSuccess(false);
			return postSaveToProdRes;
		}

		if (spiderProduct.getIsPutOn()) {
			PostSaveToProdRes postSaveToProdRes = new PostSaveToProdRes();
			postSaveToProdRes.setIsAlreadyPutOn(true);
			postSaveToProdRes.setIsSuccess(false);
			return postSaveToProdRes;
		}

		/**
		 * 新加入的 uuid 可能会有原有的 uuid 碰撞，改掉原来的数据。
		 *
		 * 有几种可能：
		 *  1、已经存在了，直接去覆盖原有的旧的数据，万一运营改价了，这个会不好。
		 *  2、生成一个新的 UUID 同时将产品上架，这可能会产生两个重复的数据。
		 *  3、将这个商口指向到原来上架的商品，有可能不是同一个商品。（引用第三种）
		 */
		ProdProduct prodProductQuery = prodProductService.findByUuid(spiderProduct.getUuid());
		if (prodProductQuery != null) {
			spiderProductService.updateLinkUuid(spiderProduct.getId(), prodProductQuery.getUuid());
			PostSaveToProdRes postSaveToProdRes = new PostSaveToProdRes();
			postSaveToProdRes.setProdProduct(prodProductQuery);
			postSaveToProdRes.setLinkUuid(prodProductQuery.getUuid());
			postSaveToProdRes.setIsSuccess(true);
			return postSaveToProdRes;
		}

		/**
		 * 将选品上架相关的一系列流程聚合，保证事务化处理。
		 */
		ProdProduct prodProduct = spiderPutOnService.putOnToProd(spiderProduct, saveToProdReq.getCategoryNo());

		PostSaveToProdRes postSaveToProdRes = new PostSaveToProdRes();
		postSaveToProdRes.setProdProduct(prodProduct);
		postSaveToProdRes.setLinkUuid(prodProduct.getUuid());
		postSaveToProdRes.setIsSuccess(true);
		return postSaveToProdRes;
	}
}
