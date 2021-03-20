package com.project.spider.core.spider.fordeal.web.jsoup;

import lombok.extern.log4j.Log4j2;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Log4j2
@Service
public class ForDealJSoupFetchProvider {
	private String url = "https://www.fordeal.com/zh-SA/women-c130000036?customer_trace=1.word.4.4.130000036..5of3bTnrrTpeWf.mod_CategoryNav-scene_jump-idx_2-page_itemDetail.2";

	/**
	 * 这个框架放弃了，不能把非 SSR 的内容解析出来。
	 * @param url
	 * @throws IOException
	 */
	public void fetchJsoup(String url) throws IOException {
		Document doc = Jsoup.connect(url).get();
		log.info(doc.title());
		log.info(doc.body().toString());
		Elements newsHeadlines = doc.select("#mp-itn b a");

		for (Element headline : newsHeadlines) {
			log.info("%s\n\t%s", headline.attr("title"), headline.absUrl("href"));
		}
	}

	public static void main(String[] args) {
		ForDealJSoupFetchProvider forDealWebFetchProvider = new ForDealJSoupFetchProvider();
		try {
			forDealWebFetchProvider.fetchJsoup(forDealWebFetchProvider.url);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
