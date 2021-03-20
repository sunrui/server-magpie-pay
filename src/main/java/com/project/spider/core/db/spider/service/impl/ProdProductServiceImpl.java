package com.project.spider.core.db.spider.service.impl;

import com.project.spider.common.util.RandomUtil;
import com.project.spider.core.db.spider.entity.ProdProduct;
import com.project.spider.core.db.spider.entity.ProdSku;
import com.project.spider.core.db.spider.entity.SpiderProduct;
import com.project.spider.core.db.spider.entity.SpiderProductSku;
import com.project.spider.core.db.spider.repository.ProdProductRepository;
import com.project.spider.core.db.spider.repository.ProdSkuRepository;
import com.project.spider.core.db.spider.repository.SpiderProductSkuRepository;
import com.project.spider.core.db.spider.service.ProdProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class ProdProductServiceImpl implements ProdProductService {
    @Autowired
    private SpiderProductSkuRepository spiderProductSkuRepository;
    @Autowired
    private ProdProductRepository prodProductRepository;
    @Autowired
    private ProdSkuRepository prodSkuRepository;

    @Transactional
    @Override
    public ProdProduct insertBySpiderProduct(SpiderProduct spiderProduct) {
        ProdProduct prodProduct = new ProdProduct();
        BeanUtils.copyProperties(spiderProduct, prodProduct);
        prodProduct.setId(null);
        prodProduct.setUuid(RandomUtil.getUuid32());
        prodProduct.setNo(prodProduct.getNo());
        prodProduct.setProdProductSkuList(null);
        prodProduct.setSalesTotal(0);

        /**
         * 目前有一个问题，原来的 DefNo 是随时生成的且用作唯一，事实上 7 位的数字用于随机很可能就会碰撞造成插不进去。
         * 实现一种永不会撞库的规则。
         */
        int prefix = 100;
        try {
            Date newYearDate = new SimpleDateFormat("yyyy-MM-dd").parse("2021-01-01");
            long diffDays = (new Date().getTime() - newYearDate.getTime()) / (24 * 60 * 60 * 1000L);
            prefix += diffDays;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        prodProduct.setDefNo("A" + prefix + new Random().nextInt(9999));
        prodProduct.setCreatedAt(new Date());
        prodProduct.setUpdatedAt(new Date());

        prodProduct = prodProductRepository.save(prodProduct);

        List<SpiderProductSku> spiderProductSkuList = spiderProductSkuRepository.findAllByProductUuid(spiderProduct.getUuid());

        BigDecimal originalPrice = prodProduct.getOriginalPrice();
        BigDecimal retailPrice = prodProduct.getRetailPrice();
        retailPrice = retailPrice.min(originalPrice);

        for (SpiderProductSku spiderProductSku : spiderProductSkuList) {
            ProdSku prodSku = new ProdSku();
            BeanUtils.copyProperties(spiderProductSku, prodSku);

            originalPrice = originalPrice.min(prodSku.getOriginalPrice());
            retailPrice = retailPrice.min(prodSku.getRetailPrice());

            prodSku.setProdProduct(prodProduct);
            prodSku.setProductUuid(prodProduct.getUuid());
            /**
             * 以最新的上架时间为准
             */
            prodSku.setCreatedAt(new Date());
            prodSku.setUpdatedAt(new Date());
            prodSkuRepository.save(prodSku);
        }

        retailPrice = retailPrice.min(originalPrice);

        if (!prodProduct.getOriginalPrice().equals(originalPrice) || !prodProduct.getRetailPrice().equals(retailPrice)) {
            prodProduct.setOriginalPrice(originalPrice);
            prodProduct.setRetailPrice(retailPrice);
            prodProductRepository.save(prodProduct);
        }

        return prodProduct;
    }

    @Override
    public boolean updateProduct(Integer prodProductId, ProdProduct prodProduct) {
        Optional<ProdProduct> spiderProductOptional = prodProductRepository.findById(prodProductId);
        if (!spiderProductOptional.isPresent()) {
            return false;
        }

        BeanUtils.copyProperties(prodProduct, spiderProductOptional.get());
        spiderProductOptional.get().setId(prodProductId);
        spiderProductOptional.get().setProdProductSkuList(null);
        spiderProductOptional.get().setUpdatedAt(new Date());
        prodProductRepository.save(spiderProductOptional.get());
        return true;
    }

    @Override
    public boolean updateProductScore(Integer prodProductId, Double score) {
        Optional<ProdProduct> spiderProductOptional = prodProductRepository.findById(prodProductId);
        if (!spiderProductOptional.isPresent()) {
            return false;
        }

        ProdProduct prodProduct = new ProdProduct();
        BeanUtils.copyProperties(spiderProductOptional.get(), prodProduct);
        spiderProductOptional.get().setUpdatedAt(new Date());
        prodProduct.setScore(score);
        prodProductRepository.save(prodProduct);
        return true;
    }

    @Override
    public ProdProduct findById(Integer id) {
        return prodProductRepository.findById(id).orElse(null);
    }

    @Override
    public ProdProduct findByUuid(String uuid) {
        return prodProductRepository.findByUuid(uuid);
    }

    @Override
    public Page<ProdProduct> findAll(int page, int size) {
        return prodProductRepository.findAll(PageRequest.of(page, size));
    }
}
