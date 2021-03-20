package com.project.spider.core.upload;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class AwsS3Key implements Serializable {
    private String accessKeyId;
    private String accessSecretKey;
    private String region;
    private String sessionToken;
    private String bashPath;
}
