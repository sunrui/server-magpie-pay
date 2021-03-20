package com.project.spider.core.db.spider.service;

import com.project.spider.core.db.spider.entity.ProdSku;

import java.util.List;

public interface ProdSkuService {
    List<ProdSku> findByProductUuid(String productUuid);
}
