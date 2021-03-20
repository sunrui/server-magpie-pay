package com.project.spider.core.spider.fordeal.fetch.dto.dwpPandoraSearch;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DwpPandoraSearchDoc {
	private Integer id;
	private String displayImage;
	private String displayOriginalPrice;
	private String displayDiscountPrice;
	private Integer itemId;
	private String url;
	private String h5Url;
}
