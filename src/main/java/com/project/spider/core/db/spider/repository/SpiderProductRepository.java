package com.project.spider.core.db.spider.repository;

import com.project.spider.core.db.spider.entity.SpiderProduct;
import com.project.spider.core.spider.SpiderRefer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface SpiderProductRepository extends JpaRepository<SpiderProduct, Integer> {
    SpiderProduct findByUuid(String uuid);
    Page<SpiderProduct> findAllByCategoryNo(String categoryNo, Pageable pageable);
    SpiderProduct findByCustomNo(String goodsIdStr);
    Page<SpiderProduct> findAllBySpiderReferAndMarketingType(SpiderRefer spiderRefer, Integer marketingType, Pageable pageable);
    Page<SpiderProduct> findAllBySpiderReferAndMarketingTypeAndIsPutOn(SpiderRefer spiderRefer, Integer marketingType, Boolean isPutOn, Pageable pageable);
    List<SpiderProduct> findAllByCreatedAtAfter(Date date);
}
