package com.project.spider.core.spider.dealy.dto.goodsInfo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GoodsInfoDetailExtInfo {
    private String faqLink;
    private Integer goodsType;
    private String imgTextLink;
    private Integer isAd;
    private Integer isComment;
    private Integer isIncludeTax;
    private Integer isLike;
    private Integer isSizeGuide;
    private Integer salesCount;
    private Integer shopId;
    private String sizeGuideLink;
}

/*
{
    "faqLink": "http://h5app.dealy1688.com/helpCenter20170104.html?whichPage=goodsDetailFAQ&lang=0&countryCode=SA&appVersion=10&frm=11&appTypeId=7&isInDetail=1",
    "goodsType": 0,
    "imgTextLink": "http://h5app.dealy1688.com/goodsDetailDes20170531.html?loading=1&goodsId=1259336&frm=11&appVersion=10&lang=0&currency=SAR&appTypeId=7&cookieId=EF0E411D-B200-8FAB-D8B3-87B43328048B&countryCode=SA&isInDetail=1",
    "isAd": 0,
    "isComment": 1,
    "isIncludeTax": 1,
    "isLike": 0,
    "isSizeGuide": 1,
    "salesCount": 33,
    "shopId": 0,
    "sizeGuideLink": "http://h5app.dealy1688.com/sizeGuide20180620.html?goodsId=1259336&catId=5486&appVersion=10&lang=0&frm=11&countryCode=SA&appTypeId=7&cookieId=EF0E411D-B200-8FAB-D8B3-87B43328048B&isInDetail=1"
}
 */
