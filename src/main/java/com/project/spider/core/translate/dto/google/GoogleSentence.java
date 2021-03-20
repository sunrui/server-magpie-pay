package com.project.spider.core.translate.dto.google;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GoogleSentence {
	private String trans;
	private String orig;
	private Integer backend;
	private Object modelSpecification;
	private Object translationEngineDebugInfo;
}

/*
{
	"trans": "Women\u0027s shoes",
	"orig": "女鞋",
	"backend": 3,
	"model_specification": [{}],
	"translation_engine_debug_info": [{
		"model_tracking": {
			"checkpoint_md5": "51171d70a5b6c2485a24361038890141",
			"launch_doc": "zh_en_2020q2.md"
		}
	}
 */
