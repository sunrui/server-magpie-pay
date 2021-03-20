package com.project.spider.prod;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.spider.core.db.spider.entity.SpiderProduct;
import com.project.spider.core.db.spider.entity.SpiderProductSku;
import com.project.spider.core.db.spider.repository.SpiderProductRepository;
import com.project.spider.core.db.spider.repository.SpiderProductSkuRepository;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ProdProductFlushTests {
    @Autowired
    private SpiderProductRepository spiderProductRepository;
    @Autowired
    private SpiderProductSkuRepository spiderProductSkuRepository;

    @Test
    @SneakyThrows
    void testForProductSku() {
        String prodProductJson = "{\"id\":148000874,\"uuid\":\"21f2a16b766c36f964630e6ef5ec8394\",\"no\":\"21f2a16b766c36f964630e6ef5ec8394\",\"customNo\":\"0xdx0x-q-iyf-nw-q-r-b9io-248oo-73\",\"categoryNo\":7306,\"originalPrice\":440.00,\"retailPrice\":170.00,\"shippingPrice\":18,\"currency\":\"USD\",\"name\":\"Fxunshi Coffee Maker 800W 220V 1.5L Automatic Insulation Coffee Machine EU Plug\",\"keywords\":null,\"status\":0,\"supplierUuid\":null,\"retailerUuid\":\"81a650c6ecec11e983ec0242ac110007\",\"storeUuid\":null,\"mainPhoto\":\"https://imcut.jollychic.com//uploads/jollyimg/imageService/img/goods/2019/07/03/10/05/1eaeb088-d03a-4055-9502-c546eef15ff7.jpg_600x800x80.jpg\",\"createdAt\":1609210111146,\"updatedAt\":1609210111146,\"publishAt\":1609210111146,\"isDeleted\":0,\"deletedAt\":null,\"description\":\"Fxunshi Coffee Maker 800W 220V 1.5L Automatic Insulation Coffee Machine EU Plug\",\"rating\":4.8,\"score\":10000.0,\"refundRate\":null,\"shippingMinDays\":7,\"shippingMaxDays\":21,\"autoRefundDays\":null,\"totalReviews\":0,\"totalSales\":null,\"salesTotal\":null,\"totalRefunds\":null,\"totalViews\":null,\"totalCollections\":10,\"idx\":null,\"noUpdatedCount\":null,\"photosStr\":\"https://imcut.jollychic.com//uploads/jollyimg/imageService/img/goods/2019/07/03/10/05/f9d88361-0470-46fa-ab74-884ca7f4ff6b.jpg_600x800x80.jpg,https://imcut.jollychic.com//uploads/jollyimg/imageService/img/goods/2019/07/03/10/05/ddc7955a-0099-4cf1-993c-414d4bad0787.jpg_600x800x80.jpg,https://imcut.jollychic.com//uploads/jollyimg/imageService/img/goods/2019/07/03/10/05/058933e2-2a63-4204-9789-32ecf865c8bb.jpg_600x800x80.jpg,https://imcut.jollychic.com//uploads/jollyimg/imageService/img/goods/2019/07/03/10/05/3da15982-3fc8-4a1c-938a-1e096290d1bd.jpg_600x800x80.jpg,https://imcut.jollychic.com//uploads/jollyimg/imageService/img/goods/2019/07/03/10/05/1eaeb088-d03a-4055-9502-c546eef15ff7.jpg_600x800x80.jpg\",\"shippingArrivalDesc\":\"7 - 21 days\",\"wfName\":null,\"wfState\":null,\"defNo\":\"3417060\",\"wfUuid\":null,\"platformIntervene\":null,\"forbiddenAdjustPrice\":null,\"marketingType\":0,\"spiderRefer\":\"JOLLY_CHIC\",\"spiderProductSkuList\":null,\"isPutOn\":false,\"putOneAt\":null}";
        String prodSkuJson = "[{\"id\":475380891,\"uuid\":\"21f2a16b766c36f964630e6ef5ec83940\",\"productNo\":\"21f2a16b766c36f964630e6ef5ec83940\",\"no\":\"21f2a16b766c36f964630e6ef5ec83940\",\"customNo\":null,\"color\":\"Black\",\"size\":null,\"originalPrice\":440.0,\"retailPrice\":170.0,\"currency\":\"USD\",\"quantity\":9999,\"productUuid\":\"21f2a16b766c36f964630e6ef5ec8394\",\"status\":0,\"createdAt\":1609210112394,\"deletedAt\":null,\"isDeleted\":0,\"updatedAt\":1609210112394,\"noUpdatedCount\":null,\"idx\":null,\"weight\":null,\"weightUnit\":null,\"photosStr\":null,\"shippingPrice\":18,\"shippingCurrency\":\"USD\",\"spiderRefer\":\"JOLLY_CHIC\"},{\"id\":244903515,\"uuid\":\"21f2a16b766c36f964630e6ef5ec83941\",\"productNo\":\"21f2a16b766c36f964630e6ef5ec83941\",\"no\":\"21f2a16b766c36f964630e6ef5ec83941\",\"customNo\":null,\"color\":\"Black\",\"size\":null,\"originalPrice\":440.0,\"retailPrice\":170.0,\"currency\":\"USD\",\"quantity\":9999,\"productUuid\":\"21f2a16b766c36f964630e6ef5ec8394\",\"status\":0,\"createdAt\":1609210112395,\"deletedAt\":null,\"isDeleted\":0,\"updatedAt\":1609210112395,\"noUpdatedCount\":null,\"idx\":null,\"weight\":null,\"weightUnit\":null,\"photosStr\":null,\"shippingPrice\":18,\"shippingCurrency\":\"USD\",\"spiderRefer\":\"JOLLY_CHIC\"}]";

        SpiderProduct spiderProduct = new ObjectMapper().readValue(prodProductJson, SpiderProduct.class);
        List<SpiderProductSku> spiderProductSkuList = new ObjectMapper().readValue(prodSkuJson, new TypeReference<List<SpiderProductSku>>() {
        });

        try {
            String json = new ObjectMapper().writeValueAsString(spiderProduct);
            System.out.println(json);
            json = new ObjectMapper().writeValueAsString(spiderProductSkuList);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        SpiderProduct spiderProductQuery = spiderProductRepository.findByUuid(spiderProduct.getUuid());
        if (spiderProductQuery == null) {
            spiderProductRepository.save(spiderProduct);
        } else {
            spiderProduct = spiderProductQuery;
        }

        for (SpiderProductSku spiderProductSku : spiderProductSkuList) {
            if (spiderProductSkuRepository.findByUuid(spiderProductSku.getUuid()) == null) {
                spiderProductSku.setSpiderProduct(spiderProduct);
                spiderProductSkuRepository.save(spiderProductSku);
            }
        }
    }
}
