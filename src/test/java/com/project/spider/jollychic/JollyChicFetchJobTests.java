package com.project.spider.jollychic;

import com.project.spider.core.spider.SpiderLang;
import com.project.spider.core.spider.dealy.DealyFetchProvider;
import com.project.spider.core.spider.dealy.dto.categoryGoodsList.CategoryGoodsListDto;
import com.project.spider.core.spider.dealy.dto.rate.RateDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
public class JollyChicFetchJobTests {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DealyFetchProvider dealyFetchProvider;

    @Test
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

    @Test
    void loopGetCategoryList() {
        // 211 是按流行排序
        for (int pageNumber = 211; ; pageNumber++) {
            CategoryGoodsListDto categoryGoodsListDto = getCategoryGoodsList(pageNumber);
            if (categoryGoodsListDto == null) {
                break;
            }

            System.out.println(categoryGoodsListDto.getData().getPage());
            System.out.println(categoryGoodsListDto.getData().getPageSize());
        }
    }

    @Test
    void run() {


    }
}
