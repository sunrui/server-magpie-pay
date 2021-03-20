package com.project.spider.core.spider.dealy;

import com.project.spider.core.spider.SpiderConfig;
import com.project.spider.core.spider.SpiderLang;
import com.project.spider.core.spider.dealy.dto.buy1get1extraFree.Buy1Get1ExtraFreeDto;
import com.project.spider.core.spider.dealy.dto.category.CategoryDto;
import com.project.spider.core.spider.dealy.dto.categoryGoodsList.CategoryGoodsListDto;
import com.project.spider.core.spider.dealy.dto.categoryInfo.CategoryInfoDto;
import com.project.spider.core.spider.dealy.dto.flashSaleGoodsList.FlashSaleGoodsListDto;
import com.project.spider.core.spider.dealy.dto.flashSaleMain.FlashSaleMainDto;
import com.project.spider.core.spider.dealy.dto.goodsInfo.GoodsInfoDto;
import com.project.spider.core.spider.dealy.dto.rate.RateDto;
import com.project.spider.core.spider.dealy.dto.skuInfo.SkuInfoDto;
import com.project.spider.core.spider.SpiderRefer;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 获取 DEALY 相关
 * NOTE: 内容结构比较乱，只是原版网站复刻所致。
 */
@Service
public class DealyFetchProvider {
	@Autowired
	private RestTemplate restTemplate;
	@Getter
	@Setter
	private SpiderConfig spiderConfig = jollychicSar;

	public static final SpiderConfig dealyEn = new SpiderConfig(SpiderLang.ENGLISH, "https://m.dealy1688.com/", SpiderRefer.DEALY);
	public static final SpiderConfig dealySar = new SpiderConfig(SpiderLang.SAR, "https://m.dealy1688.com/", SpiderRefer.DEALY);
	public static final SpiderConfig jollychicEn = new SpiderConfig(SpiderLang.ENGLISH, "https://m.jollychic.com/", SpiderRefer.JOLLY_CHIC);
	public static final SpiderConfig jollychicSar = new SpiderConfig(SpiderLang.SAR, "https://ar.m.jollychic.com/", SpiderRefer.JOLLY_CHIC);

	/**
	 * 获取利率
	 */
	public RateDto getRate() {
		String url = spiderConfig.getHost() + "general/rate";
		HttpHeaders headers = new HttpHeaders();
		MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
		headers.setContentType(type);
		headers.set("X-Requested-With", "XMLHttpRequest");

		if (spiderConfig.getSpiderLang() == SpiderLang.SAR) {
			headers.set("cookie", "LANG_NAME=ar; LANG_CODE=1;");
		}

		HttpEntity<String> entity = new HttpEntity<>(null, headers);

		try {
			return restTemplate.postForObject(url, entity, RateDto.class);
		} catch (Exception e) {
			e.printStackTrace();
			RateDto rateDto = new RateDto();
			rateDto.setCode(400);
			return rateDto;
		}
	}

	/**
	 * 获取闪购主菜单
	 */
	public FlashSaleMainDto getFlashSaleMain() {
		String url = spiderConfig.getHost() + "flashover/flash-sale-main";
		HttpHeaders headers = new HttpHeaders();
		MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
		headers.setContentType(type);
		headers.set("X-Requested-With", "XMLHttpRequest");

		if (spiderConfig.getSpiderLang() == SpiderLang.SAR) {
			headers.set("cookie", "LANG_NAME=ar; LANG_CODE=1;");
		}

		String formData = "goodsId=0&notBeginTabTime=0";
		HttpEntity<String> entity = new HttpEntity<>(formData, headers);

		try {
			return restTemplate.postForObject(url, entity, FlashSaleMainDto.class);
		} catch (Exception e) {
			e.printStackTrace();
			FlashSaleMainDto flashSaleMainDto = new FlashSaleMainDto();
			flashSaleMainDto.setCode(400);
			return flashSaleMainDto;
		}
	}

	/**
	 * 获取闪购列表详情
	 */
	public FlashSaleGoodsListDto getFlashSaleGoodsList(Integer tableTime, Integer groupId, Integer pageNum, Integer pageSize) {
		String url = spiderConfig.getHost() + "flashover/get-flash-sale-goods-list";
		HttpHeaders headers = new HttpHeaders();
		MediaType type = MediaType.parseMediaType("application/x-www-form-urlencoded");
		headers.setContentType(type);
		headers.set("X-Requested-With", "XMLHttpRequest");

		if (spiderConfig.getSpiderLang() == SpiderLang.SAR) {
			headers.set("cookie", "LANG_NAME=ar; LANG_CODE=1;");
		}

		String formData = String.format("pageNum=%d&tabTime=%d&groupId=%d&goodsId=0&pageSize=%d", pageNum, tableTime, groupId, pageSize);
		HttpEntity<String> entity = new HttpEntity<>(formData, headers);

		try {
			// 为什么要 try 上？当后面页没有数据时，会返回另一种格式 {"code":200,"data":"","message":"Success!"}
			return restTemplate.postForObject(url, entity, FlashSaleGoodsListDto.class);
		} catch (Exception e) {
			e.printStackTrace();
			FlashSaleGoodsListDto flashSaleGoodsListDto = new FlashSaleGoodsListDto();
			// walk around for exception
			flashSaleGoodsListDto.setCode(400);
			return flashSaleGoodsListDto;
		}
	}

	/**
	 * 获取第一目录
	 */
	public CategoryDto getCategoryLevelOne() {
		String url = spiderConfig.getHost() + "list/category";
		HttpHeaders headers = new HttpHeaders();
		MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
		headers.setContentType(type);
		headers.set("X-Requested-With", "XMLHttpRequest");

		if (spiderConfig.getSpiderLang() == SpiderLang.SAR) {
			headers.set("cookie", "LANG_NAME=ar; LANG_CODE=1;");
		}

		HttpEntity<String> entity = new HttpEntity<>(null, headers);

		try {
			return restTemplate.postForObject(url, entity, CategoryDto.class);
		} catch (Exception e) {
			e.printStackTrace();
			CategoryDto categoryDto = new CategoryDto();
			categoryDto.setCode(400);
			return categoryDto;
		}
	}

	/**
	 * 获取二级目录
	 */
	public CategoryInfoDto getCategoryLevelTwo(Integer parentId) {
		String url;

		if (spiderConfig.getSpiderRefer() == SpiderRefer.DEALY) {
			url = "https://m.dealy1688.com/" + "list/category-info";
		} else {
			url = "https://m.jollychic.com/" + "list/category-info";
		}

		HttpHeaders headers = new HttpHeaders();
		MediaType type = MediaType.parseMediaType("application/x-www-form-urlencoded");
		headers.setContentType(type);
		headers.set("X-Requested-With", "XMLHttpRequest");

		if (spiderConfig.getSpiderLang() == SpiderLang.SAR) {
			headers.set("cookie", "LANG_NAME=ar; LANG_CODE=1;");
		}

		String body = "";

		// 若不指定服务器会返回全量数据
		if (parentId != null) {
			body = "parentId=" + parentId;
		}

		HttpEntity<String> entity = new HttpEntity<>(body, headers);

		try {
			return restTemplate.postForObject(url, entity, CategoryInfoDto.class);
		} catch (Exception e) {
			e.printStackTrace();
			CategoryInfoDto categoryInfoDto = new CategoryInfoDto();
			categoryInfoDto.setCode(400);
			return categoryInfoDto;
		}
	}

	/**
	 * 获取三级目录
	 *
	 * @param orderPage 111 开头
	 */
	public CategoryGoodsListDto getCategoryLevelThree(int orderPage, String keyId, String keywords) {
		String url = spiderConfig.getHost() + "list/category-goods-list";
		HttpHeaders headers = new HttpHeaders();
		MediaType type = MediaType.parseMediaType("application/x-www-form-urlencoded");
		headers.setContentType(type);
		headers.set("X-Requested-With", "XMLHttpRequest");

		if (spiderConfig.getSpiderLang() == SpiderLang.SAR) {
			headers.set("cookie", "LANG_NAME=ar; LANG_CODE=1;");
		}

		String body = String.format("orderPage=011%d&keyId=%s&keywords=%s&goodsId=", orderPage, keyId, keywords);
		HttpEntity<String> entity = new HttpEntity<>(body, headers);

		try {
			/**
			 * 此代码访问 dealy 是正常的，但是访问 jolllychic 就挂了。
			 * 因为执御是 php 语言写的，在做对象解析的时候，[] {} 是可以自适应的解析的，语言本身是弱类型的。
			 * 而 java 是强类型的语言，遇到这种使用弱类型语言的代码反序列化会非常困难。
			 * 最好使用 php js python 这种语言来爬虫，遇到对象的时候直接 . 或者 ['object'] 就要可以了。
			 */
			return restTemplate.postForObject(url, entity, CategoryGoodsListDto.class);
		} catch (Exception e) {
			e.printStackTrace();
			CategoryGoodsListDto categoryGoodsListDto = new CategoryGoodsListDto();
			categoryGoodsListDto.setCode(400);
			return categoryGoodsListDto;
		}
	}

	/**
	 * 获取 SKU 详情
	 */
	public SkuInfoDto getSkuInfoDto(String goodsIdStr) {
		String url = spiderConfig.getHost() + "goods/get-sku-info";
		HttpHeaders headers = new HttpHeaders();
		MediaType type = MediaType.parseMediaType("application/x-www-form-urlencoded");
		headers.setContentType(type);
		headers.set("X-Requested-With", "XMLHttpRequest");

		if (spiderConfig.getSpiderLang() == SpiderLang.SAR) {
			headers.set("cookie", "LANG_NAME=ar; LANG_CODE=1;");
		}

		String body = String.format("goodsIdStr=%s", goodsIdStr);
		HttpEntity<String> entity = new HttpEntity<>(body, headers);

		try {
			return restTemplate.postForObject(url, entity, SkuInfoDto.class);
		} catch (Exception e) {
			e.printStackTrace();
			SkuInfoDto skuInfoDto = new SkuInfoDto();
			skuInfoDto.setCode(400);
			return skuInfoDto;
		}
	}

	/**
	 * 获取 goodsIdStr 方法
	 */
	public String getGoodsIdStr(Integer goodsId) {
		String url = String.format(spiderConfig.getHost() + "p/goods-name-g%s.html", goodsId);

		HttpHeaders headers = new HttpHeaders();

		if (spiderConfig.getSpiderLang() == SpiderLang.SAR) {
			headers.set("cookie", "LANG_NAME=ar; LANG_CODE=1;");
		}

		HttpEntity<String> httpEntity = new HttpEntity<>(null, headers);
		URI uri = URI.create(url);

		try {
			ResponseEntity<String> responseEntity = restTemplate.exchange(uri, HttpMethod.POST, httpEntity, String.class);
			if (responseEntity.getStatusCode() != HttpStatus.MOVED_PERMANENTLY &&
					responseEntity.getStatusCode() != HttpStatus.FOUND) {
				return null;
			}

			uri = responseEntity.getHeaders().getLocation();
			if (uri == null) {
				return null;
			}

			// 此正则指令来自 dealy 的反编译 js 源码中，确认 goodsIdStr 是正则爬过来的。
			String pattern = "-g(0xdx0x.*?)\\.html";
			Pattern r = Pattern.compile(pattern);
			Matcher m = r.matcher(uri.toString());
			if (m.find()) {
				return m.group(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return null;
	}

	public GoodsInfoDto getGoodsInfo(String goodsIdStr) {
		String url = spiderConfig.getHost() + "goods/get-goods-info";

		HttpHeaders headers = new HttpHeaders();
		MediaType type = MediaType.parseMediaType("application/x-www-form-urlencoded");
		headers.setContentType(type);
		headers.set("X-Requested-With", "XMLHttpRequest");

		if (spiderConfig.getSpiderLang() == SpiderLang.SAR) {
			headers.set("cookie", "LANG_NAME=ar; LANG_CODE=1;");
		}

		String body = String.format("goodsIdStr=%s", goodsIdStr);
		HttpEntity<String> entity = new HttpEntity<>(body, headers);

		try {
			return restTemplate.postForObject(url, entity, GoodsInfoDto.class);
		} catch (Exception e) {
			e.printStackTrace();
			GoodsInfoDto goodsInfoDto = new GoodsInfoDto();
			goodsInfoDto.setCode(400);
			return goodsInfoDto;
		}
	}

	// https://www.dealy1688.com/topicnew?lcid=DYweekend613&topic_id=150901&title=Buy%201%20Get%201%20Extra%20Free&edtionId=150901&scm=P140966&spm=MOB.HOME.X_P140966.M1719042.L0
	public Buy1Get1ExtraFreeDto getBuyOneGetOneExtraFree() {
		String url = spiderConfig.getHost() + "topic/get-topic-goods-list";
//		String url = "https://www.dealy1688.com/topic/get-topic-goods-list";

		HttpHeaders headers = new HttpHeaders();
		MediaType type = MediaType.parseMediaType("application/x-www-form-urlencoded");
		headers.setContentType(type);
		headers.set("X-Requested-With", "XMLHttpRequest");

		if (spiderConfig.getSpiderLang() == SpiderLang.SAR) {
			headers.set("cookie", "LANG_NAME=ar; LANG_CODE=1;");
		}

		/**
		 * 原始 form data 为
		 * params={"edtionId":150901,"pageNum":2,"catId":466866,"lang":"7","terminalType":10,"appVersion":"1.0.0","needLike":1,"cookieId":"5cfa645ad6899fb6"}
		 */
		String body = "params={\"edtionId\":150901,\"pageNum\":1,\"catId\":466866,\"lang\":\"7\",\"terminalType\":10,\"appVersion\":\"1.0.0\",\"needLike\":1,\"cookieId\":\"5cfa645ad6899fb6\"}";
		HttpEntity<String> entity = new HttpEntity<>(body, headers);

		try {
			return restTemplate.postForObject(url, entity, Buy1Get1ExtraFreeDto.class);
		} catch (Exception e) {
			e.printStackTrace();
			Buy1Get1ExtraFreeDto buy1Get1ExtraFreeDto = new Buy1Get1ExtraFreeDto();
			buy1Get1ExtraFreeDto.setCode(400);
			return buy1Get1ExtraFreeDto;
		}
	}
}
