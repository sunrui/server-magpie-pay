package com.project.spider.core.db.spider.service.impl;

import com.project.spider.core.db.spider.entity.SpiderProductSku;
import com.project.spider.core.db.spider.repository.SpiderProductSkuRepository;
import com.project.spider.core.db.spider.service.SpiderProductSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpiderProductSkuServiceImpl implements SpiderProductSkuService {
    @Autowired
    private SpiderProductSkuRepository spiderProductSkuRepository;

    @Override
    public SpiderProductSku insert(SpiderProductSku SpiderProductSku) {
        spiderProductSkuRepository.save(SpiderProductSku);
        return SpiderProductSku;
    }

    @Override
    public SpiderProductSku findByUuid(String uuid) {
        return spiderProductSkuRepository.findByUuid(uuid);
    }

    @Override
    public Boolean deleteByUuid(String uuid) {
        SpiderProductSku SpiderProductSku = spiderProductSkuRepository.findByUuid(uuid);
        if (SpiderProductSku == null) {
            return false;
        }

        spiderProductSkuRepository.delete(SpiderProductSku);
        return true;
    }

    @Override
    public Page<SpiderProductSku> findAll(int page, int size) {
        return spiderProductSkuRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public List<SpiderProductSku> findAllByProductUuid(String productUuid) {
        return spiderProductSkuRepository.findAllByProductUuid(productUuid);
    }
}
