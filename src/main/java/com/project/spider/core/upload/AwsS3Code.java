package com.project.spider.core.upload;

import lombok.Getter;

@Getter
public enum AwsS3Code {
    AVR("cat", "类目图片"),
    REV("ads", "广告图片"),
    RFD("msg", "消息/推送"),
    FDK("aud", "商品审核");

    AwsS3Code(String code, String comment) {
        this.code = code;
        this.comment = comment;
    }

    private final String code;
    private final String comment;
}
