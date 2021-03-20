package com.project.spider.core.db.spider.service.impl;

import com.project.spider.core.db.spider.entity.ProdSku;
import com.project.spider.core.db.spider.repository.ProdSkuRepository;
import com.project.spider.core.db.spider.service.ProdSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdSkuServiceImpl implements ProdSkuService {
    @Autowired
    private ProdSkuRepository prodSkuRepository;

    @Override
    public List<ProdSku> findByProductUuid(String productUuid) {
        return prodSkuRepository.findAllByProductUuid(productUuid);
    }
}
