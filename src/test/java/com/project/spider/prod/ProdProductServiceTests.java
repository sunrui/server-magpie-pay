package com.project.spider.prod;

import com.project.spider.core.db.spider.entity.SpiderProduct;
import com.project.spider.core.db.spider.repository.SpiderProductRepository;
import com.project.spider.core.db.spider.service.ProdProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class ProdProductServiceTests {
    @Autowired
    private ProdProductService prodProductService;
    @Autowired
    private SpiderProductRepository spiderProductRepository;

    @Test
    void contextLoads() {
    }


    @ParameterizedTest
    @CsvSource({
            "13718576",
            "77840647"
    })
    void testForInsertBySpiderProductId(Integer spiderProductId) {
        Optional<SpiderProduct> spiderProductOptional = spiderProductRepository.findById(spiderProductId);
        spiderProductOptional.ifPresent(spiderProduct -> prodProductService.insertBySpiderProduct(spiderProduct));
    }
}
