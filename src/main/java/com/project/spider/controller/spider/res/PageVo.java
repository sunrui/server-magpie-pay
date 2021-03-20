package com.project.spider.controller.spider.res;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PageVo<T> {
    private Integer currentPage;
    private Integer currentSize;
    private Integer totalPage;
    private Long totalSize;
    private List<T> data;
}
