package com.project.spider.core.spider.dealy.dto.skuInfo;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;

@Getter
@Setter
public class SkuInfo {
    private Integer catId;
    private String currency;
    private Integer depotCoverageAreaId;
    private Float flashSalePriceMax;
    private Float flashSalePriceMin;
    private Integer goodsId;
    private String goodsName;
    private String goodsSn;
    private Integer goodsType;
    private String imgUrl;
    private Integer imgeRatio;
    private Integer inStock;
    private Integer isAllowedLocalWarehouse;
    private Integer isShowZeroPromotePrice;
    private Integer isSizeGuide;
    private Integer labelType;
    private String localWarehouseName;
    private Integer maxCount;
    private String message;
    private String messageCode;
    private Integer messageType;
    private Float promotePriceMax;
    private Float promotePriceMin;
    private Integer result;
    private Integer selectLocalWarehouse;
    private Float shopPriceMax;
    private Float shopPriceMin;
    private Integer showLocalWarehouse;
    private String sizeGuideLink;
    private String sizeGuideText;
    private Integer sizeStyleType;
    private String wholeImgLink;
    private Object countrySizeListArr;
    private Object skuFormatArr;
    private HashMap<String, SkuInfoFormatArrLocal> skuFormatArrLocal;
    private Object priceResult;
    private Integer isFlashSale;
    private String discountShow;
    private List<SkuInfoSpec> skuInfo;
    private Object paramData;
    private String sizeGuideRecommendText;
}

/*
{
	"code": 200,
	"data": {
		"catId": 3466,
		"currency": "SAR",
		"depotCoverageAreaId": 2,
		"flashSalePriceMax": 5.030355,
		"flashSalePriceMin": 5.030355,
		"goodsId": 9830559,
		"goodsName": "Toothbrush holder and brushes",
		"goodsSn": "9P1JH00J105NS",
		"goodsType": 0,
		"imgUrl": "/imageService/img/goods/2020/04/17/14/40/3573bab1-9670-42dc-b75e-d8d239791e31.jpg",
		"imgeRatio": 1,
		"inStock": 0,
		"isAllowedLocalWarehouse": 1,
		"isShowZeroPromotePrice": 0,
		"isSizeGuide": 0,
		"labelType": 4,
		"localWarehouseName": "Ship from Saudi",
		"maxCount": 999,
		"message": "Success",
		"messageCode": "0",
		"messageType": 0,
		"promotePriceMax": 5.030355,
		"promotePriceMin": 5.030355,
		"result": 0,
		"selectLocalWarehouse": 1,
		"shopPriceMax": 7.721196,
		"shopPriceMin": 7.721196,
		"showLocalWarehouse": 1,
		"sizeGuideLink": "http://h5app.dealy1688.com/sizeGuide20180620.html?goodsId=9830559&catId=3466&appTypeId=7",
		"sizeGuideText": "Size Guide",
		"sizeStyleType": 0,
		"wholeImgLink": "http://imcut.dealy1688.com/uploads/jollyimg/imageService/img/goods/2020/04/17/14/40/3573bab1-9670-42dc-b75e-d8d239791e31.jpg",
		"countrySizeListArr": [],
		"skuFormatArr": {
			"2:1395": {
				"sku_id": 62320949,
				"briefSkuList": {
					"Color": "White",
					"Size": "One Size"
				},
				"discountShowStr": "",
				"is_stock": 1,
				"count": 23,
				"price": 7.721196,
				"is_promote": 1,
				"promote_price": 5.030355,
				"imgUrl": "http://imcut.dealy1688.com/uploads/jollyimg/imageService/img/goods/2020/04/17/14/40/0502254b-1657-43dc-8357-f4892a2cb6e7.jpg",
				"promote_lefttime": 0,
				"stockTip": "",
				"maxStockNumTip": "Only 23 left in stock",
				"percentageStr": ""
			}
		},
		"skuFormatArrLocal": {
			"2:1395": {
				"sku_id": 62320949,
				"briefSkuList": {
					"Color": "White",
					"Size": "One Size"
				},
				"discountShowStr": "",
				"is_stock": 1,
				"count": 23,
				"price": 7.721196,
				"is_promote": 1,
				"promote_price": 5.030355,
				"imgUrl": "http://imcut.dealy1688.com/uploads/jollyimg/imageService/img/goods/2020/04/17/14/40/0502254b-1657-43dc-8357-f4892a2cb6e7.jpg",
				"promote_lefttime": 0,
				"stockTip": "",
				"maxStockNumTip": "Only 23 left in the local warehouse",
				"percentageStr": ""
			}
		},
		"priceResult": {
			"orgPrice": "<del data-nocurrency=\"true\" data-price=\"7.721196\" class=\"goods-price\"></del>",
			"isPromote": 1,
			"shopPrice": "<span data-price=\"5.030355\" class=\"goods-price\"></span>"
		},
		"isFlashSale": 1,
		"discountShow": "",
		"skuInfo": [{
			"keyName": "Color",
			"keyNameTran": "Color",
			"showSizeGuide": 0,
			"showCountrySizeList": 0,
			"curSizeType": "",
			"valueList": [{
				"isSelect": 1,
				"valueId": 2,
				"valueName": "White",
				"valueNameTran": "White",
				"imgKeyId": -1,
				"wholeImgLink": "http://imcut.dealy1688.com/uploads/jollyimg/imageService/img/goods/2020/04/17/14/40/0502254b-1657-43dc-8357-f4892a2cb6e7.jpg_210x280x80.jpg",
				"originalImg": "http://imcut.dealy1688.com/uploads/jollyimg/imageService/img/goods/2020/04/17/14/40/0502254b-1657-43dc-8357-f4892a2cb6e7.jpg",
				"propertyList": "",
				"sizeTipText": ""
			}],
			"showImgSku": true
		}, {
			"keyName": "Size",
			"keyNameTran": "Size",
			"showSizeGuide": 0,
			"showCountrySizeList": 1,
			"curSizeType": "INT",
			"valueList": [{
				"isSelect": 1,
				"valueId": 1395,
				"valueName": "One Size",
				"valueNameTran": "One Size",
				"imgKeyId": -1,
				"wholeImgLink": "",
				"originalImg": "",
				"propertyList": "",
				"sizeTipText": ""
			}],
			"showImgSku": false
		}],
		"paramData": {
			"skuId": 0,
			"topicId": false
		},
		"sizeGuideRecommendText": ""
	},
	"message": "Success!"
}
 */
