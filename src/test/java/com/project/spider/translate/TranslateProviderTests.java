package com.project.spider.translate;

import com.project.spider.core.translate.TranslateLang;
import com.project.spider.core.translate.TranslateProvider;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Log4j2
@SpringBootTest
public class TranslateProviderTests {
	@Autowired
	private TranslateProvider translateProvider;

	@ParameterizedTest
	@CsvSource({
			"ملابس نسائية", // 来自 prod category 女性着装
			"أجهزة", // Devices
			"المنزل والمعيشة", // Home and living
			"ملابس نسائية", // 女装
			"أحذية", // 鞋
			"女鞋",
			"你好，世界",
			"Hello world"
	})
	void testForWoAiFanYi(String source) {
		String result = translateProvider.woAiFanYi(source, TranslateLang.ENGLISH);
		log.info(result);
	}

	@ParameterizedTest
	@CsvSource({
			"ملابس نسائية", // 来自 prod category 女性着装
			"أجهزة", // Devices
			"المنزل والمعيشة", // Home and living
			"ملابس نسائية", // 女装
			"أحذية", // 鞋
			"女鞋",
			"你好，世界",
			"Hello world"
	})
	void testForGoogle(String source) {
		String result = translateProvider.google(source, TranslateLang.ENGLISH);
		log.info(result);
	}

	@ParameterizedTest
	@CsvSource({
			"ملابس نسائية", // 来自 prod category 女性着装
			"أجهزة", // Devices
			"المنزل والمعيشة", // Home and living
			"ملابس نسائية", // 女装
			"أحذية", // 鞋
			"女鞋",
			"你好，世界",
			"Hello world"
	})
	void testForBing(String source) {
		String result = translateProvider.bing(source, TranslateLang.ENGLISH);
		log.info(result);
	}
}
