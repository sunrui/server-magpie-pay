package com.project.spider.core.spider.dealy.dto.rate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RateInfoException {
    @Getter
    @Setter
    public static class Ar {
        private String symbol;
        private String sequence;
    }

    private Ar ar;
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
