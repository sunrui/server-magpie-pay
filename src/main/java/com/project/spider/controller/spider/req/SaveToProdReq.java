package com.project.spider.controller.spider.req;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * 入库请求对象
 */
@Getter
@Setter
public class SaveToProdReq {
	/**
	 * 在上架时，指定入库的类目
	 */
	@NotBlank
	private String categoryNo;
}
