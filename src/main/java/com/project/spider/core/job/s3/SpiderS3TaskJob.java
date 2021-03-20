package com.project.spider.core.job.s3;

import com.project.spider.core.db.spider.entity.ProdProduct;
import com.project.spider.core.db.spider.entity.ProdSku;
import com.project.spider.core.db.spider.entity.SpiderS3Task;
import com.project.spider.core.db.spider.service.ProdProductService;
import com.project.spider.core.db.spider.service.ProdSkuService;
import com.project.spider.core.db.spider.service.SpiderS3TaskService;
import com.project.spider.core.upload.AwsS3Upload;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Log4j2
@Service
public class SpiderS3TaskJob {
    @Autowired
    private SpiderS3TaskService spiderS3TaskService;
    @Autowired
    private AwsS3Upload awsS3Upload;
    @Autowired
    private ProdSkuService prodSkuService;
    @Autowired
    private ProdProductService prodProductService;

    public void uploadImageToAwsS3(ProdProduct prodProduct) {
        String mainPhoto = prodProduct.getMainPhoto();
        mainPhoto = awsS3Upload.uploadAwsS3ImageFile(mainPhoto);
        prodProduct.setMainPhoto(mainPhoto);
        String[] photos = prodProduct.getPhotosStr().split(",");
        StringBuilder awsPhotos = new StringBuilder();
        for (String photo : photos) {
            photo = awsS3Upload.uploadAwsS3ImageFile(photo);
            awsPhotos.append(photo).append(",");
        }

        if (awsPhotos.length() > 0) {
            awsPhotos.substring(0, awsPhotos.length() - 1);
            prodProduct.setPhotosStr(awsPhotos.toString());
        }

        List<ProdSku> prodSkuList = prodSkuService.findByProductUuid(prodProduct.getUuid());
        for (ProdSku prodSku : prodSkuList) {
            if (StringUtils.hasText(prodSku.getPhotosStr())) {
                String[] photoSkus = prodSku.getPhotosStr().split(",");
                StringBuilder awsPhotoSkus = new StringBuilder();
                for (String photo : photoSkus) {
                    photo = awsS3Upload.uploadAwsS3ImageFile(photo);
                    awsPhotoSkus.append(photo).append(",");
                }

                if (awsPhotoSkus.length() > 0) {
                    awsPhotoSkus.substring(0, awsPhotoSkus.length() - 1);
                    prodSku.setPhotosStr(awsPhotoSkus.toString());
                }
            }
        }
    }

    @Scheduled(initialDelay = 5000, fixedDelay = 5 * 1000)
    void upload() {
        log.info("SpiderS3TaskJob.upload");

        for (int page = 0; ; page++) {
            Page<SpiderS3Task> spiderS3TaskPage = spiderS3TaskService.findAll(page, 10);
            if (spiderS3TaskPage.getNumberOfElements() == 0) {
                break;
            }

            for (SpiderS3Task spiderS3Task : spiderS3TaskPage.getContent()) {
                ProdProduct prodProduct = prodProductService.findById(spiderS3Task.getProductProductId());
                if (prodProduct == null) {
                    log.warn("proProduct is null for id: " + spiderS3Task.getProductProductId());
                    continue;
                }

                log.info("begin upload prodProduct to S3 for id: " + spiderS3Task.getId());
                uploadImageToAwsS3(prodProduct);
                prodProductService.updateProduct(prodProduct.getId(), prodProduct);
                spiderS3TaskService.deleteById(spiderS3Task.getId());
                log.info("end upload prodProduct to S3 for id: " + spiderS3Task.getId());
            }
        }
    }
}
