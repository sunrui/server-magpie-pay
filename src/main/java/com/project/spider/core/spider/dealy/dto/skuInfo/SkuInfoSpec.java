package com.project.spider.core.spider.dealy.dto.skuInfo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SkuInfoSpec {
    private String keyName;
    private String keyNameTran;
    private Integer showSizeGuide;
    private Integer showCountrySizeList;
    private String curSizeType;
    private List<SkuInfoSpecValue> valueList;
    private Boolean showImageSku;
}

/*
{
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
}
 */
