package com.project.spider.core.db.spider.service;

import com.project.spider.core.db.spider.entity.ProdProduct;
import com.project.spider.core.db.spider.entity.SpiderProduct;
import org.springframework.data.domain.Page;

public interface ProdProductService {
    ProdProduct insertBySpiderProduct(SpiderProduct spiderProduct);
    boolean updateProduct(Integer prodProductId, ProdProduct prodProduct);
    boolean updateProductScore(Integer prodProductId, Double score);
    ProdProduct findById(Integer id);
    ProdProduct findByUuid(String uuid);
    Page<ProdProduct> findAll(int page, int size);
}
