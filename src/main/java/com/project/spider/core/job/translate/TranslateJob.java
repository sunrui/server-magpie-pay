package com.project.spider.core.job.translate;

import com.project.spider.core.db.menu.entity.ProdCategory;
import com.project.spider.core.db.menu.repository.ProdCategoryRepository;
import com.project.spider.core.translate.TranslateLang;
import com.project.spider.core.translate.TranslateProvider;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class TranslateJob {
	@Autowired
	private TranslateProvider translateProvider;
	@Autowired
	private ProdCategoryRepository prodCategoryRepository;

	@Scheduled(initialDelay = 5000, fixedDelay = 5 * 60 * 60 * 1000L)
	void translateProdCategory() {
		log.info("TranslateJob.translateProdCategory");
		for (int page = 0; ; page++) {
			Page<ProdCategory> prodCategories = prodCategoryRepository.findAll(PageRequest.of(page, 10));
			log.info("prodCategories.getTotalElements() = " + prodCategories.getTotalElements());
			if (!prodCategories.hasContent()) {
				break;
			}

			for (ProdCategory prodCategory : prodCategories.getContent()) {
				/**
				 * @NOTE 这两个字段原来是为欧美站设计的，name 即为 en，zh 为中文。
				 * 现在转到中东来了，name 即为阿语，目前 zh 显示的是英文。
				 *
				 * 英文主要用来在港清关时和原产品名对应。
				 */
				String nameZh = translateProvider.bing(prodCategory.getName(), TranslateLang.ENGLISH);
				if (nameZh == null) {
					// 访问太频繁被封了，不管了，下次继续。
					continue;
				}
				prodCategory.setNameZh(nameZh);
				prodCategory = prodCategoryRepository.save(prodCategory);

				try {
					Thread.sleep(5000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				log.info("name: " + prodCategory.getName() + ", nameEn: " + prodCategory.getNameZh());
			}
		}
	}
}
