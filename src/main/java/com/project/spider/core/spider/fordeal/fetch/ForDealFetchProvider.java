package com.project.spider.core.spider.fordeal.fetch;

import com.project.spider.core.spider.SpiderConfig;
import com.project.spider.core.spider.SpiderLang;
import com.project.spider.core.spider.SpiderRefer;
import com.project.spider.core.spider.dealy.dto.goodsInfo.GoodsInfoDto;
import com.project.spider.core.spider.fordeal.fetch.dto.dwpPandoraCategoryTree.DwpPandoraCategoryTreeDto;
import com.project.spider.core.spider.fordeal.fetch.dto.dwpPandoraSearch.DwpPandoraSearchDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

/**
 * 爬取 fordeal 相关
 */
@Service
public class ForDealFetchProvider {
	@Autowired
	private RestTemplate restTemplate;
	@Getter
	@Setter
	private SpiderConfig spiderConfig = forDealEn;

	public static final SpiderConfig forDealEn = new SpiderConfig(SpiderLang.ENGLISH, "https://gw.fordeal.com/gw/", SpiderRefer.FOR_DEAL);

	/**
	 * 获取类目
	 */
	public DwpPandoraCategoryTreeDto getDwpPandoraCategoryTree() {
		/**
		 * 注意！！！fordeal 有签名，如果是签名不正确的很可能被服务器记录日志 IP，所以调试信息要翻墙。
		 */
		long ct = new Date().getTime(); // 这个时间在一定时间内会失效。
		String sign = "hello world";
//		data={"code":"category_tree","needTitle":true}&gw_ver=1&plat=h5&ct=1609901498184&appname=fordeal&sign=c4fb7ba33c63d162ae78867bb6351d65
		String param = "{\"code\":\"category_tree\",\"needTitle\":true}&gw_ver=1&plat=h5&ct=%d&appname=fordeal&sign=%s";
		param = String.format(param, ct, sign);

		/*
		// sign 加密算法在这里，js 代码已被混淆
https://s4.forcloudcdn.com/-/libs/fd-url/1.3.3/url.js,libs/fd-dwp/1.8.1/dwp.js,libs/fd-dce/1.0.1/dce.js,libs/fd-native-app/1.2.8/native.js,libs/fd-f-dot/0.0.5/fDot.js,libs/fd-logger/1.8.2/logger.js,libs/fd-tracker/2.2.0/tracker.js,libs/fd-promotion/1.5.9/promotion.js?v=1
		 */
//		String url = spiderConfig.getHost() + "dwp.pandora.category_tree/1?" + param;

		String url = "";


		HttpHeaders headers = new HttpHeaders();
		headers.set("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 11_1_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36");

		try {
			return restTemplate.getForObject(url, DwpPandoraCategoryTreeDto.class, new HttpEntity<>(null, headers));
		} catch (Exception e) {
			e.printStackTrace();
			DwpPandoraCategoryTreeDto dwpPandoraCategoryTreeDto = new DwpPandoraCategoryTreeDto();
			dwpPandoraCategoryTreeDto.setCode(400);
			return dwpPandoraCategoryTreeDto;
		}
	}

	/*
	fordeal 爬包分析

搜索女装地址
https://www.fordeal.com/zh-SA/women-c130000036?customer_trace=1.word.4.4.130000036..5of3kPnrsghNMh.mod_CategoryNav-scene_jump-idx_2-page_home.2

详情某一件女装的详情
https://www.fordeal.com/zh-SA/detail/20135020?customer_trace=1.fc.130000036.2.20135020.1245-1114-946-1256-1342-1058.5of2ZJnrvFK9wq.page_pcFdCategory-mod_PandoraWallItem-sc_raw109-bt_38-sf_230-ctmBizTag_1-pg_1-fb_1-sid_5a0e5b3e5a-scene_jump-idx_1.1

	 */

	public DwpPandoraSearchDto getDwpPandoraSearch() {
		String url = "https://gw.fordeal.com/gw/dwp.pandora.search/1?data=%7B%22code%22%3A%22category_search%22%2C%22f%22%3A%22%22%2C%22sort%22%3A%22score_20%22%2C%22fcid%22%3A%22130000036%22%2C%22deepLinkType%22%3A%22%22%2C%22top_item%22%3A%22%22%2C%22page%22%3A2%2C%22cparam%22%3A%22cparam_eyJleHQiOnt9LCJzaWQiOiI0ZTI3Mjk4MzNlIn0%22%2C%22pageSize%22%3A40%7D&gw_ver=1&plat=pc&ct=1610019049342&appname=fordeal&sign=67c88de8a0a9e04f94f3510d549ad604";

		try {
			return restTemplate.getForObject(url, DwpPandoraSearchDto.class);
		} catch (Exception e) {
			e.printStackTrace();
			DwpPandoraSearchDto dwpPandoraSearchDto = new DwpPandoraSearchDto();
			dwpPandoraSearchDto.setCode(400);
			return dwpPandoraSearchDto;
		}
	}
}
