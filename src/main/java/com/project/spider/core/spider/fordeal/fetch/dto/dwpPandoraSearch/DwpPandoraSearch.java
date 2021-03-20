package com.project.spider.core.spider.fordeal.fetch.dto.dwpPandoraSearch;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DwpPandoraSearch {
	private String sort;
	private Object debugInfo;
	private String seoTitle;
	private Boolean isEnd;
	private String cparam;
	private String displayStyle;
	private String path;
	private Integer total;
	private Boolean found;
	private Object sortList;
	private Integer fcid;
	private Integer page;
	private String keyword;
	private List<DwpPandoraSearchDoc> docs;
}
