package com.project.spider.controller.spider.res;

import com.project.spider.core.db.spider.entity.ProdProduct;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostSaveToProdRes {
    private Boolean isSuccess;
    private String linkUuid;
    private Boolean categoryNoNeeded;
    private ProdProduct prodProduct;
    private Boolean spiderProductIdNotExist;
    private Boolean isAlreadyPutOn;
}
