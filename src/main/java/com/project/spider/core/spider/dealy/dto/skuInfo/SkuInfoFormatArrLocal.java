package com.project.spider.core.spider.dealy.dto.skuInfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SkuInfoFormatArrLocal {
    private Object briefSkuList;
    private Integer count;
    private String discountShowStr;
    private String imgUrl;
    @JsonProperty("is_promote")
    private Integer is_promote;
    @JsonProperty("is_stock")
    private Integer is_stock;
    private String maxStockNumTip;
    private String percentageStr;
    private Float price;
    @JsonProperty("promote_lefttime")
    private Integer promote_lefttime;
    @JsonProperty("promote_price")
    private Float promote_price;
    @JsonProperty("sku_id")
    private Integer sku_id;
    private String stockTip;
}

/*
{
    briefSkuList: {Color: "White", Size: "UK 8 / Label Size:M"}
    count: 1
    discountShowStr: ""
    imgUrl: "http://imcut.dealy1688.com/uploads/jollyimg/imageService/img/goods/2020/03/01/22/05/d36d061e-d5c4-4c4e-a362-f9743e9da1b8.jpg"
    is_promote: 1
    is_stock: 1
    maxStockNumTip: ""
    percentageStr: ""
    price: 9.988848
    promote_lefttime: 0
    promote_price: 7.990014
    sku_id: 59396929
    stockTip: "Only 1 left in the local warehouse"
}
 */
