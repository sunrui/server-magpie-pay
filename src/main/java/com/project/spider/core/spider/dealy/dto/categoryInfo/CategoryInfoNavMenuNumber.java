package com.project.spider.core.spider.dealy.dto.categoryInfo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryInfoNavMenuNumber {
    private String contentCode; // 三级目录 keyId
    private Integer id;
    private String targetId;
    private String targetImg;
    private String targetName;
    private Integer targetStyle;
    private Integer targetType;
    private String url;
    private String spm;
}

/*
"0": {
    "contentCode": "5408",
    "id": 21059,
    "targetId": "5408",
    "targetImg": "http://imcut.dealy1688.com/uploads/category/style_category/6e30b03b-3235-4a40-950d-bcdfb8524dd9.jpg",
    "targetName": "Drinkware",
    "targetStyle": 3,
    "targetType": 1,
    "url": "drinkware-c5408?goBack=1",
    "spm": "CAT.C20987.C21055.C21059"
}
 */
