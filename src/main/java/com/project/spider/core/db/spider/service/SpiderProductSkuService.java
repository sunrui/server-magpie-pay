package com.project.spider.core.db.spider.service;

import com.project.spider.core.db.spider.entity.SpiderProductSku;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SpiderProductSkuService {
    SpiderProductSku insert(SpiderProductSku spiderProductSku);

    SpiderProductSku findByUuid(String uuid);

    Boolean deleteByUuid(String uuid);

    Page<SpiderProductSku> findAll(int page, int size);

    List<SpiderProductSku> findAllByProductUuid(String productUuid);
}
