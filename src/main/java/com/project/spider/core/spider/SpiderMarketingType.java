package com.project.spider.core.spider;

import lombok.Getter;

/**
 * 此号码是与生产服 prodProduct 同步
 */
@Getter
public enum SpiderMarketingType {
    NORMAL(0),
    FLASH_SALE(4),
    BUY_ONE_GET_ONE_EXTRA_FREE(16);

    SpiderMarketingType(Integer code) {
        this.code = code;
    }

    private final Integer code;
}
