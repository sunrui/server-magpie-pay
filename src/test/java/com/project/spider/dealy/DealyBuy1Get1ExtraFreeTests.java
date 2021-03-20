package com.project.spider.dealy;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.spider.core.spider.dealy.DealyFetchProvider;
import com.project.spider.core.spider.dealy.dto.buy1get1extraFree.Buy1Get1ExtraFreeDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DealyBuy1Get1ExtraFreeTests {
	@Autowired
	private DealyFetchProvider dealyFetchProvider;

	@Test
	void contextLoads() {
	}

	@Test
	void testForFetch() {
		Buy1Get1ExtraFreeDto buyOneGetOneExtraFreeDto = dealyFetchProvider.getBuyOneGetOneExtraFree();
		try {
			String json = new ObjectMapper().writeValueAsString(buyOneGetOneExtraFreeDto);
			System.out.println(json);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
}
