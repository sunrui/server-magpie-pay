package com.project.spider.core.spider.dealy.dto.buy1get1extraFree;

import lombok.Getter;
import lombok.Setter;

/**
 * 买一送一商品类集合
 *
 * 备注: Edtion 这个单词 dealy 写错了。
 */
@Getter
@Setter
public class Buy1Get1ExtraFreeEdtionGoods {
	private String biTrackingCode;
	private Integer catId;
	private Integer firstOnSaleTime;
	private Integer goodsId;
	private String goodsName;
	private String goodsUrl;
	private String imgUrl;
	// dealy 单词写错了，反序列化必须对应
	private Integer imgeRatio;
	private Integer isLike;
	private Integer likeCount;
	private Integer promotePrice;
	private Integer promoteType;
	private Float shopPrice;
	private String wholeImgLink;
	private Integer topicId;
}

/*
{
	"biTrackingCode": "prod_prs-app_activity_ILAMBDARSACTIVITYINTACT1_13",
	"catId": 8565,
	"firstOnSaleTime": 1511346346,
	"goodsId": 1728760,
	"goodsName": "سماعة اذن - بمواصفات عالمية ، بمقاس 3.5 سم",
	"goodsUrl": "",
	"imgUrl": "http://imcut.dealy1688.com/uploads/jollyimg/imageLibrary/201711/20X/14/IL201711141537113500.jpg_300x400.jpg",
	"imgeRatio": 2,
	"isLike": 0,
	"likeCount": 1639,
	"promotePrice": 0,
	"promoteType": 0,
	"shopPrice": 11.990344,
	"wholeImgLink": "http://imcut.dealy1688.com/uploads/jollyimg/imageLibrary/201711/20X/14/IL201711141537113500.jpg_300x400.jpg",
	"topicId": 150901
}
 */
