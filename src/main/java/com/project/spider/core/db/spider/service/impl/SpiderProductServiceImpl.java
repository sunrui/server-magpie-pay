package com.project.spider.core.db.spider.service.impl;

import com.project.spider.core.db.spider.entity.SpiderProduct;
import com.project.spider.core.db.spider.repository.SpiderProductRepository;
import com.project.spider.core.db.spider.service.SpiderProductService;
import com.project.spider.core.spider.SpiderRefer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class SpiderProductServiceImpl implements SpiderProductService {
    @Autowired
    private SpiderProductRepository spiderProductRepository;

    @Override
    public SpiderProduct insert(SpiderProduct spiderProduct) {
        spiderProductRepository.save(spiderProduct);
        return spiderProduct;
    }

    @Override
    public SpiderProduct findById(Integer id) {
        return spiderProductRepository.findById(id).orElse(null);
    }

    @Override
    public SpiderProduct findByUuid(String uuid) {
        return spiderProductRepository.findByUuid(uuid);
    }

    @Override
    public SpiderProduct findByCustomNo(String goodsIdStr) {
        return spiderProductRepository.findByCustomNo(goodsIdStr);
    }

    @Override
    public Boolean deleteByUuid(String uuid) {
        SpiderProduct spiderProduct = spiderProductRepository.findByUuid(uuid);
        if (spiderProduct == null) {
            return false;
        }

        spiderProductRepository.delete(spiderProduct);
        return true;
    }

    @Override
    public Page<SpiderProduct> findAll(int page, int size) {
        return spiderProductRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Page<SpiderProduct> findAllByCategoryNo(String categoryNo, int page, int size) {
        return spiderProductRepository.findAllByCategoryNo(categoryNo, PageRequest.of(page, size));
    }

    @Override
    public Page<SpiderProduct> findAllBySpiderReferAndMarketingType(SpiderRefer spiderRefer, Integer marketingType, int page, int size) {
        return spiderProductRepository.findAllBySpiderReferAndMarketingType(spiderRefer, marketingType, PageRequest.of(page, size));
    }

    @Override
    public Page<SpiderProduct> findAllBySpiderReferAndMarketingTypeAndIsPutOn(SpiderRefer spiderRefer, Integer marketingType, boolean isPutOn, int page, int size) {
        return spiderProductRepository.findAllBySpiderReferAndMarketingTypeAndIsPutOn(spiderRefer, marketingType, isPutOn, PageRequest.of(page, size));
    }

    @Override
    public Boolean updatePutOnById(Integer id) {
        Optional<SpiderProduct> spiderProductOptional = spiderProductRepository.findById(id);
        if (!spiderProductOptional.isPresent()) {
            return false;
        }

        spiderProductOptional.get().setIsPutOn(true);
        spiderProductOptional.get().setPutOneAt(new Date());
        spiderProductRepository.save(spiderProductOptional.get());
        return true;
    }

    @Override
    public Boolean updateLinkUuid(Integer id, String linkUuid) {
        Optional<SpiderProduct> spiderProductOptional = spiderProductRepository.findById(id);
        if (!spiderProductOptional.isPresent()) {
            return false;
        }

        spiderProductOptional.get().setLinkUuid(linkUuid);
        spiderProductRepository.save(spiderProductOptional.get());
        return true;
    }
}
