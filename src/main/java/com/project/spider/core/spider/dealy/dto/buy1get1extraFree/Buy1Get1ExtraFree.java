package com.project.spider.core.spider.dealy.dto.buy1get1extraFree;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Buy1Get1ExtraFree {
	private String currency;
	private String message;
	// edtion 这个单词 dealy 写错了。
	private List<Buy1Get1ExtraFreeEdtionGoods> edtionGoodsList;
	private Integer messageCode;
	private Integer messageType;
	private Buy1Get1ExtraFreePageInfo pageInfo;
	private Integer result;
}

/*
{
	"code": 200,
	"data": {
		"currency": "SAR",
		"edtionGoodsList": [{
			"biTrackingCode": "prod_prs-app_activity_ILAMBDARSACTIVITYINTACT1_1",
			"catId": 3346,
			"firstOnSaleTime": 1504605895,
			"goodsId": 1198862,
			"goodsName": "Coffee Sifter Professional Stainless Steel Chocolate Shaker Cocoa Flour Coffee Sifter Set",
			"goodsUrl": "",
			"imgUrl": "http://imcut.dealy1688.com/uploads/jollyimg/gallery/201804/12/IL20180412150252148.jpg_300x400.jpg",
			"imgeRatio": 2,
			"isLike": 0,
			"likeCount": 13039,
			"promotePrice": 0,
			"promoteType": 0,
			"shopPrice": 11.990344,
			"wholeImgLink": "http://imcut.dealy1688.com/uploads/jollyimg/gallery/201804/12/IL20180412150252148.jpg_300x400.jpg",
			"topicId": 150901
		}, {
			"biTrackingCode": "prod_prs-app_activity_ILAMBDARSACTIVITYINTACT1_2",
			"catId": 3270,
			"firstOnSaleTime": 1543196678,
			"goodsId": 4914848,
			"goodsName": "1Pc Simple Nordic Style Iron Storage Basket Office Documents Files Organizer",
			"goodsUrl": "",
			"imgUrl": "http://imcut.dealy1688.com/uploads/jollyimg/imageService/img/goods/2020/09/25/17/25/960cde30-9f31-4de4-96c6-04ef4007f792.jpg_300x400.jpg",
			"imgeRatio": 2,
			"isLike": 0,
			"likeCount": 6943,
			"promotePrice": 0,
			"promoteType": 0,
			"shopPrice": 48.578858,
			"wholeImgLink": "http://imcut.dealy1688.com/uploads/jollyimg/imageService/img/goods/2020/09/25/17/25/960cde30-9f31-4de4-96c6-04ef4007f792.jpg_300x400.jpg",
			"topicId": 150901
		}, {
			"biTrackingCode": "prod_prs-app_activity_ILAMBDARSACTIVITYINTACT1_3",
			"catId": 494,
			"firstOnSaleTime": 1494417374,
			"goodsId": 701948,
			"goodsName": "Men's Baseball Cap Casual Round Circle Solid Color Letter Theme Hat Accessory",
			"goodsUrl": "",
			"imgUrl": "http://imcut.dealy1688.com/uploads/jollyimg/imageLibrary/201704/292/29/IL201704290937244260.jpg_300x400.jpg",
			"imgeRatio": 2,
			"isLike": 0,
			"likeCount": 4414,
			"promotePrice": 0,
			"promoteType": 0,
			"shopPrice": 10.989596,
			"wholeImgLink": "http://imcut.dealy1688.com/uploads/jollyimg/imageLibrary/201704/292/29/IL201704290937244260.jpg_300x400.jpg",
			"topicId": 150901
		}, {
			"biTrackingCode": "prod_prs-app_activity_ILAMBDARSACTIVITYINTACT1_4",
			"catId": 3618,
			"firstOnSaleTime": 1526623931,
			"goodsId": 3078852,
			"goodsName": "1 Pc String Light Iron Flamingo Design 10 LED Lights Creative DIY Home Light Decor",
			"goodsUrl": "",
			"imgUrl": "http://imcut.dealy1688.com/uploads/jollyimg/imageLibrary/201805/3G2/07/IL201805071759581270.jpg_300x400.jpg",
			"imgeRatio": 2,
			"isLike": 0,
			"likeCount": 615,
			"promotePrice": 0,
			"promoteType": 0,
			"shopPrice": 41.379329,
			"wholeImgLink": "http://imcut.dealy1688.com/uploads/jollyimg/imageLibrary/201805/3G2/07/IL201805071759581270.jpg_300x400.jpg",
			"topicId": 150901
		}, {
			"biTrackingCode": "prod_prs-app_activity_ILAMBDARSACTIVITYINTACT1_5",
			"catId": 2920,
			"firstOnSaleTime": 1531361410,
			"goodsId": 3619428,
			"goodsName": "Women's Beret British Style Vintage Solid Color Ladylike Hat",
			"goodsUrl": "",
			"imgUrl": "http://imcut.dealy1688.com/uploads/jollyimg/imageLibrary/201807/6DG/09/IL201807091713072236.jpg_300x400.jpg",
			"imgeRatio": 2,
			"isLike": 0,
			"likeCount": 3081,
			"promotePrice": 8.990762,
			"promoteType": 0,
			"shopPrice": 22.990586,
			"wholeImgLink": "http://imcut.dealy1688.com/uploads/jollyimg/imageLibrary/201807/6DG/09/IL201807091713072236.jpg_300x400.jpg",
			"topicId": 150901
		}, {
			"biTrackingCode": "prod_prs-app_activity_ILAMBDARSACTIVITYINTACT1_6",
			"catId": 3560,
			"firstOnSaleTime": 1489662481,
			"goodsId": 590408,
			"goodsName": "1Pc 45*200(W*L)cm Wall Stick White Board Kid Learning Aid Creative Wall Decor",
			"goodsUrl": "",
			"imgUrl": "http://imcut.dealy1688.com/uploads/jollyimg/imageLibrary/201703/1SD/15/IL201703151127423775.jpg_300x400.jpg",
			"imgeRatio": 2,
			"isLike": 0,
			"likeCount": 9347,
			"promotePrice": 0,
			"promoteType": 0,
			"shopPrice": 16.179645,
			"wholeImgLink": "http://imcut.dealy1688.com/uploads/jollyimg/imageLibrary/201703/1SD/15/IL201703151127423775.jpg_300x400.jpg",
			"topicId": 150901
		}, {
			"biTrackingCode": "prod_prs-app_activity_ILAMBDARSACTIVITYINTACT1_7",
			"catId": 4812,
			"firstOnSaleTime": 1543571250,
			"goodsId": 4955072,
			"goodsName": "Women's Fashion Watch Trendy Simple Exquisite Round Dial Steel Band Quartz Watch",
			"goodsUrl": "",
			"imgUrl": "http://imcut.dealy1688.com/uploads/jollyimg/imageService/img/goods/2020/01/02/17/30/03ea7b99-a40e-4f6b-a1af-f5f27078cee4.jpg_300x400.jpg",
			"imgeRatio": 2,
			"isLike": 0,
			"likeCount": 13494,
			"promotePrice": 5.331112,
			"promoteType": 3,
			"shopPrice": 26.990916,
			"wholeImgLink": "http://imcut.dealy1688.com/uploads/jollyimg/imageService/img/goods/2020/01/02/17/30/03ea7b99-a40e-4f6b-a1af-f5f27078cee4.jpg_300x400.jpg",
			"topicId": 150901
		}, {
			"biTrackingCode": "prod_prs-app_activity_ILAMBDARSACTIVITYINTACT1_8",
			"catId": 3484,
			"firstOnSaleTime": 1488799404,
			"goodsId": 570228,
			"goodsName": "3Pcs Wall Hooks Set Umbrella Shaped Creative Wall Decorative Pothooks",
			"goodsUrl": "",
			"imgUrl": "http://imcut.dealy1688.com/uploads/jollyimg/imageLibrary/201703/1V5/05/IL201703052202116563.jpg_300x400.jpg",
			"imgeRatio": 2,
			"isLike": 0,
			"likeCount": 3621,
			"promotePrice": 0,
			"promoteType": 0,
			"shopPrice": 10.779332,
			"wholeImgLink": "http://imcut.dealy1688.com/uploads/jollyimg/imageLibrary/201703/1V5/05/IL201703052202116563.jpg_300x400.jpg",
			"topicId": 150901
		}, {
			"biTrackingCode": "prod_prs-app_activity_ILAMBDARSACTIVITYINTACT1_9",
			"catId": 3558,
			"firstOnSaleTime": 1504779218,
			"goodsId": 1215082,
			"goodsName": "Mask Simple Solid Color Warm Dustproof Gauze Mask Couple Mask",
			"goodsUrl": "",
			"imgUrl": "http://imcut.dealy1688.com/uploads/jollyimg/imageLibrary/201709/316/06/IL201709061455195416.jpg_300x400.jpg",
			"imgeRatio": 2,
			"isLike": 0,
			"likeCount": 21380,
			"promotePrice": 2.379438,
			"promoteType": 3,
			"shopPrice": 10.779332,
			"wholeImgLink": "http://imcut.dealy1688.com/uploads/jollyimg/imageLibrary/201709/316/06/IL201709061455195416.jpg_300x400.jpg",
			"topicId": 150901
		}, {
			"biTrackingCode": "prod_prs-app_activity_ILAMBDARSACTIVITYINTACT1_10",
			"catId": 3128,
			"firstOnSaleTime": 1568114649,
			"goodsId": 7368909,
			"goodsName": "Jewelry Box Creative 36 Grids Durable Rings Earrings Organizer",
			"goodsUrl": "",
			"imgUrl": "http://imcut.dealy1688.com/uploads/jollyimg/imageService/img/goods/2019/09/07/13/45/8a5c6d7c-46e1-48da-9cd3-66c8f1cfeb0a.jpg_300x400.jpg",
			"imgeRatio": 1,
			"isLike": 0,
			"likeCount": 1293,
			"promotePrice": 0,
			"promoteType": 0,
			"shopPrice": 16.98876,
			"wholeImgLink": "http://imcut.dealy1688.com/uploads/jollyimg/imageService/img/goods/2019/09/07/13/45/8a5c6d7c-46e1-48da-9cd3-66c8f1cfeb0a.jpg_300x400.jpg",
			"topicId": 150901
		}, {
			"biTrackingCode": "prod_prs-app_activity_ILAMBDARSACTIVITYINTACT1_11",
			"catId": 3770,
			"firstOnSaleTime": 1571733059,
			"goodsId": 7978455,
			"goodsName": "HOME BI Home Books Organization Shelf Simple Four Layer Iron Shelf",
			"goodsUrl": "",
			"imgUrl": "http://imcut.dealy1688.com/uploads/jollyimg/imageService/img/goods/2019/10/17/19/40/3dab2b7a-bc6e-4bca-aea3-09f127a6343b.jpg_300x400.jpg",
			"imgeRatio": 1,
			"isLike": 0,
			"likeCount": 1197,
			"promotePrice": 24.600832,
			"promoteType": 3,
			"shopPrice": 88.180262,
			"wholeImgLink": "http://imcut.dealy1688.com/uploads/jollyimg/imageService/img/goods/2019/10/17/19/40/3dab2b7a-bc6e-4bca-aea3-09f127a6343b.jpg_300x400.jpg",
			"topicId": 150901
		}, {
			"biTrackingCode": "prod_prs-app_activity_ILAMBDARSACTIVITYINTACT1_12",
			"catId": 3560,
			"firstOnSaleTime": 1529472188,
			"goodsId": 3403952,
			"goodsName": "10Pcs LED Night Light Cartoon Colorful Butterfly Design Adhesive Lights",
			"goodsUrl": "",
			"imgUrl": "http://imcut.dealy1688.com/uploads/jollyimg/imageLibrary/201806/70J/08/IL201806081032163488.jpg_300x400.jpg",
			"imgeRatio": 2,
			"isLike": 0,
			"likeCount": 8731,
			"promotePrice": 0,
			"promoteType": 0,
			"shopPrice": 21.579957,
			"wholeImgLink": "http://imcut.dealy1688.com/uploads/jollyimg/imageLibrary/201806/70J/08/IL201806081032163488.jpg_300x400.jpg",
			"topicId": 150901
		}],
		"message": "Success",
		"messageCode": "0",
		"messageType": 0,
		"pageInfo": {
			"isLastPage": 0,
			"pageNum": 1,
			"pageSize": 12
		},
		"result": 0
	},
	"message": "Success!"
}
 */
