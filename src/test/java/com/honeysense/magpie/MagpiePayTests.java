package com.honeysense.magpie;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;

@Log4j2
@SpringBootTest
public class MagpiePayTests {
//	@Autowired


	@ParameterizedTest
	@CsvSource({
			"Hello world"
	})
	void testForWoAiFanYi(String source) {
	}
}
