package com.project.spider.core.job.spider.dealy;

import com.project.spider.controller.dealy.DealyController;
import com.project.spider.controller.dealy.res.DealyGoods;
import com.project.spider.controller.dealy.res.flashSale.FlashSaleVo;
import com.project.spider.core.db.spider.service.SpiderDealyFlushService;
import com.project.spider.core.db.spider.service.SpiderProductService;
import com.project.spider.core.spider.SpiderMarketingType;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class DealyFlashSaleJob {
	@Autowired
	private DealyController dealyController;
	@Autowired
	private SpiderDealyFlushService spiderDealyFlushService;
	@Autowired
	private SpiderProductService spiderProductService;

	//    @Scheduled(initialDelay = 5000, fixedDelay = 30 * 60 * 1000)
	void sync() {
		log.info("DealyFlashSaleJob.sync");

		List<FlashSaleVo> flashSaleVoList = dealyController.getFlashSale();
		for (FlashSaleVo flashSaleVo : flashSaleVoList) {
//            long zero = System.currentTimeMillis() / (1000 * 3600 * 24) * (1000 * 3600 * 24) - TimeZone.getDefault().getRawOffset();
//            // 只取今天的
//            if (flashSaleVo.getTableTime() != zero / 1000) {
//                continue;
//            }

			for (DealyGoods dealyGoods : flashSaleVo.getDealyGoodsList()) {
//                SpiderProduct spiderProduct = spiderProductService.findByDefNo(dealyGoods.getGoodsId());
//                if (spiderProduct != null) {
//                    continue;
//                }

				spiderDealyFlushService.insertByDealyGoodsId("", SpiderMarketingType.FLASH_SALE.getCode(), dealyGoods.getGoodsId());
			}
		}
	}
}
