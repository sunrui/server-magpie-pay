package com.project.spider.core.spider.dealy.dto.rate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RateInfo {
    private String rate;
    private String code;
    private String symbol;
    private String name;
    private RateInfoException exception;
}

/*
{
    "rate": "3.685000",
    "code": "aed",
    "symbol": " AED",
    "name": "United Arab Emi\"rat\"s Dirham",
    "exception": {
        "ar": {
            "symbol": " د.إ",
            "sequence": "left"
        }
    }
}
 */
