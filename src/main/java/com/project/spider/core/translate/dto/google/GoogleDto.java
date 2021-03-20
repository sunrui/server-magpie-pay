package com.project.spider.core.translate.dto.google;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GoogleDto {
	private List<GoogleSentence> sentences;
	private String src;
	private Float confidence;
	private Object spell;
	private Object ldResult;
}

/*
{
	"sentences": [{
		"trans": "Women\u0027s shoes",
		"orig": "女鞋",
		"backend": 3,
		"model_specification": [{}],
		"translation_engine_debug_info": [{
			"model_tracking": {
				"checkpoint_md5": "51171d70a5b6c2485a24361038890141",
				"launch_doc": "zh_en_2020q2.md"
			}
		}]
	}],
	"src": "zh-CN",
	"confidence": 1.0,
	"spell": {},
	"ld_result": {
		"srclangs": ["zh-CN"],
		"srclangs_confidences": [1.0],
		"extended_srclangs": ["zh-CN"]
	}
}
 */
