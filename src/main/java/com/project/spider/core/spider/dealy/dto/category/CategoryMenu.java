package com.project.spider.core.spider.dealy.dto.category;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryMenu {
    private Integer id; // 对应二级目录 parentId
    private Integer isAll;
    private String showName;
    private String url;
}
