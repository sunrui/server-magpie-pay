package com.project.spider.core.spider.fordeal.web.phantomjs;

import org.jsoup.select.Elements;
import org.seimicrawler.xpath.JXDocument;
import org.seimicrawler.xpath.JXNode;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.project.spider.core.spider.fordeal.web.phantomjs.JsoupUtil.formatNode;

@Service
public class ForDealWebProvider {
	public void fetchDetail() {
		String url = "https://www.fordeal.com/zh-SA/detail/20135020?customer_trace=1.fc.130000036.2.20135020.1245-1114-946-1256-1342-1058.5of2ZJnrvFK9wq.page_pcFdCategory-mod_PandoraWallItem-sc_raw109-bt_38-sf_230-ctmBizTag_1-pg_1-fb_1-sid_5a0e5b3e5a-scene_jump-idx_1.1";
		Elements ulList = JsoupUtil.getElements(url, 1, 3000, false, "f-container-root");
		JXDocument jxd = new JXDocument(ulList);

		// 商品列表
		List<JXNode> goods = jxd.selN("//*[@id=\"result\"]/li");
		for (JXNode good : goods) {
			System.out.println("---------------------- 分隔 ----------------------");
			// 详情页地址
			String detailUrl = formatNode(good.sel("//li[1]/div/a/@href"));
			System.out.println("详情页地址: " + detailUrl);
			// 售价
			String price = formatNode(good.sel("//li[1]/div/div/p[1]/span[1]/text()"));
			System.out.println("售价: " + price);
			// 会员价
			String memberPrice = formatNode(good.sel("//li[5]/div/div/p[1]/span[2]/text()"));
			System.out.println("会员价: " + memberPrice);
			// 市场价
			String marketprice = formatNode(good.sel("//li[1]/div/div/p[1]/span[2]/del/text()"));
			System.out.println("市场价: " + marketprice);
			// 折扣
			String discountstr = formatNode(good.sel("//li[6]/div/div/p[1]/span[2]/span/text()"));
			System.out.println("折扣: " + discountstr);
			// 商品名称
			String goodsName = formatNode(good.sel("//li[1]/div/div/div/a/h2/text()"));
			System.out.println("商品名称: " + goodsName);
			// 销售信息1
			String saelsinfo1 = formatNode(good.sel("//li[1]/div/div/p[2]/span[1]/text()"));
			System.out.println("销售信息1: " + saelsinfo1);
			// 销售信息2
			String saelsinfo2 = formatNode(good.sel("//li[1]/div/div/p[2]/span[2]/text()"));
			System.out.println("销售信息2: " + saelsinfo2);
			// 销售信息3
			String saelsinfo3 = formatNode(good.sel("//li[1]/div/div/p[2]/span[3]/text()"));
			System.out.println("销售信息3: " + saelsinfo3);
			// 销售信息4
			String saelsinfo4 = formatNode(good.sel("//li[1]/div/div/p[2]/span[4]/text()"));
			System.out.println("销售信息4: " + saelsinfo4);
			// 评论总条目数
			String totalComments = formatNode(good.sel("//li[1]/div/div/p[3]/a/text()"));
			System.out.println("评论总条目数: " + totalComments);
			// 原产地
			String origin = formatNode(good.sel("//li[1]/div/div/p[3]/span/text()"));
			System.out.println("原产地: " + origin);
			// 店铺名称
			String shopName = formatNode(good.sel("//li[1]/div/div/p[4]/span/text()"));
			System.out.println("店铺名称: " + shopName);
		}
	}
}
