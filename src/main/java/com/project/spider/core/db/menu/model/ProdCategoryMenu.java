package com.project.spider.core.db.menu.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProdCategoryMenu {
	private String categoryNo;
	private String name;
	private String nameZh;
	private List<ProdSubCategoryMenu> menuList;
}
