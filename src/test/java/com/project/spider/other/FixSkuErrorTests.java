package com.project.spider.other;

import com.project.spider.core.db.spider.entity.ProdProduct;
import com.project.spider.core.db.spider.entity.ProdSku;
import com.project.spider.core.db.spider.repository.ProdProductRepository;
import com.project.spider.core.db.spider.repository.ProdSkuRepository;
import com.project.spider.core.db.spider.repository.SpiderProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class FixSkuErrorTests {
	@Autowired
	private SpiderProductRepository spiderProductRepository;
	@Autowired
	private ProdProductRepository prodProductRepository;
	@Autowired
	private ProdSkuRepository prodSkuRepository;

	// 2020.1.7 修复 2020.1.6 起错误的数据，新上架的商品没有被设置 SKU。
	// !!! 数据已经插入成功了。通过实现的接口 https://localhost:8080/spider/product/prod/1RB5VoAvHCnHV2KLlsCpmRahoWhAfsT2
	// 也可以取到，但是线上的实现取不到，需要反根据原来的实现去改清洗。虽然解决了主键碰撞的问题，但是原来的 SKU 索引不到了。
	// 为什么爬虫的代码查询接口是可以用的，因为是用主键做 UUID 一对多的，而原来的代码是不对主键，多了一个 UUID 字段做 UUID。所以会获取不到。
	@Test
	void testForFixSku() {
		List<ProdProduct> prodProducts = prodProductRepository.findAllByCreatedAtAfter(new Date(new Date().getTime() - 24 * 60 * 60 * 1000));
		for (ProdProduct prodProductOne : prodProducts) {
			if (prodProductOne.getUuid().contentEquals(prodProductOne.getNo())) {
//				System.out.println(prodProductOne.getUuid() + " same no, continue.");
				continue;
			}

//			if (!prodProductOne.getUuid().contentEquals("1RB5VoAvHCnHV2KLlsCpmRahoWhAfsT2")) {
//				prodProductOne.setUuid(prodProductOne.getNo());
//				prodProductOne = prodProductRepository.save(prodProductOne);
//				System.out.println(prodProductOne.getUuid());
//				continue;
//			}

			System.out.println("uuid: " + prodProductOne.getUuid());
			System.out.println("no: " + prodProductOne.getNo());

			System.out.println(prodProductOne.getUuid());
			System.out.println(prodProductOne.getProdProductSkuList().size());

			List<ProdSku> prodSkuList = prodSkuRepository.findAllByProductUuid(prodProductOne.getNo());
			for (ProdSku prodSku : prodSkuList) {
				System.out.println("\tprodSku uuid: " + prodSku.getUuid() + ", productUuid: " + prodSku.getProductUuid());
				prodSku.setProductUuid(prodProductOne.getUuid());
				prodSkuRepository.save(prodSku);
			}

			// 相撞索引冲突
//			prodProductOne.setUuid(prodProductOne.getNo());
//			prodProductOne = prodProductRepository.save(prodProductOne);
//			System.out.println(prodProductOne.getUuid());
		}
	}
}
