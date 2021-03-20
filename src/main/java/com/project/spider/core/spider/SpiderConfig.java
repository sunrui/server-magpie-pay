package com.project.spider.core.spider;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SpiderConfig {
    /**
     * 爬虫的语言
     */
    private SpiderLang spiderLang;
    /**
     * 主机前缀
     */
    private String host;
    /**
     * 爬虫来源
     */
    private SpiderRefer spiderRefer;
}
