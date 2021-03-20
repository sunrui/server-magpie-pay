package com.project.spider.core.spider.dealy.dto.goodsInfo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GoodsInfoSkuInfo {
    private List<String> skuColorImgList;
    private String skuColorTips;
    private String skuValue;
}

/*
{
    "skuColorImgList": ["http://imcut.dealy1688.com/uploads/jollyimg/imageLibrary/201709/1SC/13/IL201709130949546460.jpg"],
    "skuColorTips": "Total 1 color is available",
    "skuValue": "Color,Size"
}
 */
