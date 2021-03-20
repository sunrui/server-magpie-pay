package com.project.spider.fordeal;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.spider.core.spider.fordeal.fetch.ForDealFetchProvider;
import com.project.spider.core.spider.fordeal.fetch.dto.dwpPandoraCategoryTree.DwpPandoraCategoryTreeDto;
import com.project.spider.core.spider.fordeal.fetch.dto.dwpPandoraSearch.DwpPandoraSearchDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ForDealFetchProviderTests {
	@Autowired
	private ForDealFetchProvider forDealProvider;

	@Test
	void testForGetDwpPandoraCategoryTree() {
		DwpPandoraCategoryTreeDto dwpPandoraCategoryTree = forDealProvider.getDwpPandoraCategoryTree();

		try {
			String json = new ObjectMapper().writeValueAsString(dwpPandoraCategoryTree);
			System.out.println(json);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testForDwpPandoraSearchDto() {
		DwpPandoraSearchDto dwpPandoraSearchDto = forDealProvider.getDwpPandoraSearch();

		try {
			String json = new ObjectMapper().writeValueAsString(dwpPandoraSearchDto);
			System.out.println(json);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
}
