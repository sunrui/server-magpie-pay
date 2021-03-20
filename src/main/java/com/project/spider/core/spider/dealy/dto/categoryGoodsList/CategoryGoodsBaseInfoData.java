package com.project.spider.core.spider.dealy.dto.categoryGoodsList;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CategoryGoodsBaseInfoData {
    private CategoryGoodsBaseInfoPageInfo pageInfo;
    private List<CategoryGoodsBaseInfoDataGoods> goodsList;
    private Integer isLastPage;
    private String currency;
    private Integer total;
}
