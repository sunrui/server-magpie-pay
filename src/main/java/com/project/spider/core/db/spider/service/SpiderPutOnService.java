package com.project.spider.core.db.spider.service;

import com.project.spider.core.db.spider.entity.ProdProduct;
import com.project.spider.core.db.spider.entity.SpiderProduct;

public interface SpiderPutOnService {
    ProdProduct putOnToProd(SpiderProduct spiderProduct, String categoryNo);
}
