package com.project.spider.core.db.spider.service;

import com.project.spider.core.db.spider.entity.SpiderProduct;

public interface SpiderDealyFlushService {
    /**
     * @param categoryName  一级类目名称，用于计算产品运费，无类目为默认运费
     * @param marketingType 营销类型 0-普通 1-网红 2-新手 4-闪购 8-热销
     * @param goodsId       dealy 存储 goodsId
     * @return shallchic SPU
     */
    SpiderProduct insertByDealyGoodsId(String categoryName, Integer marketingType, Integer goodsId);

    /**
     * @param categoryName  一级类目名称，用于计算产品运费，无类目为默认运费
     * @param marketingType 营销类型 0-普通 1-网红 2-新手 4-闪购 8-热销
     * @param goodsIdStr    dealy 存储 goodsIdStr
     * @return shallchic SPU
     */
    SpiderProduct insertByDealyGoodsIdStr(String categoryName, Integer marketingType, String goodsIdStr);
}
