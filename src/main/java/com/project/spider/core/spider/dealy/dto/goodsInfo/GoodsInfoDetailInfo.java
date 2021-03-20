package com.project.spider.core.spider.dealy.dto.goodsInfo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GoodsInfoDetailInfo {
    private Integer catId;
    private Integer goodsId;
    private String goodsName;
    private Integer imgeRatio;
    private Integer inStock;
    private Integer likeCount;
    private Float promotePriceMax;
    private Float promotePriceMin;
    private String shareLink;
    private Float shopPriceMax;
    private Float shopPriceMin;
}

/*
{
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
}
 */
