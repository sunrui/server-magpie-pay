package com.project.spider.core.job.spider.jollychic;

import com.project.spider.core.spider.SpiderLang;
import com.project.spider.core.spider.SpiderMarketingType;
import com.project.spider.core.spider.dealy.DealyFetchProvider;
import com.project.spider.core.spider.dealy.dto.categoryGoodsList.CategoryGoodsBaseInfoDataGoods;
import com.project.spider.core.spider.dealy.dto.categoryGoodsList.CategoryGoodsListDto;
import com.project.spider.core.spider.dealy.dto.rate.RateDto;
import com.project.spider.core.db.spider.service.SpiderDealyFlushService;
import com.project.spider.core.db.spider.service.SpiderProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Log4j2
@Service
public class JollyChicFetchJob {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private SpiderProductService spiderProductService;
    @Autowired
    private SpiderDealyFlushService spiderDealyFlushService;
    @Autowired
    private DealyFetchProvider dealyFetchProvider;

    // 鞋子
    CategoryGoodsListDto getCategoryGoodsList(int pageNumber) {
        // 鞋二级类目
        // https://m.jollychic.com/womens-sports-shoes-c964?spm=MOB.CAT.X_CAT.C395.C581.C4151&goBack=1
        // 三级类目详情
        // https://ar.m.jollychic.com/womens-sports-shoes-c964?spm=MOB.CAT.X_CAT.C395.C581.C4151&goBack=1

        String url = "https://ar.m.jollychic.com/list/category-goods-list";
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/x-www-form-urlencoded");
        headers.setContentType(type);
        headers.set("X-Requested-With", "XMLHttpRequest");

        if (dealyFetchProvider.getSpiderConfig().getSpiderLang() == SpiderLang.SAR) {
            headers.set("cookie", "LANG_NAME=ar; LANG_CODE=1; language=%7B%22name%22%3A%22ar%22%2C%22code%22%3A1%7D;");
        }

        String formData = "orderPage=0%d&keyId=964&keywords=womens+shoes";
//        String formData = "minPrice=0&maxPrice=0&orderPage=0%d&keyId=964&keywords=womens+sports+shoes";
        formData = String.format(formData, pageNumber);

        HttpEntity<String> entity = new HttpEntity<>(formData, headers);

        try {
            return restTemplate.postForObject(url, entity, CategoryGoodsListDto.class);
        } catch (Exception e) {
            e.printStackTrace();
            RateDto rateDto = new RateDto();
            rateDto.setCode(400);
            return null;
        }
    }

    //    @PostConstruct
    void loopGetCategoryList() {
//        log.info("begin loopGetCategoryList");
        // 211 是按流行排序，下一页是加一
        for (int pageNumber = 211; ; pageNumber++) {
            CategoryGoodsListDto categoryGoodsListDto = getCategoryGoodsList(pageNumber);
            if (categoryGoodsListDto == null) {
//                log.info("parse finish");
                break;
            }

            if (categoryGoodsListDto.getData() == null ||
                    categoryGoodsListDto.getData().getBASE_INFO() == null ||
                    categoryGoodsListDto.getData().getBASE_INFO().getData() == null ||
                    categoryGoodsListDto.getData().getBASE_INFO().getData().getGoodsList() == null) {
                continue;
            }

            List<CategoryGoodsBaseInfoDataGoods> categoryGoodsBaseInfoDataGoodsList = categoryGoodsListDto.getData().getBASE_INFO().getData().getGoodsList();
            for (CategoryGoodsBaseInfoDataGoods categoryGoodsBaseInfoDataGoods : categoryGoodsBaseInfoDataGoodsList) {
//                SpiderProduct spiderProduct = spiderProductService.findByDefNo(categoryGoodsBaseInfoDataGoods.getGoodsId());
//                if (spiderProduct != null) {
//                    continue;
//                }

//                String[] spiderCategoryNames = new String[]{
//                    "Women's Clothing", // JollyChic 女装
//                    "Shoes", // JollyChic 鞋
//                        "رجالي", // 女装
//                    "أحذية", // 鞋
//                };

                spiderDealyFlushService.insertByDealyGoodsId("Shoes", SpiderMarketingType.NORMAL.getCode(), categoryGoodsBaseInfoDataGoods.getGoodsId());
            }
        }

//        log.info("finish loopGetCategoryList");
    }
}
