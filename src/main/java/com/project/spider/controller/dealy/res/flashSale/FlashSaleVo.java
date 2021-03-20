package com.project.spider.controller.dealy.res.flashSale;

import com.project.spider.controller.dealy.res.DealyGoods;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FlashSaleVo {
    private Integer tableTime;
    private Integer groupId;
    private Integer goodsCount;
    private List<DealyGoods> dealyGoodsList;
}
