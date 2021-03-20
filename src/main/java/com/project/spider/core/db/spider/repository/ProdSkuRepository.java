package com.project.spider.core.db.spider.repository;

import com.project.spider.core.db.spider.entity.ProdSku;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdSkuRepository extends JpaRepository<ProdSku, Integer> {
    List<ProdSku> findAllByProductUuid(String productUuid);
}
