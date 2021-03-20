package com.project.spider.price;

import com.project.spider.core.db.spider.entity.ProdProduct;
import com.project.spider.core.db.spider.entity.ProdSku;
import com.project.spider.core.db.spider.repository.ProdProductRepository;
import com.project.spider.core.db.spider.repository.ProdSkuRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Log4j2
@SpringBootTest
public class PriceFixTests {
	@Autowired
	private ProdProductRepository prodProductRepository;
	@Autowired
	private ProdSkuRepository prodSkuRepository;

	@Test
	void testForPriceFix() {
		ProdProduct prodProduct = prodProductRepository.findByUuid("fb648d7e6c70359913bd96b365650934");
		if (prodProduct == null) {
			return;
		}

		log.info("prodProduct.getRetailPrice(): " + prodProduct.getRetailPrice());
		log.info("prodProduct.getOriginalPrice(): " + prodProduct.getOriginalPrice());

		List<ProdSku> prodSkuList = prodSkuRepository.findAllByProductUuid(prodProduct.getUuid());
		for (ProdSku prodSku : prodSkuList) {
			log.info("prodSku.getRetailPrice(): " + prodSku.getRetailPrice());
			log.info("prodSku.getOriginalPrice(): " + prodSku.getOriginalPrice());
		}
	}
}
