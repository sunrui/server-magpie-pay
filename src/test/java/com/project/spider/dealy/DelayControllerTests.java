package com.project.spider.dealy;

import com.project.spider.controller.dealy.DealyController;
import com.project.spider.controller.dealy.res.flashSale.FlashSaleVo;
import com.project.spider.controller.dealy.res.product.ProductCategory;
import com.project.spider.controller.dealy.res.product.ProductSubCategory;
import com.project.spider.controller.dealy.res.sku.SkuInfoVo;
import com.project.spider.core.spider.dealy.dto.categoryGoodsList.CategoryGoodsBaseInfoDataGoods;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
class DelayControllerTests {
    @Autowired
    private DealyController dealyController;

    @Test
    void contextLoads() {
    }

    @Test
    void testForFlashSale() {
        List<FlashSaleVo> flashSale = dealyController.getFlashSale();
        for (FlashSaleVo flashSaleVo : flashSale) {
            System.out.println("Flash Sale:");
            System.out.println("\ttableTime: " + flashSaleVo.getTableTime() + " - " +
                    new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(flashSaleVo.getTableTime() * 1000L)));
            System.out.println("\tgroupId: " + flashSaleVo.getGroupId());
            System.out.println("\tgoodsCount: " + flashSaleVo.getGoodsCount());
        }
    }

    @ParameterizedTest
    @CsvSource({
            "false", // Women's Clothing
    })
    void testForProductCategory(boolean deepTest) {
        List<ProductCategory> productCategoryList = dealyController.getProductCategory();
        System.out.println("ProductCategory: " + productCategoryList.size());
        for (ProductCategory productCategory : productCategoryList) {
            System.out.println("id: " + productCategory.getId());
            System.out.println("\tname: " + productCategory.getName());

            if (deepTest) {
                testForSubCategory(productCategory.getId(), deepTest);
            }
        }
    }

    @ParameterizedTest
    @CsvSource({
            "19311, false", // Women's Clothing
    })
    void testForSubCategory(Integer categoryId, boolean deepTest) {
        List<ProductSubCategory> productSubCategoryList = dealyController.getProductSubCategory(categoryId);
        System.out.println("ProductSubCategory: " + productSubCategoryList.size());
        for (ProductSubCategory productSubCategory : productSubCategoryList) {
            System.out.println("id: " + productSubCategory.getId());
            System.out.println("\tname: " + productSubCategory.getName());
            System.out.println("\ticonUrl: " + productSubCategory.getIconUrl());
            System.out.println("\tcategoryId: " + productSubCategory.getCategoryId());

            if (deepTest) {
                testForSubCategoryGoods(productSubCategory.getCategoryId());
            }
        }
    }

    @ParameterizedTest
    @CsvSource({
            "4890", // Shirts
    })
    void testForSubCategoryGoods(Integer subCategoryId) {
        List<CategoryGoodsBaseInfoDataGoods> goodsList = dealyController.getProductSubCategoryGoods(subCategoryId);
        System.out.println("SubCategoryGoods: " + goodsList.size());
        for (CategoryGoodsBaseInfoDataGoods goods : goodsList) {
            System.out.println("id: " + goods.getGoodsId());
            System.out.println("\tname: " + goods.getGoodsName());
            System.out.println("\tshopPrice: " + goods.getShopPrice());
            System.out.println("\twholeImgLink: " + goods.getWholeImgLink());
        }
    }

    @ParameterizedTest
    @CsvSource({
            "0xdx0x-k-kgqgmcwyy4oo-73", // Shirts
    })
    void testForSkuInfo(String goodsIdStr) {
        SkuInfoVo skuInfoVo = dealyController.getSkuInfo(goodsIdStr);
        System.out.println(skuInfoVo.toString());
    }

    @Test
    void testForFetchElapsedTime() {
        Date start = new Date();
        testForFlashSale();
        testForProductCategory(true);
        long elapsed = new Date().getTime() - start.getTime();
        String time = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(elapsed));
        System.out.println("elapsed time: " + time);
    }
}
