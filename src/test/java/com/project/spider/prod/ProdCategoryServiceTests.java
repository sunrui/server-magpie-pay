package com.project.spider.prod;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.spider.core.db.menu.model.ProdCategoryMenu;
import com.project.spider.core.db.menu.service.ProdCategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ProdCategoryServiceTests {
	@Autowired
	private ProdCategoryService prodCategoryService;

	@Test
	void contextLoads() {
	}

	@Test
	void testForMenu() {
		List<ProdCategoryMenu> prodCategoryServiceAllMenu = prodCategoryService.findAllMenu();
		try {
			String json = new ObjectMapper().writeValueAsString(prodCategoryServiceAllMenu);
			System.out.println(json);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
}
