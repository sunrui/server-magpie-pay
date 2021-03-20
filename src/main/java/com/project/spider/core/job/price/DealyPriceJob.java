package com.project.spider.core.job.price;

import com.project.spider.core.db.spider.entity.ProdProduct;
import com.project.spider.core.db.spider.entity.ProdSku;
import com.project.spider.core.db.spider.repository.ProdProductRepository;
import com.project.spider.core.db.spider.repository.ProdSkuRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

@Log4j2
@Service
public class DealyPriceJob {
	@Autowired
	private ProdProductRepository prodProductRepository;
	@Autowired
	private ProdSkuRepository prodSkuRepository;

	@Scheduled(initialDelay = 5000, fixedDelay = 5 * 60 * 1000)
	public void fixPriceJob() {
		log.info("DealyPriceJob.fixPriceJob");

		// 2020.1.7 处理一次解决目前的 jolly chic 价格倒挂问题，开启一次，以后的在入库时自动会较验是否价格倒挂的问题。
		for (int page = 0; ; page++) {
			// 优先洗最新加的数据。
			Page<ProdProduct> prodProductPage = prodProductRepository.findAllByOrderByCreatedAtDesc(PageRequest.of(page, 10));
//			Page<ProdProduct> prodProductPage = prodProductRepository.findAllByCreatedAtAfter(new Date(new Date().getTime() - 14 * 24 * 60 * 60 * 1000), PageRequest.of(page, 10));
			if (!prodProductPage.hasContent()) {
				break;
			}

			for (ProdProduct prodProduct : prodProductPage.getContent()) {
				BigDecimal originalPrice = prodProduct.getOriginalPrice();
				BigDecimal retailPrice = prodProduct.getRetailPrice();
				retailPrice = retailPrice.min(originalPrice);

				for (ProdSku prodSku : prodProduct.getProdProductSkuList()) {
					originalPrice = originalPrice.min(prodSku.getOriginalPrice());
					retailPrice = retailPrice.min(prodSku.getRetailPrice());

					if (retailPrice.compareTo(originalPrice) > 0) {
						retailPrice = originalPrice;

						prodSku.setRetailPrice(retailPrice);
						prodSkuRepository.save(prodSku);
					}
				}

				retailPrice = retailPrice.min(originalPrice);

				if (prodProduct.getOriginalPrice().equals(originalPrice) && prodProduct.getRetailPrice().equals(retailPrice)) {
//					log.info("prodProduct price normal for id: " + prodProduct.getId());
					// 价格展示正常
					continue;
				}

				log.info("prodProduct price fix for id: " + prodProduct.getId());

				prodProduct.setOriginalPrice(originalPrice);
				prodProduct.setRetailPrice(retailPrice);
				prodProduct.setUpdatedAt(new Date());
				prodProductRepository.save(prodProduct);
			}
		}

		log.info("prodProduct price fix finish.");
	}
}
