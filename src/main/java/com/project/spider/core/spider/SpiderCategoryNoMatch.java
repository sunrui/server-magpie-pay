package com.project.spider.core.spider;

import com.project.spider.common.exception.SpiderException;

/**
 * 主库的类目非常不好匹配，每个站都不一样，而且代码写死也不灵活。
 * 现将需求改成在入库的时候由运营人员指定要入库的类目。
 *
 * 下面的代码会被忽略保留。
 */
public class SpiderCategoryNoMatch {
	public static String getNewCategoryNo(SpiderRefer spiderRefer, String categoryNo) {
		switch (spiderRefer) {
			case DEALY: {
				throw new SpiderException("目前没有处理 dealy 的进程，最新需求[2021.1.5]不爬了。");
			}
			case JOLLY_CHIC: {
				/**
				 * SAR JOLLYCHIC 对应的 categoryNo
				 * 415 女装 Women's Clothing
				 * 395 鞋 Shoes
				 *
				 * SAR—AED 对应的 categoryNo
				 * 01 女装 Women's Clothing
				 * 04 鞋 Shoes
				 *
				 * @Note 爬全站太慢了，根据运营需求只要两个类目的着急上线，过滤掉其它类目。
				 */
				switch (categoryNo) {
					case "352": // 男装
					case "415": // 女装
						return "01";
					case "395":
						return "04";
				}

				break;
			}
			case FOR_DEAL: {
				break;
			}
		}

		return "0";
	}
}
