package com.project.spider.core.spider.dealy.dto.skuInfo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SkuInfoSpecValue {
    private Integer isSelect;
    private Integer valueId;
    private String valueName;
    private String valueNameTran;
    private Integer imgKeyId;
    private String wholeImgLink;
    private String originalImg;
    private Object propertyList;
    private String sizeTipText;
}

/*
{
"isSelect": 1,
"valueId": 2,
"valueName": "White",
"valueNameTran": "White",
"imgKeyId": -1,
"wholeImgLink": "http://imcut.dealy1688.com/uploads/jollyimg/imageService/img/goods/2020/04/17/14/40/0502254b-1657-43dc-8357-f4892a2cb6e7.jpg_210x280x80.jpg",
"originalImg": "http://imcut.dealy1688.com/uploads/jollyimg/imageService/img/goods/2020/04/17/14/40/0502254b-1657-43dc-8357-f4892a2cb6e7.jpg",
"propertyList": "",
"sizeTipText": ""
}
 */
