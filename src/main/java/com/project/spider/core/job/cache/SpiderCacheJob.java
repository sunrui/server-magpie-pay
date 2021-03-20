package com.project.spider.core.job.cache;

import com.project.spider.controller.spider.SpiderController;
import com.project.spider.controller.spider.res.ProductPageVo;
import com.project.spider.core.spider.SpiderRefer;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Log4j2
@Component
public class SpiderCacheJob {
    @Autowired
    private SpiderController spiderController;
    private final Map<Integer, ProductPageVo> marketingType0CacheMap = new ConcurrentHashMap<>();
    public static final Integer PAGE_SIZE = 24;

    //    @Scheduled(initialDelay = 5000, fixedDelay = 60 * 1000)
    public void cachePageJob() {
        marketingType0CacheMap.clear();
        for (int page = 0; ; page++) {
            ProductPageVo productPageVo = spiderController.getProduct(0, PAGE_SIZE, 4, null, SpiderRefer.JOLLY_CHIC, true);
            if (productPageVo.getCurrentSize() == 0) {
                break;
            }

            marketingType0CacheMap.put(page, productPageVo);
        }
    }

    public ProductPageVo getMarketingType0(int page) {
        ProductPageVo productPageVo = marketingType0CacheMap.get(page);
        if (productPageVo == null) {
//            log.info("getMarketingType0 for page: " + page + ", is null.");
            return null;
        }

//        log.info("getMarketingType0 for page: " + page + ", get ok.");
        return productPageVo;
    }
}
