package com.project.spider.prod;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
public class ProductScoreTests {
    @Test
    void contextLoads() {
    }

    @Test
    void testTodayScore() {
        try {
            Date newYearDate = new SimpleDateFormat("yyyy-MM-dd").parse("2021-01-01");
            long diffDays = (new Date().getTime() - newYearDate.getTime()) / (24 * 60 * 60 * 1000L);
            long score = 11000 + diffDays;
            System.out.println(score);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
