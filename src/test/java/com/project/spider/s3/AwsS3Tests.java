package com.project.spider.s3;

import com.project.spider.core.upload.AwsS3Cache;
import com.project.spider.core.upload.AwsS3Code;
import com.project.spider.core.upload.AwsS3Key;
import com.project.spider.core.upload.AwsS3Upload;
import com.project.spider.core.db.spider.entity.ProdProduct;
import com.project.spider.core.db.spider.service.ProdProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.io.File;

@SpringBootTest
public class AwsS3Tests {
    @Autowired
    private ProdProductService prodProductService;
    @Autowired
    private AwsS3Upload awsS3Upload;

    @Test
    void contextLoads() {
    }

    @Test
    void testForUpload() {
        AwsS3Cache awsS3Cache = new AwsS3Cache();

        AwsS3Key awsS3Key = new AwsS3Key();
        awsS3Key.setAccessKeyId("ASIAVOIWJRDVEI34QUMF");
        awsS3Key.setBashPath("https://cdn-test.shallchic.com/");
        awsS3Key.setAccessSecretKey("aEMNma8DK1z2t9HOiSGIfA9Fi0s1ElpFhMbd38Dg");
        awsS3Key.setRegion("us-west-2");
        awsS3Key.setSessionToken("IQoJb3JpZ2luX2VjEEsaCXVzLXdlc3QtMiJHMEUCIENZ8tGeHWyVuCC5rvLQ/GnCZLzYHOTfqMzp4Sjz1R+3AiEA2ArF2r1HGj1yA9JeC9tCUaMZn/XjdD/CQxEYXJ/BmZwq3wMI5P//////////ARAAGgwzNzQyNDU3ODc4ODIiDEPgLLDcCTuATTaeAiqzA5C9a3tE3ncP9jQA27sN5TPZEX/0Eo/dPfNI52EdPJYzgiK2l5LS+BEVRKV+gUniUwO2D+IbcWcCde883yuwToZqV6LirZzwGWPDlKseLoKE2eT7Y6JSkpPva7hsSvHGiP0T4CN2n8ckzl+6dFkGgW6Qz1qFPuvI992xBRQxT2BwsKW3BCb/HfdGZZaJ8hFjvORuxcwwVbpyP/mq+xbJd8sUeA8jrDrDfRyextV5Jd+sXClbwK7Rk4H0JxmX7sEISOzEVIoJJhql95l+eSEhrXdY6wkxVinpAR5fmxETP0YjGNKh7TDVI7k/dynfDE5VqPZ5M4a/YWmmfYnLNNTv58ANP6+M1DNPCn6b1imR1FH5wW/AlF9VsFGgHWvh4ahjUJaDftcWZv5WFuzuOlrhyLwTBVpG6bX4CWiwNdm5gaPb4etg61x/bwGB4jXeaTqWbLHJbfTGFg7wxz3So/gbNA+CEfIbIrqSivxO9RkIKXObYF7/lDTXbpJowUN8s0YMF+Lomn4bU3qIGb2S79nkoaM7W8gidPWIiyb/k3ws1b4QQmXOSrj1093OQeupt7Hn/0L/mTDGxeD+BTqdAQqBiSd/J1AAPu8VRYpIO2PZOwZCT+I1ViOuuehtG6LvyPMYqlf3ltxHAEEGUZx078OLjLIu8JUx8DZMN/p49BnmIQkpPw4DDOxZ1L5usskJ28YhHYxnmy2bA/LI5lKgCijE30gr93So5c36lfOqYu4b8r3ShLqMtq5ezZoOSGiHxnWLpCYFbyEao34b9VnZi/OqTIUYPp2VWxZJdu4=");
        awsS3Cache.setCache(AwsS3Code.AVR, awsS3Key);

        awsS3Key = awsS3Cache.getCache(AwsS3Code.AVR);
        System.out.println(awsS3Key.toString());
    }

    @Test
    void testForDirectUploadLocalFile() {
        File uploadFile = new File("/Users/sunrui/Downloads/1.jpg");
        String awsFile = new AwsS3Upload().uploadToS3LocalFile(uploadFile, "testForDirectUploadLocalFile.jpg");
        System.out.println(awsFile);
    }

    @Test
    void testForDirectUploadNetFile() {
        String fileUrl = "http://imcut.dealy1688.com/uploads/jollyimg/imageService/img/goods/2020/08/02/22/40/b9bdab82-27b9-4c25-b525-c1e4172f019f.jpg";
        String awsFile = new AwsS3Upload().uploadToS3NetFile(fileUrl, "image/jpg", "testForDirectUploadNetFile.jpg");
        System.out.println(awsFile);
    }

    @Test
    void testForUploadProdProduct() {
        Page<ProdProduct> prodProductPage = prodProductService.findAll(0, 1);
        String mainPhoto = awsS3Upload.uploadAwsS3ImageFile(prodProductPage.getContent().get(0).getMainPhoto());
        System.out.println(mainPhoto);
    }
}
