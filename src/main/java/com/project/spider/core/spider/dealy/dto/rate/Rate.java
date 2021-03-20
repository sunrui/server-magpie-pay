package com.project.spider.core.spider.dealy.dto.rate;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Rate {
    private List<RateInfo> info;
    private String jollychic_env;
    private String domain;
    private String appUrl;
}

/*
{
	"code": 200,
	"data": {
		"info": [{
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
		}, {
			"rate": "1.353730",
			"code": "aud",
			"symbol": " AUD",
			"name": "Australian Dollar",
			"exception": {
				"ar": {
					"symbol": "AUD ",
					"sequence": "left"
				}
			}
		}, {
			"rate": "0.377056",
			"code": "bhd",
			"symbol": " BHD",
			"name": "Bahraini Dinar",
			"exception": {
				"ar": {
					"symbol": " د.ب",
					"sequence": "left"
				}
			}
		}, {
			"rate": "1.299550",
			"code": "cad",
			"symbol": " CAD",
			"name": "Canadian Dollar",
			"exception": {
				"ar": {
					"symbol": "CAD ",
					"sequence": "left"
				}
			}
		}, {
			"rate": "0.905046",
			"code": "chf",
			"symbol": " CHF",
			"name": "Swiss Franc",
			"exception": {
				"ar": {
					"symbol": "CHF ",
					"sequence": "left"
				}
			}
		}, {
			"rate": "15.639745",
			"code": "egp",
			"symbol": " E£",
			"name": "Egypt",
			"exception": {
				"ar": {
					"symbol": "ج.م",
					"sequence": "left"
				}
			}
		}, {
			"rate": "0.835858",
			"code": "eur",
			"symbol": " €",
			"name": "Euro",
			"exception": {
				"ar": {
					"symbol": "€",
					"sequence": "left"
				}
			}
		}, {
			"rate": "0.751512",
			"code": "gbp",
			"symbol": "£",
			"name": "British Pound",
			"sequence": "left",
			"exception": {
				"tr": {
					"sequence": "right",
					"symbol": " £"
				}
			}
		}, {
			"rate": "7.750640",
			"code": "hkd",
			"symbol": "HK$ ",
			"name": "Hong Kong",
			"sequence": "left"
		}, {
			"rate": "14074.529829",
			"code": "idr",
			"symbol": "Rp ",
			"name": "Indonesia",
			"sequence": "left"
		}, {
			"rate": "73.962450",
			"code": "inr",
			"symbol": "Rs ",
			"name": "India",
			"sequence": "left"
		}, {
			"rate": "0.708804",
			"code": "jod",
			"symbol": " JOD",
			"name": "Jordan",
			"exception": {
				"ar": {
					"symbol": "د.أ",
					"sequence": "left"
				}
			}
		}, {
			"rate": "104.066040",
			"code": "jpy",
			"symbol": "¥ ",
			"name": "Japan",
			"sequence": "left"
		}, {
			"rate": "0.305504",
			"code": "kwd",
			"symbol": " KWD",
			"name": "Kuwaiti Dinar",
			"exception": {
				"ar": {
					"symbol": " د.ك",
					"sequence": "left"
				}
			}
		}, {
			"rate": "1512.903563",
			"code": "lbp",
			"symbol": "LBP ",
			"name": "Lebanon",
			"sequence": "left",
			"exception": {
				"ar": {
					"symbol": " ل.ل",
					"sequence": "right"
				}
			}
		}, {
			"rate": "20.037604",
			"code": "mxn",
			"symbol": " MXN",
			"name": "Mexican Peso",
			"exception": {
				"ar": {
					"symbol": "MXN ",
					"sequence": "left"
				}
			}
		}, {
			"rate": "4.069504",
			"code": "myr",
			"symbol": "RM",
			"name": "Malaysia",
			"sequence": "left"
		}, {
			"rate": "8.836304",
			"code": "nok",
			"symbol": " NOK",
			"name": "Norwegian Krone",
			"exception": {
				"ar": {
					"symbol": "NOK ",
					"sequence": "left"
				}
			}
		}, {
			"rate": "1.424842",
			"code": "nzd",
			"symbol": " NZD",
			"name": "New Zealand Dollar",
			"exception": {
				"ar": {
					"symbol": "NZD ",
					"sequence": "left"
				}
			}
		}, {
			"rate": "0.384963",
			"code": "omr",
			"symbol": " OMR",
			"name": "Oman",
			"exception": {
				"ar": {
					"symbol": "ر.ع",
					"sequence": "left"
				}
			}
		}, {
			"rate": "3.747650",
			"code": "pln",
			"symbol": " PLN",
			"name": "Polish Zloty",
			"exception": {
				"ar": {
					"symbol": "PLN ",
					"sequence": "left"
				},
				"pl": {
					"symbol": " zł",
					"sequence": "right"
				}
			}
		}, {
			"rate": "3.640750",
			"code": "qar",
			"symbol": " QAR",
			"name": "Qatar riyal",
			"exception": {
				"ar": {
					"symbol": " ر.ق",
					"sequence": "left"
				}
			}
		}, {
			"rate": "3.757190",
			"code": "sar",
			"symbol": " SAR",
			"name": "Saudi Riyal",
			"exception": {
				"ar": {
					"symbol": " ر.س",
					"sequence": "left"
				}
			}
		}, {
			"rate": "8.494604",
			"code": "sek",
			"symbol": " SEK",
			"name": "Swedish Krona",
			"exception": {
				"ar": {
					"symbol": "SEK ",
					"sequence": "left"
				}
			}
		}, {
			"rate": "1.338204",
			"code": "sgd",
			"symbol": " SGD",
			"name": "Singapore Dollar",
			"exception": {
				"ar": {
					"symbol": "SGD ",
					"sequence": "left"
				}
			}
		}, {
			"rate": "7.835204",
			"code": "try",
			"symbol": " TL",
			"name": "Turkey",
			"exception": {
				"ar": {
					"symbol": "TL ",
					"sequence": "left"
				}
			}
		}, {
			"rate": "28.518504",
			"code": "twd",
			"symbol": "NT$ ",
			"name": "Taiwan",
			"sequence": "left"
		}, {
			"rate": "1.000000",
			"code": "usd",
			"symbol": "$",
			"name": "US Dollar",
			"sequence": "left",
			"exception": {
				"tr": {
					"sequence": "right",
					"symbol": " $"
				}
			}
		}, {
			"rate": "23161.500000",
			"code": "vnd",
			"symbol": " ₫",
			"name": "Vietnam",
			"exception": {
				"ar": {
					"symbol": "₫ ",
					"sequence": "left"
				}
			}
		}, {
			"rate": "76.078904",
			"code": "rub",
			"symbol": " руб.",
			"name": "Russia",
			"exception": {
				"ar": {
					"symbol": "руб. ",
					"sequence": "left"
				}
			}
		}, {
			"rate": "1210.000000",
			"code": "iqd",
			"symbol": " IQD",
			"name": "Iraqi Dinar",
			"exception": {
				"ar": {
					"symbol": "IQD ",
					"sequence": "left"
				}
			}
		}, {
			"rate": "5075.000000",
			"code": "irt",
			"symbol": " Toman",
			"name": "Iran",
			"exception": {
				"ar": {
					"symbol": "تومان",
					"sequence": "left"
				}
			},
			"filter": 1
		}, {
			"rate": "42105.000352",
			"code": "irr",
			"symbol": " Rials",
			"name": "Iran",
			"exception": {
				"ar": {
					"symbol": "﷼",
					"sequence": "left"
				}
			},
			"filter": 1
		}],
		"currencyRule": {
			"specialCurrencyRule": {
				"idr": {
					"divisionNum": 3,
					"divisionSymbol": "."
				},
				"rub": {
					"divisionNum": 3,
					"divisionSymbol": " "
				},
				"vnd": {
					"divisionNum": 3,
					"divisionSymbol": "."
				},
				"jpy": {
					"divisionNum": 3,
					"divisionSymbol": ","
				}
			},
			"currencyRule": {
				"usd": {
					"blank": 0,
					"countryCode": "EN",
					"currency": "USD",
					"iconUrl": "/app/currency/usd.png",
					"name": "US Dollar",
					"pointNum": 2,
					"position": 1,
					"rate": 1,
					"symbol": "$"
				},
				"sar": {
					"blank": 1,
					"countryCode": "EN",
					"currency": "SAR",
					"iconUrl": "/app/currency/sar.png",
					"name": "Saudi Riyal",
					"pointNum": 2,
					"position": 0,
					"rate": 3.75719,
					"symbol": "SAR"
				},
				"jod": {
					"blank": 1,
					"countryCode": "EN",
					"currency": "JOD",
					"iconUrl": "/app/currency/jod.png",
					"name": "Jordan",
					"pointNum": 2,
					"position": 0,
					"rate": 0.708804,
					"symbol": "JOD"
				},
				"aud": {
					"blank": 1,
					"countryCode": "EN",
					"currency": "AUD",
					"iconUrl": "/app/currency/aud.png",
					"name": "Australian Dollar",
					"pointNum": 2,
					"position": 0,
					"rate": 1.35373,
					"symbol": "AUD"
				},
				"aed": {
					"blank": 1,
					"countryCode": "EN",
					"currency": "AED",
					"iconUrl": "/app/currency/aed.png",
					"name": "United Arab Emirates Dirham",
					"pointNum": 2,
					"position": 0,
					"rate": 3.685,
					"symbol": "AED"
				}
			}
		},
		"jollychic_env": "",
		"domain": "m.dealy1688.com",
		"appUrl": "https%3A%2F%2Fdealy.onelink.me%2FXkIx%2F7fba5789"
	},
	"message": ""
}
 */
