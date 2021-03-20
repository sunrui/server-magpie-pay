package com.project.spider.dealy;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.spider.core.spider.dealy.DealyFetchProvider;
import com.project.spider.core.spider.dealy.dto.skuInfo.SkuInfoDto;
import com.project.spider.core.spider.dealy.dto.skuInfo.SkuInfoFormatArrLocal;
import com.project.spider.core.spider.dealy.dto.skuInfo.SkuInfoSpecValue;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
public class DelaySkuTests {
    @Autowired
    private DealyFetchProvider dealyFetchProvider;

    @Test
    void contextLoads() {
    }

    @ParameterizedTest
    @CsvSource({
//            "0xdx0xepr-og3-e-z6-w-eoo-73", // 有规格的场景
            "0xdx0x-k-kgqgmcwyy4oo-73", // Free 的场景
    })
    void testForSku(String goodsIdStr) {
        SkuInfoDto skuInfoDto = dealyFetchProvider.getSkuInfoDto(goodsIdStr);

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

        if (skuInfoDto.getData().getSkuInfo().size() < 2) {
            return;
        }

        if (!skuInfoDto.getData().getSkuInfo().get(0).getKeyName().contentEquals("Color")) {
            return;
        }

        if (!skuInfoDto.getData().getSkuInfo().get(1).getKeyName().contentEquals("Size")) {
            return;
        }

        Map<Integer, SpecColor> specColorMap = new HashMap<>();
        for (SkuInfoSpecValue skuInfoSpecValue : skuInfoDto.getData().getSkuInfo().get(0).getValueList()) {
            SpecColor specColor = new SpecColor();
            specColor.setColor(skuInfoSpecValue.getValueName());
            specColor.setImage(skuInfoSpecValue.getOriginalImg());
            specColorMap.put(skuInfoSpecValue.getValueId(), specColor);
        }

        Map<Integer, SpecSize> specSizeMap = new HashMap<>();
        for (SkuInfoSpecValue skuInfoSpecValue : skuInfoDto.getData().getSkuInfo().get(1).getValueList()) {
            SpecSize specSize = new SpecSize();
            specSize.setSize(skuInfoSpecValue.getValueName());
            specSizeMap.put(skuInfoSpecValue.getValueId(), specSize);
        }

        HashMap<String, SkuInfoFormatArrLocal> skuFormatArrLocal = skuInfoDto.getData().getSkuFormatArrLocal();
        for (Map.Entry<String, SkuInfoFormatArrLocal> entry : skuFormatArrLocal.entrySet()) {
            String key = entry.getKey();
            SkuInfoFormatArrLocal skuInfoFormatArrLocal = entry.getValue();

            String[] split = key.split(":");
            if (split.length < 2) {
                continue;
            }

            // 原站解析中有时候会倒序有时候会正序。
            SpecColor specColor = specColorMap.get(Integer.valueOf(split[0]));
            SpecSize specSize = specSizeMap.get(Integer.valueOf(split[1]));

            if (specColor == null || specSize == null) {
                specColor = specColorMap.get(Integer.valueOf(split[1]));
                specSize = specSizeMap.get(Integer.valueOf(split[0]));

                if (specColor == null || specSize == null) {
                    continue;
                }
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

        try {
            System.out.println(new ObjectMapper().writeValueAsString(specColorMap));
            System.out.println(new ObjectMapper().writeValueAsString(specSizeMap));
            System.out.println(new ObjectMapper().writeValueAsString(specMixList));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
