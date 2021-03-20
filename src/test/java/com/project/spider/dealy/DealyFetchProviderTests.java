package com.project.spider.dealy;

import com.project.spider.core.spider.dealy.DealyFetchProvider;
import com.project.spider.core.spider.dealy.dto.goodsInfo.GoodsInfoDto;
import com.project.spider.core.spider.dealy.dto.goodsInfo.GoodsInfoThumbImgAttr;
import com.project.spider.core.spider.dealy.dto.rate.RateDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootTest
public class DealyFetchProviderTests {
    @Autowired
    private DealyFetchProvider dealyFetchProvider;

    @Test
    void contextLoads() {
    }

    @Test
    void testForRate() {
        RateDto rate = dealyFetchProvider.getRate();
    }

    @Test
    void testForRegex() {
        String uri = "http://m.dealy1688.com/p/womens-5-pairs-crew-socks-sweet-striped-cute-animal-cartoon-pattern-socks-g0xdx0x-k-kgqgmcwyy4oo-73.html";
        String pattern = "-g(0xdx0x.*?)\\.html";

        String except = "0xdx0x-k-kgqgmcwyy4oo-73";

        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(uri);
        if (m.find()) {
            System.out.println("Found value: " + m.group(0));
            System.out.println("Found value: " + m.group(1));
        } else {
            System.out.println("NO MATCH");
        }

        Assert.isTrue(except.contentEquals(m.group(1)), "not match");
    }

    @ParameterizedTest
    @CsvSource({
            "1259336", // Women's 5 Pairs Crew Socks Sweet Striped Cute Animal Cartoon Pattern Socks
    })
    void testForGoodsIdStr(Integer goodsId) {
        String goodsIdStr = dealyFetchProvider.getGoodsIdStr(goodsId);
        System.out.println(goodsIdStr);
    }

    @ParameterizedTest
    @CsvSource({
            "0xdx0x-k-kgqgmcwyy4oo-73", // Shirts
    })
    void testForGoodsInfo(String goodsIdStr) {
        GoodsInfoDto goodsInfoDto = dealyFetchProvider.getGoodsInfo(goodsIdStr);
        HashMap<String, GoodsInfoThumbImgAttr> thumbImgAttrHashMap = goodsInfoDto.getData().getThumbImgArr();

        for (Map.Entry<String, GoodsInfoThumbImgAttr> entry : thumbImgAttrHashMap.entrySet()) {
            String id = entry.getKey();
            GoodsInfoThumbImgAttr goodsInfoThumbImgAttr = entry.getValue();

            System.out.println("id: " + id);
            System.out.println("wholeImgLink: " + goodsInfoThumbImgAttr.getWholeImgLink());
        }
    }
}
