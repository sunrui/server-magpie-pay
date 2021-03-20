package com.project.spider.core.upload;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.project.spider.common.util.RandomUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

@Log4j2
@Service
public class AwsS3Upload {
    private final AmazonS3 s3;
    private final String accessKey = "AKIAIN3B42OZREJBKBGA";
    private final String secretKey = "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";
    private final String bucketName = "cdn-arab";
    private String uploadPrefix = "/spu/81a650c6ecec11e983ec0242ac110007/";

    private static Integer dateToInteger(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        return Integer.valueOf(simpleDateFormat.format(date));
    }

    public AwsS3Upload() {
        s3 = new AmazonS3Client(new BasicAWSCredentials(accessKey, secretKey));
        s3.setRegion(Region.getRegion(Regions.US_EAST_1));

        uploadPrefix += dateToInteger(new Date());
    }

    public String uploadToS3LocalFile(File file, String fileName) {
        try {
            String bucketPath = bucketName + uploadPrefix;
            s3.putObject(new PutObjectRequest(bucketPath, fileName, file)
                    .withCannedAcl(CannedAccessControlList.PublicRead));
            GeneratePresignedUrlRequest urlRequest = new GeneratePresignedUrlRequest(bucketPath, fileName);
            URL url = s3.generatePresignedUrl(urlRequest);
            return url.toString();
        } catch (AmazonClientException ase) {
            ase.printStackTrace();
            return null;
        }
    }

    public String uploadToS3NetFile(String fileUrl, String contentType, String fileName) {
        try {
            String bucketPath = bucketName + uploadPrefix;

            ObjectMetadata objectMetadata = new ObjectMetadata();
            URL url = new URL(fileUrl);
            objectMetadata.setContentType(contentType);

            s3.putObject(new PutObjectRequest(bucketPath, fileName, url.openStream(), objectMetadata)
                    .withCannedAcl(CannedAccessControlList.PublicRead));
            GeneratePresignedUrlRequest urlRequest = new GeneratePresignedUrlRequest(bucketPath, fileName);
            return "https://cdn-ae.shallchic.com" + uploadPrefix + "/" + fileName;
        } catch (AmazonClientException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String getFileName(String fullUrl) {
        int index = fullUrl.lastIndexOf("/");
        if (index != -1) {
            return fullUrl.substring(index + 1);
        }

        return RandomUtil.generateString(10);
    }

    private String getFileExt(String fullUrl) {
        int index = fullUrl.lastIndexOf(".");
        if (index != -1) {
            return fullUrl.substring(index + 1);
        }

        return "jpg";
    }

    public String uploadAwsS3ImageFile(String originalFile) {
        String awsS3File = uploadToS3NetFile(originalFile, "image/" + getFileExt(originalFile), getFileName(originalFile));
//        log.debug(originalFile);
//        log.debug(awsS3File);
        return awsS3File;
    }
}
