package com.project.spider.core.job.spider.dealy;

import com.project.spider.common.exception.SpiderException;
import com.project.spider.core.db.spider.service.SpiderDealyFlushService;
import com.project.spider.core.db.spider.service.SpiderProductService;
import com.project.spider.core.spider.SpiderMarketingType;
import com.project.spider.core.spider.dealy.DealyFetchProvider;
import com.project.spider.core.spider.dealy.dto.category.CategoryDto;
import com.project.spider.core.spider.dealy.dto.category.CategoryNavMenu;
import com.project.spider.core.spider.dealy.dto.categoryGoodsList.CategoryGoodsBaseInfoDataGoods;
import com.project.spider.core.spider.dealy.dto.categoryGoodsList.CategoryGoodsListDto;
import com.project.spider.core.spider.dealy.dto.categoryInfo.CategoryInfoDto;
import com.project.spider.core.spider.dealy.dto.categoryInfo.CategoryInfoNavMenu;
import com.project.spider.core.spider.dealy.dto.categoryInfo.CategoryInfoNavMenuNumber;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service
public class DealyProductJob {
	@Autowired
	private DealyFetchProvider dealyFetchProvider;
	@Autowired
	private SpiderDealyFlushService spiderDealyFlushService;
	@Autowired
	private SpiderProductService spiderProductService;

	@Scheduled(initialDelay = 5000, fixedDelay = 2 * 60 * 60 * 1000)
	void sync() {
		log.info("DealyProductJob.sync");

		CategoryDto categoryDto = dealyFetchProvider.getCategoryLevelOne();
		if (categoryDto.getCode() != 200) {
			SpiderException.triggerParseFailed();
			return;
		}

		// 一级目录
		for (CategoryNavMenu categoryNavMenu : categoryDto.getData().getNavMenuList()) {
			// 跟进运营需求，爬 jollychic 的 Women's Clothing & Shoes 数据换掉现有的数据。
			// 爬全站太慢了，根据运营需求只要两个类目的着急上线，过滤掉其它类目。
			String[] spiderCategoryNames =
					new String[]{
							"Women's Clothing", // JollyChic 女装
							"Shoes", // JollyChic 鞋
							//                    "رجالي", // 男装
							"ملابس نسائية", // 女装
							"أحذية", // 鞋
							// 2020.1.6
							"أجهزة", // Devices
							"المنزل والمعيشة", // Home and living
					};

			boolean found = false;
			for (String categoryName : spiderCategoryNames) {
				if (categoryName.contentEquals(categoryNavMenu.getShowName())) {
					found = true;
					break;
				}
			}
			if (!found) {
				continue;
			}

			// 二级目录
			CategoryInfoDto categoryInfoDto =
					dealyFetchProvider.getCategoryLevelTwo(categoryNavMenu.getId());
			if (categoryInfoDto.getCode() != 200) {
				SpiderException.triggerParseFailed();
				continue;
			}

			// Dealy 有三级目录，我们目前只有二级目录，所以将二级目录的所有子目录遍历为二级类目。
			List<CategoryInfoNavMenuNumber> categoryInfoNavMenuNumberList = new ArrayList<>();
			for (CategoryInfoNavMenu categoryInfoNavMenu : categoryInfoDto.getData().getNavMenuList()) {
				CategoryInfoNavMenuNumber[] categoryInfoNavMenuNumbers =
						new CategoryInfoNavMenuNumber[]{
								categoryInfoNavMenu.getZero(),
								categoryInfoNavMenu.getOne(),
								categoryInfoNavMenu.getTwo(),
								categoryInfoNavMenu.getThree(),
								categoryInfoNavMenu.getFour(),
								categoryInfoNavMenu.getFive(),
								categoryInfoNavMenu.getSix(),
								categoryInfoNavMenu.getEight(),
								categoryInfoNavMenu.getNight(),
								categoryInfoNavMenu.getTeen()
						};

				for (CategoryInfoNavMenuNumber categoryInfoNavMenuNumber : categoryInfoNavMenuNumbers) {
					if (categoryInfoNavMenuNumber != null) {
						categoryInfoNavMenuNumberList.add(categoryInfoNavMenuNumber);
					}
				}
			}

			for (CategoryInfoNavMenuNumber categoryInfoNavMenuNumber : categoryInfoNavMenuNumberList) {
//				if (categoryInfoNavMenuNumber.getContentCode().contentEquals("6551")) {
//					int i = 0;
//				} else {
//					log.info("content code is " + categoryInfoNavMenuNumber.getContentCode() + ", not 6551, continue.");
//					continue;
//				}

				for (int page = 1; ; page++) {
//					String[] keywords = categoryInfoNavMenuNumber.getUrl().split("-");
//					List<String> validKeywords = new ArrayList<>();
//					for (String keyword : keywords) {
//						if (!keyword.contains("?goBack=1")) {
//							validKeywords.add(keyword);
//						}
//					}
//
//					StringBuilder keyword = new StringBuilder();
//					for (String keywordOne : validKeywords) {
//						keyword.append(keywordOne).append("+");
//					}
//
//					if (StringUtils.hasText(keyword)) {
//						keyword.substring(0, keyword.length() - 1);
//					}
					String keyword = categoryInfoNavMenuNumber.getTargetName(); //.replace(" ", "+");
					String contentCode = categoryInfoNavMenuNumber.getContentCode();
					String targetName = categoryInfoNavMenuNumber.getTargetName();


					CategoryGoodsListDto categoryGoodsListDto =
							dealyFetchProvider.getCategoryLevelThree(
									page, categoryInfoNavMenuNumber.getContentCode(), keyword);
					if (categoryGoodsListDto.getCode() != 200) {
						break;
					}

					if (categoryGoodsListDto.getData() == null
							|| categoryGoodsListDto.getData().getBASE_INFO() == null
							|| categoryGoodsListDto.getData().getBASE_INFO().getData() == null
							|| categoryGoodsListDto.getData().getBASE_INFO().getData().getGoodsList() == null) {
						continue;
					}

					List<CategoryGoodsBaseInfoDataGoods> categoryGoodsBaseInfoDataGoodsList =
							categoryGoodsListDto.getData().getBASE_INFO().getData().getGoodsList();

					for (CategoryGoodsBaseInfoDataGoods categoryGoodsBaseInfoDataGoods :
							categoryGoodsBaseInfoDataGoodsList) {
//						if (!categoryGoodsBaseInfoDataGoods.getGoodsId().equals(5224110)) {
//							log.info("goods info is not 51124110, is " + categoryGoodsBaseInfoDataGoods.getGoodsId() + " continue.");
//							continue;
//						}

						log.warn("\tinsertByDealyGoodsId: " + categoryGoodsBaseInfoDataGoods.getGoodsId());
						spiderDealyFlushService.insertByDealyGoodsId(categoryNavMenu.getShowName(), SpiderMarketingType.NORMAL.getCode(), categoryGoodsBaseInfoDataGoods.getGoodsId());
					}

					int rowsCount = categoryGoodsListDto.getData().getBASE_INFO().getData().getPageInfo().getRowsCount();
					int pageCount = categoryGoodsListDto.getData().getBASE_INFO().getData().getPageInfo().getPageCount();
					int isLastPage = categoryGoodsListDto.getData().getBASE_INFO().getData().getIsLastPage();

					String stringBuilder = "\n\n" +
							"loop page: " + page + ", " + "page: " + categoryGoodsListDto.getData().getPage() + ", pageSize: " + categoryGoodsListDto.getData().getPageSize() + "\n" +
							"keyword: " + keyword + ", " + "contentCode: " + contentCode + ", " + "targetName: " + targetName + "\n" +
							"rowsCount: " + rowsCount + ", " + "pageCount: " + pageCount + ", " + "isLastPage: " + isLastPage + "\n";
					log.info(stringBuilder);

					/**
					 * 爬虫到最后一页停止
					 */
					if (isLastPage != 0 || pageCount == 0) {
						break;
					}
				}
			}
		}
	}
}
