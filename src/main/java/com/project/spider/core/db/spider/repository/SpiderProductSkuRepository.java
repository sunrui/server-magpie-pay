package com.project.spider.core.db.spider.repository;

import com.project.spider.core.db.spider.entity.SpiderProductSku;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpiderProductSkuRepository extends JpaRepository<SpiderProductSku, Integer> {
    SpiderProductSku findByUuid(String uuid);
    List<SpiderProductSku> findAllByProductUuid(String productUuid);
}
