package com.project.spider.core.db.spider.service.impl;

import com.project.spider.common.exception.SpiderException;
import com.project.spider.common.util.RandomUtil;
import com.project.spider.core.db.spider.entity.SpiderProduct;
import com.project.spider.core.db.spider.entity.SpiderProductSku;
import com.project.spider.core.db.spider.repository.SpiderProductRepository;
import com.project.spider.core.db.spider.repository.SpiderProductSkuRepository;
import com.project.spider.core.db.spider.service.SpiderDealyFlushService;
import com.project.spider.core.spider.SpiderLang;
import com.project.spider.core.spider.dealy.DealyFetchProvider;
import com.project.spider.core.spider.dealy.DealyPrice;
import com.project.spider.core.spider.dealy.dto.goodsInfo.GoodsInfoDto;
import com.project.spider.core.spider.dealy.dto.goodsInfo.GoodsInfoThumbImgAttr;
import com.project.spider.core.spider.dealy.dto.skuInfo.SkuInfoDto;
import com.project.spider.core.spider.dealy.dto.skuInfo.SkuInfoFormatArrLocal;
import com.project.spider.core.spider.dealy.dto.skuInfo.SkuInfoSpec;
import com.project.spider.core.spider.dealy.dto.skuInfo.SkuInfoSpecValue;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.*;

@Log4j2
@Service
public class SpiderDealyFlushServiceImpl implements SpiderDealyFlushService {
    @Autowired
    private DealyPrice dealyPrice;
    @Autowired
    private DealyFetchProvider dealyFetchProvider;
    @Autowired
    private SpiderProductRepository spiderProductRepository;
    @Autowired
    private SpiderProductSkuRepository spiderProductSkuRepository;

    private SpiderProduct fillToShallchicProduct(String categoryName, Integer marketingType, String goodsIdStr, GoodsInfoDto goodsInfoDto) {
        // 遵守目前 GO 版本的 UUID 生成规则，防止碰撞。
        String uuid = DigestUtils.md5DigestAsHex(("PROD" + goodsIdStr).getBytes());

        SpiderProduct spiderProduct = new SpiderProduct();
//        spiderProduct.setId(new Random().nextInt(999999999));
        spiderProduct.setStatus(0);
        spiderProduct.setNo(uuid);
        spiderProduct.setUuid(uuid);
        spiderProduct.setCustomNo(goodsIdStr);
        spiderProduct.setCategoryNo(goodsInfoDto.getData().getGoodsDetailInfo().getCatId() + "");
        spiderProduct.setOriginalPrice(dealyPrice.exchangeRatePrice(goodsInfoDto.getData().getGoodsDetailInfo().getShopPriceMin()));
        spiderProduct.setRetailPrice(dealyPrice.exchangeRatePrice(goodsInfoDto.getData().getGoodsDetailInfo().getPromotePriceMin()));
        // 目前只传到 ae 环境中，sa 环境会自动同步一份过去，同时会把 SAR 更为 AED
        spiderProduct.setCurrency(dealyFetchProvider.getSpiderConfig().getSpiderLang() == SpiderLang.SAR ? "SAR" : "USD");
        spiderProduct.setName(goodsInfoDto.getData().getGoodsDetailInfo().getGoodsName());
        spiderProduct.setRating(Float.valueOf("4.8"));
        // 购买量直接抄 dealy 的
        spiderProduct.setTotalSales(goodsInfoDto.getData().getGoodsDetailExtInfo().getSalesCount());
        spiderProduct.setTotalReviews(0); // 这个字段应该是被废弃了
        spiderProduct.setTotalCollections(10);
        spiderProduct.setRetailerUuid("81a650c6ecec11e983ec0242ac110007"); // r01

        spiderProduct.setCreatedAt(new Date());
        spiderProduct.setPublishAt(new Date());
        spiderProduct.setUpdatedAt(new Date());

        spiderProduct.setShippingMinDays(7);
        spiderProduct.setShippingMaxDays(21);
        spiderProduct.setShippingArrivalDesc("7 - 21 days");

        spiderProduct.setShippingPrice(dealyPrice.shippingPriceByCategoryName(categoryName));
        // 改由上架的时候设置，有新的规则防止撞库
        spiderProduct.setDefNo(RandomUtil.generateString(16));
        spiderProduct.setMarketingType(marketingType);
        spiderProduct.setIsDeleted(0);
        spiderProduct.setSpiderRefer(dealyFetchProvider.getSpiderConfig().getSpiderRefer());
        spiderProduct.setScore(10000.0);
        spiderProduct.setIsPutOn(false);
        spiderProduct.setReferCategoryName(categoryName);

        // dealy cdn 链接
        spiderProduct.setMainPhoto(goodsInfoDto.getData().getGoodsImgUrl());
        spiderProduct.setDescription(goodsInfoDto.getData().getGoodsDetailInfo().getGoodsName());
        HashMap<String, GoodsInfoThumbImgAttr> thumbImgAttrHashMap = goodsInfoDto.getData().getThumbImgArr();
        StringBuilder stringBuilder = new StringBuilder();

        for (Map.Entry<String, GoodsInfoThumbImgAttr> entry : thumbImgAttrHashMap.entrySet()) {
            GoodsInfoThumbImgAttr goodsInfoThumbImgAttr = entry.getValue();
            stringBuilder.append(goodsInfoThumbImgAttr.getWholeImgLink()).append(",");
        }

        spiderProduct.setPhotosStr(stringBuilder.substring(0, stringBuilder.length() - 1));

        return spiderProduct;
    }

    private List<SpiderProductSku> fillToShallchicProductSku(String categoryName, String goodsIdStr, GoodsInfoDto goodsInfoDto, SpiderProduct spiderProduct) {
        List<SpiderProductSku> spiderProductSkuList = new ArrayList<>();
        SkuInfoDto skuInfoDto = dealyFetchProvider.getSkuInfoDto(goodsIdStr);
        if (skuInfoDto.getCode() != 200) {
            SpiderException.triggerParseFailed();
            return new ArrayList<>();
        }

        @Getter
        @Setter
        class SpecColor {
            private String color;
            private String image;
        }

        @Getter
        @Setter
        class SpecSize {
            private String size;
        }

        @Getter
        @Setter
        class SpecPrice {
            private Float originalPrice;
            private Float retailPrice;
        }

        @Getter
        @Setter
        class SpecMix {
            private SpecColor specColor;
            private SpecSize specSize;
            private SpecPrice specPrice;
        }

        List<SpecMix> specMixList = new ArrayList<>();

        SkuInfoSpec colorSkuInfoSpec = null;
        SkuInfoSpec sizeSkuInfoSpec = null;

        for (SkuInfoSpec skuInfoSpec : skuInfoDto.getData().getSkuInfo()) {
            if (skuInfoSpec.getKeyName().toLowerCase().contentEquals("color") ||
                    skuInfoSpec.getKeyName().toLowerCase().contentEquals("اللون")) {
                colorSkuInfoSpec = skuInfoSpec;
                continue;
            }

            if (skuInfoSpec.getKeyName().toLowerCase().contentEquals("size") ||
                    skuInfoSpec.getKeyName().toLowerCase().contentEquals("المقاس")) {
                sizeSkuInfoSpec = skuInfoSpec;
            }
        }

        /**
         * dealy 站有一些 sku 不叫 Size，比如会叫做 Reference Height，我们的表中只支持 color 和 size，
         * 所有将非 color 的第一个作为 size 来存储
         */
        if (sizeSkuInfoSpec == null) {
            for (SkuInfoSpec skuInfoSpec : skuInfoDto.getData().getSkuInfo()) {
                if (!skuInfoSpec.getKeyName().toLowerCase().contentEquals("color")) {
                    sizeSkuInfoSpec = skuInfoSpec;
                    break;
                }
            }
        }

        /**
         * Color 必须要有
         */
        if (colorSkuInfoSpec == null) {
            return new ArrayList<>();
        }

        Map<Integer, SpecColor> specColorMap = new HashMap<>();
        for (SkuInfoSpecValue skuInfoSpecValue : colorSkuInfoSpec.getValueList()) {
            SpecColor specColor = new SpecColor();
            specColor.setColor(skuInfoSpecValue.getValueName());
            specColor.setImage(skuInfoSpecValue.getOriginalImg());
            specColorMap.put(skuInfoSpecValue.getValueId(), specColor);
        }

        Map<Integer, SpecSize> specSizeMap = new HashMap<>();
        if (sizeSkuInfoSpec != null) {
            for (SkuInfoSpecValue skuInfoSpecValue : sizeSkuInfoSpec.getValueList()) {
                SpecSize specSize = new SpecSize();
                specSize.setSize(skuInfoSpecValue.getValueName());
                specSizeMap.put(skuInfoSpecValue.getValueId(), specSize);
            }
        }

        HashMap<String, SkuInfoFormatArrLocal> skuFormatArrLocal = skuInfoDto.getData().getSkuFormatArrLocal();
        for (Map.Entry<String, SkuInfoFormatArrLocal> entry : skuFormatArrLocal.entrySet()) {
            String key = entry.getKey();
            SkuInfoFormatArrLocal skuInfoFormatArrLocal = entry.getValue();

            SpecColor specColor;
            SpecSize specSize = null;

            String[] split = key.split(":");
            if (split.length >= 2) {
                // 原站解析中有时候会倒序有时候会正序。
                specColor = specColorMap.get(Integer.valueOf(split[0]));
                specSize = specSizeMap.get(Integer.valueOf(split[1]));

                if (specColor == null || specSize == null) {
                    specColor = specColorMap.get(Integer.valueOf(split[1]));
                    specSize = specSizeMap.get(Integer.valueOf(split[0]));

                    if (specColor == null || specSize == null) {
                        SpiderException.triggerParseFailed();
                        continue;
                    }
                }
            } else {
                /**
                 * 有一些 dealy 商品没有 sku，只有 color 信息。
                 */
                specColor = specColorMap.get(Integer.valueOf(key));
            }

            /**
             * 根据产品经理要求将 dealy 没有 sku 的商品显示为 default
             */
            if (specSize == null) {
                specSize = new SpecSize();
            }

            if (!StringUtils.hasText(specSize.getSize())) {
                specSize.setSize("default");
            }

            SpecMix specMix = new SpecMix();
            specMix.setSpecColor(specColor);
            specMix.setSpecSize(specSize);

            SpecPrice specPrice = new SpecPrice();
            specPrice.setOriginalPrice(skuInfoFormatArrLocal.getPrice());
            specPrice.setRetailPrice(skuInfoFormatArrLocal.getPromote_price());
            specMix.setSpecPrice(specPrice);
            specMixList.add(specMix);
        }

//        try {
//            log.debug("\n" + new ObjectMapper().writeValueAsString(specColorMap));
//            log.debug("\n" + new ObjectMapper().writeValueAsString(specSizeMap));
//            log.debug("\n" + new ObjectMapper().writeValueAsString(specMixList));
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }

        for (int index = 0; index < specMixList.size(); index++) {
            SpecMix specMix = specMixList.get(index);

            SpiderProductSku spiderProductSku = new SpiderProductSku();
//            spiderProductSku.setId(new Random().nextInt(999999999));
            spiderProductSku.setUuid(spiderProduct.getUuid() + index);
            spiderProductSku.setNo(spiderProductSku.getUuid());
            spiderProductSku.setProductNo(spiderProduct.getUuid() + index);
            spiderProductSku.setColor(specMix.getSpecColor().getColor());
            spiderProductSku.setSize(specMix.getSpecSize().getSize());
            spiderProductSku.setOriginalPrice(BigDecimal.valueOf(specMix.getSpecPrice().getOriginalPrice()));
            spiderProductSku.setRetailPrice(BigDecimal.valueOf(specMix.getSpecPrice().getRetailPrice()));
            spiderProductSku.setCurrency(spiderProduct.getCurrency());
            spiderProductSku.setQuantity(9999);
            spiderProductSku.setProductUuid(spiderProduct.getUuid());
            spiderProductSku.setCreatedAt(new Date());
            spiderProductSku.setUpdatedAt(new Date());
            spiderProductSku.setShippingPrice(dealyPrice.shippingPriceByCategoryName(categoryName));
            spiderProductSku.setShippingCurrency(spiderProduct.getCurrency());
            spiderProductSku.setStatus(0);
            spiderProductSku.setIsDeleted(0);
            spiderProductSku.setSpiderRefer(dealyFetchProvider.getSpiderConfig().getSpiderRefer());
            spiderProductSku.setSpiderProduct(spiderProduct);

            spiderProductSkuList.add(spiderProductSku);
        }

        return spiderProductSkuList;
    }

    @Override
    @Transactional
    public SpiderProduct insertByDealyGoodsId(String categoryName, Integer marketingType, Integer goodsId) {
        dealyPrice.init();

        log.info("\tbegin parse goodsIdStr for goodsId: " + goodsId);

        String goodsIdStr = dealyFetchProvider.getGoodsIdStr(goodsId);
        if (goodsIdStr == null) {
            SpiderException.triggerParseFailed();
            return null;
        }

        SpiderProduct spiderProduct = spiderProductRepository.findByCustomNo(goodsIdStr);
        if (spiderProduct != null) {
            log.info("\t\tspiderProduct exists for goodsIdStr: " + goodsIdStr);
             return spiderProduct;
        }

        return insertByDealyGoodsIdStr(categoryName, marketingType, goodsIdStr);
    }

    @Override
    public SpiderProduct insertByDealyGoodsIdStr(String categoryName, Integer marketingType, String goodsIdStr) {
        dealyPrice.init();

//        System.out.println("\t\tget goodsInfoDto for goodsIdStr: " + goodsIdStr);

        GoodsInfoDto goodsInfoDto = dealyFetchProvider.getGoodsInfo(goodsIdStr);
        if (goodsInfoDto.getCode() != 200) {
            SpiderException.triggerParseFailed();
//            System.out.println("\t\tget goodsInfoDto for goodsIdStr: " + goodsIdStr + " failed");
            return null;
        }

//        System.out.println("\t\tget goodsInfoDto for goodsIdStr: " + goodsIdStr + " ok");
//        System.out.println("\t\tfillToShallchicProduct for goodsIdStr: " + goodsIdStr);
        SpiderProduct spiderProduct = fillToShallchicProduct(categoryName, marketingType, goodsIdStr, goodsInfoDto);
//        System.out.println("\t\tfillToShallchicProductSku for goodsIdStr: " + goodsIdStr);
        List<SpiderProductSku> spiderProductSkuList = fillToShallchicProductSku(categoryName, goodsIdStr, goodsInfoDto, spiderProduct);
        log.info("\t\tget sku size: " + spiderProductSkuList.size() + " for goodsIdStr: " + goodsIdStr);
        if (spiderProductSkuList.size() == 0) {
            SpiderException.triggerParseFailed();
            return null;
        }

//        try {
//            String json = new ObjectMapper().writeValueAsString(spiderProduct);
//            System.out.println(json);
//            json = new ObjectMapper().writeValueAsString(spiderProductSkuList);
//            System.out.println(json);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }

        SpiderProduct spiderProductQuery = spiderProductRepository.findByUuid(spiderProduct.getUuid());
        if (spiderProductQuery == null) {
            spiderProduct.setId(null);
            spiderProduct = spiderProductRepository.save(spiderProduct);
        } else {
            log.info("\tspiderProductUuid: " + spiderProduct.getUuid() + " is exist, ignore this insert/");
            spiderProduct = spiderProductQuery;
        }

        for (SpiderProductSku spiderProductSku : spiderProductSkuList) {
            if (spiderProductSkuRepository.findByUuid(spiderProductSku.getUuid()) == null) {
                spiderProductSku.setSpiderProduct(spiderProduct);
                spiderProductSku.setId(null);
                spiderProductSkuRepository.save(spiderProductSku);
            } else {
                log.info("\tspiderProductSkuUuid: " + spiderProductSku.getUuid() + " is exist, ignore this insert.");
            }
        }

        log.info("\t\tfinish save spiderProduct(id: " + spiderProduct.getId() +") for goodsIdStr: " + goodsIdStr);

        return spiderProduct;
    }
}
