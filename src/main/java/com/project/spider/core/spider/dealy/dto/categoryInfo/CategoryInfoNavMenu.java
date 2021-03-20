package com.project.spider.core.spider.dealy.dto.categoryInfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryInfoNavMenu {
    private Integer id;
    private Integer isAll;
    private String showName;
    private String url;
    @JsonProperty("0")
    private CategoryInfoNavMenuNumber zero;
    @JsonProperty("1")
    private CategoryInfoNavMenuNumber one;
    @JsonProperty("2")
    private CategoryInfoNavMenuNumber two;
    @JsonProperty("3")
    private CategoryInfoNavMenuNumber three;
    @JsonProperty("4")
    private CategoryInfoNavMenuNumber four;
    @JsonProperty("5")
    private CategoryInfoNavMenuNumber five;
    @JsonProperty("6")
    private CategoryInfoNavMenuNumber six;
    @JsonProperty("7")
    private CategoryInfoNavMenuNumber seven;
    @JsonProperty("8")
    private CategoryInfoNavMenuNumber eight;
    @JsonProperty("9")
    private CategoryInfoNavMenuNumber night;
    @JsonProperty("10")
    private CategoryInfoNavMenuNumber teen;
}

/*
{
"id": 21055,
"isAll": 0,
"showName": "Kitchen",
"url": "",
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
