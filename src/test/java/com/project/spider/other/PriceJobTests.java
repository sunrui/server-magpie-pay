package com.project.spider.other;

import com.project.spider.core.job.price.DealyPriceJob;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Log4j2
@SpringBootTest
public class PriceJobTests {
	@Autowired
	private DealyPriceJob dealyPriceJob;

	@Test
	public void testForFixPrice() {
		dealyPriceJob.fixPriceJob();
	}
}
