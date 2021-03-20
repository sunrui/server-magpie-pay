package com.project.spider.core.spider.dealy.dto.flashSaleMain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FlashSaleMain {
    private Integer goodsId;
    private Integer notBeginTabTime;
    private Integer timeTagCount;
    private String timezone;
    private List<FlashSaleTimeTag> flashSaleTimeTag;
}

/*
{
	"code": 200,
	"data": {
		"notBeginTabTime": 0,
		"adInfo": "",
		"flashSaleTimeTag": [{
			"countdown": 36154,
			"endTime": 1608393600,
			"groupId": 46911,
			"isSelect": 1,
			"isStart": 1,
			"tabTime": 1608307200,
			"showTabTime": "0:00",
			"showStartStatus": "On going"
		}, {
			"countdown": 36154,
			"endTime": 1608480000,
			"groupId": 46913,
			"isSelect": 0,
			"isStart": 0,
			"tabTime": 1608393600,
			"showTabTime": "0:00",
			"showStartStatus": "12/20"
		}, {
			"countdown": 122554,
			"endTime": 1608566400,
			"groupId": 47017,
			"isSelect": 0,
			"isStart": 0,
			"tabTime": 1608480000,
			"showTabTime": "0:00",
			"showStartStatus": "12/21"
		}, {
			"countdown": 208954,
			"endTime": 1608652800,
			"groupId": 47019,
			"isSelect": 0,
			"isStart": 0,
			"tabTime": 1608566400,
			"showTabTime": "0:00",
			"showStartStatus": "12/22"
		}],
		"timeTagCount": 4,
		"timezone": "Asia/Chongqing",
		"goodsId": 0
	},
	"message": "Success!"
}
 */
