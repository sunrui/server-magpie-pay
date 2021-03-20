package com.project.spider.other;

import com.project.spider.common.util.RandomUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RandomNumberTests {
    @Test
    void contextLoads() {
    }

    @Test
    void testForRandom() {
        System.out.println(RandomUtil.generateString(7));
    }
}
