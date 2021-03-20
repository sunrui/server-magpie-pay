package com.project.spider.core.spider.dealy.dto.goodsInfo;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;

@Getter
@Setter
public class GoodsInfo {
    private Object brandInfo;
    private String currency;
    private List<GoodsInfoGallery> galleryList;

    // dealy 很不规范，有时候返回 [] 有时候返回 {}，这在 java 反序列号化会报错。
    private Object flashSaleInfo;
//    private GoodsInfoFlashSaleInfo flashSaleInfo;
    private GoodsInfoDetailInfo goodsDetailInfo;
    private GoodsInfoDetailExtInfo goodsDetailExtInfo;
    private GoodsInfoSkuInfo skuInfo;
    private HashMap<String, GoodsInfoThumbImgAttr> thumbImgArr;
    private String goodsImgUrl;
    private Integer isAddBag;
    private String shopPriceStr;
    private Integer isPromote;
    private String orgPriceStr;
    private String warnStockNumStr;
    private Object paramData;
    private Object analysisTrack;
}

/*
{
	"code": 200,
	"data": {
		"brandInfo": {
			"brandId": 0
		},
		"currency": "SAR",
		"galleryList": [{
			"imgId": 7652110,
			"wholeImgLink": "http://imcut.dealy1688.com/uploads/jollyimg/imageLibrary/201709/1SC/13/IL201709130949546460.jpg_600x800x80.jpg",
			"originalImg": "http://imcut.dealy1688.com/uploads/jollyimg/imageLibrary/201709/1SC/13/IL201709130949546460.jpg"
		}, {
			"imgId": 7652112,
			"wholeImgLink": "http://imcut.dealy1688.com/uploads/jollyimg/imageLibrary/201709/1SC/13/IL201709130949540620.jpg_600x800x80.jpg",
			"originalImg": "http://imcut.dealy1688.com/uploads/jollyimg/imageLibrary/201709/1SC/13/IL201709130949540620.jpg"
		}, {
			"imgId": 7652114,
			"wholeImgLink": "http://imcut.dealy1688.com/uploads/jollyimg/imageLibrary/201709/1SC/13/IL201709130949545342.jpg_600x800x80.jpg",
			"originalImg": "http://imcut.dealy1688.com/uploads/jollyimg/imageLibrary/201709/1SC/13/IL201709130949545342.jpg"
		}, {
			"imgId": 7652116,
			"wholeImgLink": "http://imcut.dealy1688.com/uploads/jollyimg/imageLibrary/201709/1SC/13/IL201709130949555660.jpg_600x800x80.jpg",
			"originalImg": "http://imcut.dealy1688.com/uploads/jollyimg/imageLibrary/201709/1SC/13/IL201709130949555660.jpg"
		}, {
			"imgId": 7652118,
			"wholeImgLink": "http://imcut.dealy1688.com/uploads/jollyimg/imageLibrary/201709/1SC/13/IL201709130950205478.jpg_600x800x80.jpg",
			"originalImg": "http://imcut.dealy1688.com/uploads/jollyimg/imageLibrary/201709/1SC/13/IL201709130950205478.jpg"
		}, {
			"imgId": 7652120,
			"wholeImgLink": "http://imcut.dealy1688.com/uploads/jollyimg/imageLibrary/201709/1SC/13/IL201709130950203374.jpg_600x800x80.jpg",
			"originalImg": "http://imcut.dealy1688.com/uploads/jollyimg/imageLibrary/201709/1SC/13/IL201709130950203374.jpg"
		}, {
			"imgId": 43916781,
			"wholeImgLink": "http://imcut.dealy1688.com/uploads/jollyimg/imageService/img/goods/2019/06/06/18/20/e6fa0f2f-b186-4c9a-a03c-f3eecd9349d3.jpg_600x800x80.jpg",
			"originalImg": "http://imcut.dealy1688.com/uploads/jollyimg/imageService/img/goods/2019/06/06/18/20/e6fa0f2f-b186-4c9a-a03c-f3eecd9349d3.jpg"
		}],
		"flashSaleInfo": {
			"countdown": 22884,
			"deepLink": "jollychic://specialflash?groupid=47027&tracecode=jumpflashsale47027&title=Clearance Sale",
			"endTime": 1608710400,
			"flashSaleId": 32558947,
			"groupId": 47027,
			"groupType": 1,
			"isFollow": 0,
			"maxSaleNum": 300,
			"maxSaleNumPerId": 10,
			"remainSaleNum": 133,
			"saleNum": 167,
			"startTime": 1608537600,
			"status": 2,
			"flashSaleTip": ""
		},
		"goodsDetailExtInfo": {
			"faqLink": "http://h5app.dealy1688.com/helpCenter20170104.html?whichPage=goodsDetailFAQ&lang=0&countryCode=SA&appVersion=10&frm=11&appTypeId=7&isInDetail=1",
			"goodsType": 0,
			"imgTextLink": "http://h5app.dealy1688.com/goodsDetailDes20170531.html?loading=1&goodsId=1259336&frm=11&appVersion=10&lang=0&currency=SAR&appTypeId=7&cookieId=EF0E411D-B200-8FAB-D8B3-87B43328048B&countryCode=SA&isInDetail=1",
			"isAd": 0,
			"isComment": 1,
			"isIncludeTax": 1,
			"isLike": 0,
			"isSizeGuide": 1,
			"salesCount": 33,
			"shopId": 0,
			"sizeGuideLink": "http://h5app.dealy1688.com/sizeGuide20180620.html?goodsId=1259336&catId=5486&appVersion=10&lang=0&frm=11&countryCode=SA&appTypeId=7&cookieId=EF0E411D-B200-8FAB-D8B3-87B43328048B&isInDetail=1"
		},
		"goodsDetailInfo": {
			"catId": 5486,
			"goodsId": 1259336,
			"goodsName": "Women's 5 Pairs Crew Socks Sweet Striped Cute Animal Cartoon Pattern Socks",
			"imgeRatio": 2,
			"inStock": 0,
			"likeCount": 27142,
			"promotePriceMax": 2.57107,
			"promotePriceMin": 2.57107,
			"shareLink": "http://5ts.dealy1688.com/onelink?lang=0&appTypeId=7&userId=null&jy_url_app=dealy%3A%2F%2Fgoods%2F1259336&jy_url_wap=http%3A%2F%2Fwww.dealy1688.com&zy_cv=App_Share%7CReferral%7C0%7C(not%20set)%7C(not%20set)%7C",
			"shopPriceMax": 13.989178,
			"shopPriceMin": 13.989178
		},
		"skuInfo": {
			"skuColorImgList": ["http://imcut.dealy1688.com/uploads/jollyimg/imageLibrary/201709/1SC/13/IL201709130949546460.jpg"],
			"skuColorTips": "Total 1 color is available",
			"skuValue": "Color,Size"
		},
		"thumbImgArr": {
			"7652110": {
				"imgId": 7652110,
				"wholeImgLink": "http://imcut.dealy1688.com/uploads/jollyimg/imageLibrary/201709/1SC/13/IL201709130949546460.jpg_600x800x80.jpg",
				"originalImg": "http://imcut.dealy1688.com/uploads/jollyimg/imageLibrary/201709/1SC/13/IL201709130949546460.jpg"
			},
			"7652112": {
				"imgId": 7652112,
				"wholeImgLink": "http://imcut.dealy1688.com/uploads/jollyimg/imageLibrary/201709/1SC/13/IL201709130949540620.jpg_600x800x80.jpg",
				"originalImg": "http://imcut.dealy1688.com/uploads/jollyimg/imageLibrary/201709/1SC/13/IL201709130949540620.jpg"
			},
			"7652114": {
				"imgId": 7652114,
				"wholeImgLink": "http://imcut.dealy1688.com/uploads/jollyimg/imageLibrary/201709/1SC/13/IL201709130949545342.jpg_600x800x80.jpg",
				"originalImg": "http://imcut.dealy1688.com/uploads/jollyimg/imageLibrary/201709/1SC/13/IL201709130949545342.jpg"
			},
			"7652116": {
				"imgId": 7652116,
				"wholeImgLink": "http://imcut.dealy1688.com/uploads/jollyimg/imageLibrary/201709/1SC/13/IL201709130949555660.jpg_600x800x80.jpg",
				"originalImg": "http://imcut.dealy1688.com/uploads/jollyimg/imageLibrary/201709/1SC/13/IL201709130949555660.jpg"
			},
			"7652118": {
				"imgId": 7652118,
				"wholeImgLink": "http://imcut.dealy1688.com/uploads/jollyimg/imageLibrary/201709/1SC/13/IL201709130950205478.jpg_600x800x80.jpg",
				"originalImg": "http://imcut.dealy1688.com/uploads/jollyimg/imageLibrary/201709/1SC/13/IL201709130950205478.jpg"
			},
			"7652120": {
				"imgId": 7652120,
				"wholeImgLink": "http://imcut.dealy1688.com/uploads/jollyimg/imageLibrary/201709/1SC/13/IL201709130950203374.jpg_600x800x80.jpg",
				"originalImg": "http://imcut.dealy1688.com/uploads/jollyimg/imageLibrary/201709/1SC/13/IL201709130950203374.jpg"
			},
			"43916781": {
				"imgId": 43916781,
				"wholeImgLink": "http://imcut.dealy1688.com/uploads/jollyimg/imageService/img/goods/2019/06/06/18/20/e6fa0f2f-b186-4c9a-a03c-f3eecd9349d3.jpg_600x800x80.jpg",
				"originalImg": "http://imcut.dealy1688.com/uploads/jollyimg/imageService/img/goods/2019/06/06/18/20/e6fa0f2f-b186-4c9a-a03c-f3eecd9349d3.jpg"
			}
		},
		"goodsImgUrl": "http://imcut.dealy1688.com/uploads/jollyimg/imageLibrary/201709/1SC/13/IL201709130949546460.jpg_600x800x80.jpg",
		"isAddBag": 1,
		"shopPriceStr": "<span data-price=\"2.57107\" class=\"goods-price\"></span>",
		"isPromote": 1,
		"orgPriceStr": "<del data-nocurrency=\"true\" data-price=\"13.989178\" class=\"goods-price\"></del>",
		"warnStockNumStr": "",
		"paramData": {
			"appDownData": {
				"hasAppDown": true,
				"appLink": "https://dealy.onelink.me/XkIx/7fba5789"
			}
		},
		"analysisTrack": {
			"contentViewMobile": "content-view-product",
			"jollychicDomain": "m.dealy1688.com",
			"jollychicCountry": "SA",
			"jollychicLanguage": "en",
			"jollychicCurrency": "sar",
			"gaTrackingData": [],
			"awTrackingData": {
				"event": "productpage_view",
				"ecomm_pagetype": "product",
				"ecomm_prodid": 1259336,
				"ecomm_totalvalue": 13.989178,
				"ecomm_category": "",
				"user_id": "5cfa645ad6899fb6"
			},
			"criteoTrackingData": {
				"hashedEmail": "",
				"siteType": "m",
				"eventType": "viewItem",
				"orderId": "",
				"category": "",
				"itemInfo": 1259336
			},
			"criteoTrackPixelEvent": "viewItem",
			"criteoTrackPixelCategory": "",
			"jollyCatId": 1259336,
			"jollychicOrderTotalVal": 13.989178,
			"jollychicOrderId": "",
			"jollyTotalValCurrency": 0,
			"jollyDeepLinkPath": "jollychic://goods/1259336"
		}
	},
	"message": "Success!"
}
 */
