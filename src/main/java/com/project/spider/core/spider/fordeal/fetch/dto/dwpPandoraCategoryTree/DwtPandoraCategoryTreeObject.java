package com.project.spider.core.spider.fordeal.fetch.dto.dwpPandoraCategoryTree;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DwtPandoraCategoryTreeObject {
	private String clientUrl;
	private String path;
	private String img;
	private String enTitle;
	private Integer catId;
	private String name;
	private String title;
	private Boolean canViewAll;
	private String ctm;
	private List<DwtPandoraCategoryTreeObject> sons;
}

/*
{
	"client_url": "fordeal://category/90001024?sf=7&customer_trace=1.word.7.4.90001024..5of3rbnrlCS257.",
	"path": "推荐",
	"img": "http://s3.forcloudcdn.com/banners/d7fbc2a29cf6455a9437f9f82e0db4b2.jpg",
	"sons": [{
		"client_url": "fordeal://category/90001025?sf=7&customer_trace=1.word.7.4.90001025..5of3rbnrlCS257.",
		"path": "最热",
		"img": "http://s3.forcloudcdn.com/images/cats/70000408.png",
		"sons": [{
			"client_url": "fordeal://category/130000038?sf=7&customer_trace=1.word.7.4.130000038..5of3rbnrlCS257.",
			"path": "女士连衣裙",
			"img": "https://s3.forcloudcdn.com/dmc/47ce757e-54ff-4a6c-b1d8-fc7738cd79b6-225x225.jpg",
			"enTitle": "Women's dress",
			"cat_id": 130000038,
			"name": "连衣裙",
			"title": "连衣裙",
			"can_view_all": false,
			"ctm": "1.word.7.4.130000038..5of3rbnrlCS257."
		}, {
			"client_url": "fordeal://category/130000168?sf=7&customer_trace=1.word.7.4.130000168..5of3rbnrlCS257.",
			"path": "女士休闲两件套",
			"img": "https://s3.forcloudcdn.com/dmc/69cfb4c3-67ec-4bf1-a988-918fcd79867f-150x150.png",
			"enTitle": "Casual",
			"cat_id": 130000168,
			"name": "休闲",
			"title": "休闲",
			"can_view_all": false,
			"ctm": "1.word.7.4.130000168..5of3rbnrlCS257."
		}, {
			"client_url": "fordeal://category/130000755?sf=7&customer_trace=1.word.7.4.130000755..5of3rbnrlCS257.",
			"path": "厨房用品",
			"img": "http://s3.forcloudcdn.com/images/cats/15502294185c669faa1a738.png",
			"enTitle": "HOME Kitchen Tools",
			"cat_id": 130000755,
			"name": "厨房用品",
			"title": "厨房用品",
			"can_view_all": false,
			"ctm": "1.word.7.4.130000755..5of3rbnrlCS257."
		}, {
			"client_url": "fordeal://category/130001612?sf=7&customer_trace=1.word.7.4.130001612..5of3rbnrlCS257.",
			"path": "发箍",
			"img": "http://s3.forcloudcdn.com/banners/e71a9ac9d2d44e76858c59e883739d13.png",
			"enTitle": "hairband",
			"cat_id": 130001612,
			"name": "发箍",
			"title": "发箍",
			"can_view_all": false,
			"ctm": "1.word.7.4.130001612..5of3rbnrlCS257."
		}, {
			"client_url": "fordeal://category/130000505?sf=7&customer_trace=1.word.7.4.130000505..5of3rbnrlCS257.",
			"path": "婴儿用品",
			"img": "http://s3.forcloudcdn.com/banners/77c5fe5b64294995a7c829c660e6a614.jpg",
			"enTitle": "Baby Products",
			"cat_id": 130000505,
			"name": "婴儿用品",
			"title": "婴儿用品",
			"can_view_all": false,
			"ctm": "1.word.7.4.130000505..5of3rbnrlCS257."
		}, {
			"client_url": "fordeal://category/130000565?sf=7&customer_trace=1.word.7.4.130000565..5of3rbnrlCS257.",
			"path": "女孩服装",
			"img": "https://s3.forcloudcdn.com/dmc/e60fc25c-268f-4e43-87f9-ed4730c663d3-225x225.png",
			"enTitle": "Girls Wear",
			"cat_id": 130000565,
			"name": "女孩服装",
			"title": "女孩服装",
			"can_view_all": false,
			"ctm": "1.word.7.4.130000565..5of3rbnrlCS257."
		}, {
			"client_url": "fordeal://category/130000224?sf=7&customer_trace=1.word.7.4.130000224..5of3rbnrlCS257.",
			"path": "男士运动上衣",
			"img": "http://s3.forcloudcdn.com/dmc/img/81f9a269/ad90071a9ae477694912a51f3ff95f72-320x320.png",
			"enTitle": "Tops",
			"cat_id": 130000224,
			"name": "运动上衣",
			"title": "运动上衣",
			"can_view_all": false,
			"ctm": "1.word.7.4.130000224..5of3rbnrlCS257."
		}, {
			"client_url": "fordeal://category/130000742?sf=7&customer_trace=1.word.7.4.130000742..5of3rbnrlCS257.",
			"path": "灯具灯饰",
			"img": "http://s3.forcloudcdn.com/banners/65403fc5422e48dab80927938d2bcef2.png",
			"enTitle": "Lighting",
			"cat_id": 130000742,
			"name": "灯具灯饰",
			"title": "灯具灯饰",
			"can_view_all": false,
			"ctm": "1.word.7.4.130000742..5of3rbnrlCS257."
		}],
		"enTitle": "Hot",
		"cat_id": 90001025,
		"name": "最热",
		"title": "最热",
		"can_view_all": false,
		"ctm": "1.word.7.4.90001025..5of3rbnrlCS257."
	}
 */
