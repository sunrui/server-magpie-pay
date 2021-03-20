package com.project.spider.fordeal;

import com.project.spider.core.spider.fordeal.web.phantomjs.ForDealWebProvider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ForDealWebProviderTests {
	@Autowired
	private ForDealWebProvider forDealWebProvider;

	@Test
	public void testForDetail() {
		forDealWebProvider.fetchDetail();
	}
}
