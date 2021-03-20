package com.project.spider.core.spider.dealy.dto.goodsInfo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GoodsInfoFlashSaleInfo {
    private String countdown;
    private String deepLink;
    private Integer endTime;
    private Integer flashSaleId;
    private Integer groupId;
    private Integer groupType;
    private Integer isFollow;
    private Integer maxSaleNum;
    private Integer maxSaleNumPerId;
    private Integer remainSaleNum;
    private Integer saleNum;
    private Integer startTime;
    private Integer status;
    private String flashSaleTip;
}

/*
{
    "countdown": 22884,
    "deepLink": "jollychic://specialflash?groupid=47027&tracecode=jumpflashsale47027&title=Clearance Sale",
    "endTime": 1608710400,
    "flashSaleId": 32558947,
    "groupId": 47027,
    "groupType": 1,
    "isFollow": 0,
    "maxSaleNum": 300,
    "maxSaleNumPerId": 10,
    "remainSaleNum": 133,
    "saleNum": 167,
    "startTime": 1608537600,
    "status": 2,
    "flashSaleTip": ""
}
 */
