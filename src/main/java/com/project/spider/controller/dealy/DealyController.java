package com.project.spider.controller.dealy;

import com.project.spider.common.exception.SpiderException;
import com.project.spider.controller.dealy.res.DealyGoods;
import com.project.spider.controller.dealy.res.flashSale.FlashSaleVo;
import com.project.spider.controller.dealy.res.product.ProductCategory;
import com.project.spider.controller.dealy.res.product.ProductSubCategory;
import com.project.spider.controller.dealy.res.sku.SkuInfoVo;
import com.project.spider.core.spider.dealy.DealyFetchProvider;
import com.project.spider.core.spider.dealy.dto.category.CategoryDto;
import com.project.spider.core.spider.dealy.dto.category.CategoryNavMenu;
import com.project.spider.core.spider.dealy.dto.categoryGoodsList.CategoryGoodsBaseInfoDataGoods;
import com.project.spider.core.spider.dealy.dto.categoryGoodsList.CategoryGoodsListDto;
import com.project.spider.core.spider.dealy.dto.categoryInfo.CategoryInfoDto;
import com.project.spider.core.spider.dealy.dto.categoryInfo.CategoryInfoNavMenu;
import com.project.spider.core.spider.dealy.dto.categoryInfo.CategoryInfoNavMenuNumber;
import com.project.spider.core.spider.dealy.dto.flashSaleMain.FlashSaleMainDto;
import com.project.spider.core.spider.dealy.dto.flashSaleMain.FlashSaleTimeTag;
import com.project.spider.core.spider.dealy.dto.flashSaleGoodsList.FlashSaleGoods;
import com.project.spider.core.spider.dealy.dto.flashSaleGoodsList.FlashSaleGoodsListDto;
import com.project.spider.core.spider.dealy.dto.skuInfo.SkuInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("dealy")
public class DealyController {
    @Autowired
    private DealyFetchProvider dealyFetchProvider;

    /**
     * 获取闪购
     */
    @GetMapping("/flashSale")
    @ResponseBody
    public List<FlashSaleVo> getFlashSale() {
        FlashSaleMainDto flashSaleMainDto = dealyFetchProvider.getFlashSaleMain();
        if (flashSaleMainDto.getCode() != 200) {
            SpiderException.triggerParseFailed();
            return new ArrayList<>();
        }

        List<FlashSaleVo> flashSaleVoList = new ArrayList<>();

        for (FlashSaleTimeTag flashSaleTimeTag : flashSaleMainDto.getData().getFlashSaleTimeTag()) {
            FlashSaleVo flashSaleVo = new FlashSaleVo();
            flashSaleVo.setTableTime(flashSaleTimeTag.getTabTime());
            flashSaleVo.setGoodsCount(0);
            flashSaleVo.setGroupId(flashSaleTimeTag.getGroupId());

            List<DealyGoods> dealyGoodsList = new ArrayList<>();
            for (int pageNum = 0; ; pageNum++) {
                FlashSaleGoodsListDto flashSaleGoodsListDto = dealyFetchProvider.getFlashSaleGoodsList(
                        flashSaleTimeTag.getTabTime(),
                        flashSaleTimeTag.getGroupId(),
                        pageNum, 10);

                if (flashSaleGoodsListDto.getCode() != 200) {
                    break;
                }

                for (FlashSaleGoods flashSaleGoods : flashSaleGoodsListDto.getData().getGoodsList()) {
                    DealyGoods dealyGoods = new DealyGoods();
                    dealyGoods.setCatId(flashSaleGoods.getCatId());
                    dealyGoods.setCountdown(flashSaleGoods.getCountdown());
                    dealyGoods.setDiscountShow(flashSaleGoods.getDiscountShow());
                    dealyGoods.setStartTime(flashSaleGoods.getStartTime());
                    dealyGoods.setEndTime(flashSaleGoods.getEndTime());
                    dealyGoods.setFlashSaleId(flashSaleGoods.getFlashSaleId());
                    dealyGoods.setGoodsId(flashSaleGoods.getGoodsId());
                    dealyGoods.setGoodsName(flashSaleGoods.getGoodsName());
                    dealyGoods.setGoodsPrice(flashSaleGoods.getGoodsPrice());
                    dealyGoods.setFlashSalePrice(flashSaleGoods.getFlashSalePrice());
                    dealyGoods.setShopPrice(flashSaleGoods.getShopPrice());
                    dealyGoods.setWholeImgLink(flashSaleGoods.getWholeImgLink());

                    dealyGoodsList.add(dealyGoods);
                    flashSaleVo.setGoodsCount(flashSaleVo.getGoodsCount() + 1);
                }
            }

            flashSaleVo.setDealyGoodsList(dealyGoodsList);
            flashSaleVoList.add(flashSaleVo);
        }

        return flashSaleVoList;
    }

    /**
     * 获取商品一级类目
     */
    @GetMapping("/product/category")
    @ResponseBody
    public List<ProductCategory> getProductCategory() {
        CategoryDto categoryDto = dealyFetchProvider.getCategoryLevelOne();
        if (categoryDto.getCode() != 200) {
            SpiderException.triggerParseFailed();
            return new ArrayList<>();
        }

        List<ProductCategory> productCategoryList = new ArrayList<>();
        for (CategoryNavMenu categoryNavMenu : categoryDto.getData().getNavMenuList()) {
            ProductCategory productCategory = new ProductCategory();
            productCategory.setId(categoryNavMenu.getId());
            productCategory.setName(categoryNavMenu.getShowName());
            productCategoryList.add(productCategory);
        }

        return productCategoryList;
    }

    /**
     * 获取商品二级类目
     */
    @GetMapping("/product/category/{categoryId}")
    @ResponseBody
    public List<ProductSubCategory> getProductSubCategory(@PathVariable("categoryId") Integer categoryId) {
        // 二级目录
        CategoryInfoDto categoryInfoDto = dealyFetchProvider.getCategoryLevelTwo(categoryId);
        if (categoryInfoDto.getCode() != 200) {
            SpiderException.triggerParseFailed();
            return new ArrayList<>();
        }

        // Dealy 有三级目录，我们目前只有二级目录，所以将二级目录的所有子目录遍历为二级类目。
        List<ProductSubCategory> productSubCategoryList = new ArrayList<>();

        for (CategoryInfoNavMenu categoryInfoNavMenu : categoryInfoDto.getData().getNavMenuList()) {
            CategoryInfoNavMenuNumber[] categoryInfoNavMenuNumbers = new CategoryInfoNavMenuNumber[]{
                    categoryInfoNavMenu.getZero(),
                    categoryInfoNavMenu.getOne(),
                    categoryInfoNavMenu.getTwo(),
                    categoryInfoNavMenu.getThree(),
                    categoryInfoNavMenu.getFour(),
                    categoryInfoNavMenu.getFive(),
                    categoryInfoNavMenu.getSix(),
                    categoryInfoNavMenu.getEight(),
                    categoryInfoNavMenu.getNight(),
                    categoryInfoNavMenu.getTeen()
            };

            for (CategoryInfoNavMenuNumber categoryInfoNavMenuNumber : categoryInfoNavMenuNumbers) {
                if (categoryInfoNavMenuNumber != null) {
                    ProductSubCategory productSubCategory = new ProductSubCategory();
                    productSubCategory.setId(categoryInfoNavMenuNumber.getContentCode());
                    productSubCategory.setName(categoryInfoNavMenuNumber.getTargetName());
                    productSubCategory.setIconUrl(categoryInfoNavMenuNumber.getUrl());
                    productSubCategory.setCategoryId(categoryId);
                    productSubCategoryList.add(productSubCategory);
                }
            }
        }

        return productSubCategoryList;
    }

    /**
     * 获取商品三级内容列表
     */
    @GetMapping("/product/subCategory/{subCategoryId}/goods")
    @ResponseBody
    public List<CategoryGoodsBaseInfoDataGoods> getProductSubCategoryGoods(@PathVariable("subCategoryId") Integer subCategoryId) {
        List<CategoryGoodsBaseInfoDataGoods> goodsList = new ArrayList<>();

        for (int page = 110; ; page++) {
            CategoryGoodsListDto categoryGoodsListDto = dealyFetchProvider.getCategoryLevelThree(page, String.valueOf(subCategoryId), "");
            if (categoryGoodsListDto.getCode() != 200) {
                SpiderException.triggerParseFailed();
                break;
            }

            if (categoryGoodsListDto.getData() == null ||
                    categoryGoodsListDto.getData().getBASE_INFO() == null ||
                    categoryGoodsListDto.getData().getBASE_INFO().getData() == null ||
                    categoryGoodsListDto.getData().getBASE_INFO().getData().getGoodsList() == null) {
                continue;
            }

            goodsList.addAll(categoryGoodsListDto.getData().getBASE_INFO().getData().getGoodsList());

        }

        return goodsList;
    }

    /**
     * 获取商品 Sku
     */
    @GetMapping("/goods/{goodsIdStr}/sku")
    @ResponseBody
    public SkuInfoVo getSkuInfo(@PathVariable("goodsIdStr") String goodsIdStr) {
        SkuInfoDto skuInfoDto = dealyFetchProvider.getSkuInfoDto(goodsIdStr);
        return null;
    }
}
