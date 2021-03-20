package com.project.spider.core.translate;

import com.project.spider.core.translate.dto.google.GoogleDto;
import com.project.spider.core.translate.dto.woAiFanYi.WoAiFanYiDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.yaml.snakeyaml.util.UriEncoder;

import java.util.Date;
import java.util.List;

@Log4j2
@Service
public class TranslateProvider {
	@Autowired
	private RestTemplate restTemplate;

	// http://api.microsofttranslator.com/v2/Http.svc/Translate?appId=A4D660A48A6A97CCA791C34935E4C02BBB1BEC1C&from=&to=en&text=考勤计算
	//  限制频率会返回 400 状态码
	public String bing(String source, TranslateLang translateLang) {
		String url = "http://api.microsofttranslator.com/v2/Http.svc/Translate?appId=A4D660A48A6A97CCA791C34935E4C02BBB1BEC1C&from=&to=en&text=" + source;

		try {
			String result = restTemplate.getForObject(url, String.class);
			if (!StringUtils.hasText(result)) {
				return null;
			}

			String prefix = "<string xmlns=\"http://schemas.microsoft.com/2003/10/Serialization/\">";
			if (!result.startsWith(prefix)) {
				return null;
			}

			String suffix = "</string>";
			int indexOfSuffix = result.indexOf(suffix);
			if (indexOfSuffix == -1) {
				return null;
			}

			source = result.substring(prefix.length(), indexOfSuffix);
			return source;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	//	http://translate.google.cn/translate_a/single?client=gtx&dt=t&dj=1&ie=UTF-8&sl=auto&tl=zh_TW&q=calculate
	//  限制频率会返回 429 状态码
	public String google(String source, TranslateLang translateLang) {
		String url = "http://translate.google.cn/translate_a/single?client=gtx&dt=t&dj=1&ie=UTF-8&sl=auto&tl=en&q=" + source;

		try {
			GoogleDto googleDto = restTemplate.getForObject(url, GoogleDto.class);
			if (googleDto != null && googleDto.getSentences().size() > 0) {
				return googleDto.getSentences().get(0).getTrans();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// NOTE 调用过于频繁被 IP 封了，不适合全局替换所有商品名
	// 翻译成阿拉伯 http://www.wz5.com/fanyi/alby/
	public String woAiFanYi(String source, TranslateLang translateLang) {
		String url = "https://www.woaifanyi.com/api/1.9/save/?ajaxtimestamp=" + new Date().getTime();

		HttpHeaders headers = new HttpHeaders();
		MediaType type = MediaType.parseMediaType("application/x-www-form-urlencoded");
		headers.setContentType(type);

		String body = String.format("source=%s&from=1&to=4", UriEncoder.encode(source));
		HttpEntity<String> entity = new HttpEntity<>(body, headers);

		try {
			ResponseEntity<List<WoAiFanYiDto>> result = restTemplate.exchange(url, HttpMethod.POST, entity, new ParameterizedTypeReference<List<WoAiFanYiDto>>() {
			});
			if (result.getBody() != null) {
				for (WoAiFanYiDto woAiFanYiDto : result.getBody()) {
					log.info("\tx_s_w_z: " + woAiFanYiDto.getX_s_w_z());
					log.info("\tn_r: " + woAiFanYiDto.getN_r());
				}

				for (WoAiFanYiDto woAiFanYiDto : result.getBody()) {
					return woAiFanYiDto.getN_r();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
