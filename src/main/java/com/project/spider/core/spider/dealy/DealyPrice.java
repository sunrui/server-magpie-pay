package com.project.spider.core.spider.dealy;

import com.project.spider.common.exception.SpiderException;
import com.project.spider.controller.dealy.DealyController;
import com.project.spider.core.spider.SpiderLang;
import com.project.spider.core.spider.dealy.dto.category.CategoryDto;
import com.project.spider.core.spider.dealy.dto.category.CategoryNavMenu;
import com.project.spider.core.spider.dealy.dto.categoryInfo.CategoryInfoDto;
import com.project.spider.core.spider.dealy.dto.categoryInfo.CategoryInfoNavMenu;
import com.project.spider.core.spider.dealy.dto.categoryInfo.CategoryInfoNavMenuNumber;
import com.project.spider.core.spider.dealy.dto.rate.RateDto;
import com.project.spider.core.spider.dealy.dto.rate.RateInfo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

/**
 * 实时价格
 */
@Log4j2
@Service
public class DealyPrice {
    @Autowired
    private DealyFetchProvider dealyFetchProvider;
    @Autowired
    private DealyController dealyController;

    private Double exchangeRate;
    private HashMap<String, Float> shippingPriceMap;
    private HashMap<Integer, String> catIdCategoryNameMap;
    private Boolean inited = false;

    public void init() {
        if (inited) {
            return;
        }

        RateDto rateDto = dealyFetchProvider.getRate();
        if (rateDto.getCode() != 200) {
            throw new SpiderException("parse failed");
        }

        List<RateInfo> rateInfoList = rateDto.getData().getInfo();
        exchangeRate = dealyFetchProvider.getSpiderConfig().getSpiderLang() == SpiderLang.SAR ? 3.75 : 1.00;
        for (RateInfo rateInfo : rateInfoList) {
            if (dealyFetchProvider.getSpiderConfig().getSpiderLang() == SpiderLang.SAR) {
                if (rateInfo.getSymbol().contentEquals("SAR")) {
                    exchangeRate = Double.valueOf(rateInfo.getRate());
                }
            }
        }

        shippingPriceMap = new HashMap<>();
        shippingPriceMap.put("Women's Clothing", Float.valueOf("25.00"));
        shippingPriceMap.put("Home & Living", Float.valueOf("25.00"));
        shippingPriceMap.put("Men's Collection", Float.valueOf("25.00"));
        shippingPriceMap.put("Shoes", Float.valueOf("25.00"));
        shippingPriceMap.put("Bags", Float.valueOf("30.00"));
        shippingPriceMap.put("Accessories", Float.valueOf("18.00"));
        shippingPriceMap.put("Kids & Moms", Float.valueOf("20.00"));
        shippingPriceMap.put("Electronics", Float.valueOf("18.00"));
        shippingPriceMap.put("Beauty", Float.valueOf("18.00"));
        shippingPriceMap.put("More Choice", Float.valueOf("20.00"));

//        initCatIdCategoryNameMap();

        inited = true;
    }

    public BigDecimal exchangeRatePrice(Float originalPrice) {
        double exchangeRatePrice = exchangeRate * originalPrice;
        BigDecimal bigDecimal = new BigDecimal(exchangeRatePrice);
        return bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    private void initCatIdCategoryNameMap() {
        catIdCategoryNameMap = new HashMap<>();
        CategoryDto categoryDto = dealyFetchProvider.getCategoryLevelOne();
        if (categoryDto.getCode() != 200) {
            SpiderException.triggerParseFailed();
            return;
        }

        // 一级目录
        for (CategoryNavMenu categoryNavMenu : categoryDto.getData().getNavMenuList()) {
            // 二级目录
            CategoryInfoDto categoryInfoDto = dealyFetchProvider.getCategoryLevelTwo(categoryNavMenu.getId());
            if (categoryInfoDto.getCode() != 200) {
                SpiderException.triggerParseFailed();
                continue;
            }

            // Dealy 有三级目录，我们目前只有二级目录，所以将二级目录的所有子目录遍历为二级类目。
            for (CategoryInfoNavMenu categoryInfoNavMenu : categoryInfoDto.getData().getNavMenuList()) {
                CategoryInfoNavMenuNumber[] categoryInfoNavMenuNumbers = new CategoryInfoNavMenuNumber[]{
                        categoryInfoNavMenu.getZero(),
                        categoryInfoNavMenu.getOne(),
                        categoryInfoNavMenu.getTwo(),
                        categoryInfoNavMenu.getThree(),
                        categoryInfoNavMenu.getFour(),
                        categoryInfoNavMenu.getFive(),
                        categoryInfoNavMenu.getSix(),
                        categoryInfoNavMenu.getEight(),
                        categoryInfoNavMenu.getNight(),
                        categoryInfoNavMenu.getTeen()
                };

                for (CategoryInfoNavMenuNumber categoryInfoNavMenuNumber : categoryInfoNavMenuNumbers) {
                    if (categoryInfoNavMenuNumber != null) {
                        catIdCategoryNameMap.put(categoryInfoNavMenuNumber.getId(), categoryNavMenu.getShowName());
                    }
                }
            }
        }
    }

    public BigDecimal shippingPriceByCatId(Integer catId) {
        String categoryName = catIdCategoryNameMap.get(catId);
        if (shippingPriceMap.get(categoryName) != null) {
            return BigDecimal.valueOf(shippingPriceMap.get(categoryName));
        }

        float price = Float.parseFloat("18.00");
        return new BigDecimal(price);
    }

    public BigDecimal shippingPriceByCategoryName(String categoryName) {
        if (StringUtils.hasText(categoryName)) {
            if (shippingPriceMap.get(categoryName) != null) {
                return BigDecimal.valueOf(shippingPriceMap.get(categoryName));
            }
        }

        float price = Float.parseFloat("18.00");
        return new BigDecimal(price);
    }
}
