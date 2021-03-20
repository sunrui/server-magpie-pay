package com.project.spider.core.db.spider.service;

import com.project.spider.core.spider.SpiderRefer;
import com.project.spider.core.db.spider.entity.SpiderProduct;
import org.springframework.data.domain.Page;

public interface SpiderProductService {
    SpiderProduct insert(SpiderProduct spiderProduct);
    SpiderProduct findById(Integer id);
    SpiderProduct findByUuid(String uuid);
    SpiderProduct findByCustomNo(String goodsIdStr);
    Boolean deleteByUuid(String uuid);
    Page<SpiderProduct> findAll(int page, int size);
    Page<SpiderProduct> findAllByCategoryNo(String categoryNo, int page, int size);
    Page<SpiderProduct> findAllBySpiderReferAndMarketingType(SpiderRefer spiderRefer, Integer marketingType, int page, int size);
    Page<SpiderProduct> findAllBySpiderReferAndMarketingTypeAndIsPutOn(SpiderRefer spiderRefer, Integer marketingType, boolean isPutOn, int page, int size);
    Boolean updatePutOnById(Integer id);
    Boolean updateLinkUuid(Integer id, String linkUuid);
}
