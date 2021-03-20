package com.project.spider.core.upload;

import java.io.Serializable;
import java.util.Date;

public class AwsS3Cache {
    private final String cacheKey = "awsKey";

    static class AwsS3KeyTtl implements Serializable {
        private AwsS3Key awsS3Key;
        private Date expiredAt;
    }

    public void setCache(AwsS3Code code, AwsS3Key awsS3Key) {
        AwsS3KeyTtl awsS3KeyTtl = new AwsS3KeyTtl();
        awsS3KeyTtl.awsS3Key = awsS3Key;
        final int cacheKeyMaxTtl = 11 * 60 * 60 * 1000;
        awsS3KeyTtl.expiredAt = new Date(new Date().getTime() + cacheKeyMaxTtl);

        String json = AwsS3Serialize.serializeObject(awsS3KeyTtl);
    }

    public AwsS3Key getCache(AwsS3Code code) {
        String json = "";
        AwsS3KeyTtl awsS3KeyTtl = (AwsS3KeyTtl) AwsS3Serialize.deSerializeObject(json);
        if (awsS3KeyTtl == null) {
            return null;
        }

        if (awsS3KeyTtl.expiredAt.before(new Date())) {
            return null;
        }

        return awsS3KeyTtl.awsS3Key;
    }
}
