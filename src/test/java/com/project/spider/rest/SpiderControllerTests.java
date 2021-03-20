package com.project.spider.rest;

import com.project.spider.controller.spider.SpiderController;
import com.project.spider.controller.spider.res.ProductPageVo;
import com.project.spider.core.spider.SpiderRefer;
import com.project.spider.core.db.spider.entity.SpiderProduct;
import com.project.spider.core.db.spider.entity.SpiderProductSku;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SpiderControllerTests {
    @Autowired
    private SpiderController spiderController;

    @Test
    void contextLoads() {
    }

    @Test
    void testForGetProduct() {
        ProductPageVo productPageVo = spiderController.getProduct(0, 10, 4, null, SpiderRefer.JOLLY_CHIC,true);
        for (SpiderProduct spiderProduct : productPageVo.getData()) {
            System.out.println("description: " + spiderProduct.getDescription());
            for (SpiderProductSku spiderProductSku : spiderProduct.getSpiderProductSkuList()) {
                System.out.println("Color: " + spiderProductSku.getColor());
                System.out.println("Size: " + spiderProductSku.getSize());
            }
        }
    }
}
