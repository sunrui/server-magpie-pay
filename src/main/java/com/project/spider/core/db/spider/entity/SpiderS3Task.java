package com.project.spider.core.db.spider.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * 默认的选品以后，是不会往服务器的 AWS S3 存的，当选择入库的时候，会在后台自动启动任务传。
 * 当没有传成功的话，如果查阅图此时显示的是 JOLLYCHIC 官网的图，处理好以后就显示的 CDN+S3 的。
 */
@Entity
@Getter
@Setter
public class SpiderS3Task {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Column(unique = true)
    private Integer productProductId;
}
