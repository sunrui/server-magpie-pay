package com.project.spider.core.db.spider.service.impl;

import com.project.spider.core.db.spider.entity.ProdProduct;
import com.project.spider.core.db.spider.entity.SpiderProduct;
import com.project.spider.core.db.spider.service.ProdProductService;
import com.project.spider.core.db.spider.service.SpiderProductService;
import com.project.spider.core.db.spider.service.SpiderPutOnService;
import com.project.spider.core.db.spider.service.SpiderS3TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class SpiderPutOnServiceImpl implements SpiderPutOnService {
    @Autowired
    private ProdProductService prodProductService;
    @Autowired
    private SpiderProductService spiderProductService;
    @Autowired
    private SpiderS3TaskService spiderS3TaskService;

    @Transactional
    @Override
    public ProdProduct putOnToProd(SpiderProduct spiderProduct, String categoryNo) {
        /**
         * 更新至运营手工填写的类目编号
         */
//        categoryNo = SpiderCategoryNoMatch.getNewCategoryNo(spiderProduct.getSpiderRefer(), spiderProduct.getCategoryNo());
        spiderProduct.setCategoryNo(categoryNo);
        if (Boolean.TRUE.equals(spiderProduct.getIsPutOn())) {
            return prodProductService.findByUuid(spiderProduct.getLinkUuid());
        }

        /**
         * 入库
         */
        ProdProduct prodProduct = prodProductService.insertBySpiderProduct(spiderProduct);

        /**
         * 标记此商品已上架
         */
        spiderProductService.updatePutOnById(spiderProduct.getId());

        /**
         * 标记此商口入库 uuid
         */
        spiderProductService.updateLinkUuid(spiderProduct.getId(), prodProduct.getUuid());
        spiderProduct.setLinkUuid(prodProduct.getUuid());

        /**
         * 目前的生产服务器是根据 SCORE 来排序的，旧的爬虫是设置的以 10000 为起点，然后每天爬的数据序列号 1 所做的。
         * 为了保证新的爬虫数据在最前端，并停用旧的爬虫服务，需要新启用的号码比原有的 10000+ 大才可以在最前面。
         * 策略：全用 2021.1.1 为原点，其它的上架根据这个时间推移。
         */
        double score = 11000;
        try {
            Date newYearDate = new SimpleDateFormat("yyyy-MM-dd").parse("2021-01-01");
            long diffDays = (new Date().getTime() - newYearDate.getTime()) / (24 * 60 * 60 * 1000L);
            score += diffDays;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        /**
         * 为排序刷新分数
         */
        prodProduct.setScore(score);
        prodProductService.updateProductScore(spiderProduct.getId(), score);

        /**
         * 上传至亚马逊任务
         */
        spiderS3TaskService.insertByProProductId(prodProduct.getId());


        return prodProduct;
    }
}
