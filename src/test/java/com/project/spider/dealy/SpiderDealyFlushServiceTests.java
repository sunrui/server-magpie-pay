package com.project.spider.dealy;

import com.project.spider.core.db.spider.entity.SpiderProduct;
import com.project.spider.core.db.spider.entity.SpiderProductSku;
import com.project.spider.core.db.spider.service.SpiderDealyFlushService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SpiderDealyFlushServiceTests {
    @Autowired
    private SpiderDealyFlushService spiderDealyFlushService;

    @Test
    void contextLoads() {
    }

    @ParameterizedTest
    @CsvSource({
            "0xdx0xepr-og3-e-z6-w-eoo-73", // 有规格的场景
//            "0xdx0x-k-kgqgmcwyy4oo-73", // Free 的场景
    })
    void testForDealyFlushService(String goodsIdStr) {
        SpiderProduct spiderProduct = spiderDealyFlushService.insertByDealyGoodsIdStr("", 0, goodsIdStr);
        System.out.println("description: " + spiderProduct.getDescription());
        for (SpiderProductSku spiderProductSku : spiderProduct.getSpiderProductSkuList()) {
            System.out.println("Color: " + spiderProductSku.getColor());
            System.out.println("Size: " + spiderProductSku.getSize());
        }
    }
}
