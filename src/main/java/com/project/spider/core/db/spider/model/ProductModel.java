package com.project.spider.core.db.spider.model;

import com.project.spider.core.spider.SpiderRefer;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
public class ProductModel {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id; // 主键
    @NotBlank
    @Column(unique = true)
    private String uuid; // 唯一标识
    private String no; // 商品编号（标准规范格式）
    /**
     * dealy goodsIdStr
     */
    private String customNo; // 商品编号（自定义）
    private String categoryNo; // 类别编号
    private BigDecimal originalPrice; // 零售原价
    private BigDecimal retailPrice; // 零售现价
    private BigDecimal shippingPrice; // 运费
    private String currency; // 零售价币种
    private String name; // 商品名称
    private String keywords; // 关键字，逗号分隔
    private Integer status; // 状态
    private String supplierUuid; // 供应商uuid
    private String retailerUuid; // 零售商uuid
    private String storeUuid; // 店铺uuid
    private String mainPhoto; // 主图地址
    private Date createdAt; // 创建时间
    private Date updatedAt; // 更新时间
    private Date publishAt; // 发布时间
    private Integer isDeleted; // 是否软删除
    private Date deletedAt; // 删除时间
    private String description; // 商品描述
    private Float rating; // 用户评分
    private Double score; // 算法得分
    private Float refundRate; // 退货率
    private Integer shippingMinDays; // 最小运输天数
    private Integer shippingMaxDays; // 最大运输天数
    private Integer autoRefundDays; // 商家未发货时的自动退款所需要等待的天数
    private Integer totalReviews; // 总评论数
    private Integer totalSales; // 总销量数
    private Integer salesTotal; // 虚拟销量
    private Integer totalRefunds; // 总退款
    private Integer totalViews; // 总浏览数
    private Integer totalCollections; // 总收藏数
    private Integer idx;
    private Integer noUpdatedCount;
    @Column(length = 8192)
    private String photosStr;
    private String shippingArrivalDesc; // 快递预计到达时间描述
    private String wfName;
    private String wfState;
    /**
     * dealy goodsId
     */
    private String defNo;
    private String wfUuid;
    private Float platformIntervene;
    private Integer forbiddenAdjustPrice; // 禁止加价 0-不禁止,1-禁止
    private Integer marketingType; // 营销类型 0-普通 1-网红 2-新手 4-闪购 8-热销

    @Enumerated(EnumType.STRING)
    private SpiderRefer spiderRefer;
}

/*
    Id                   int       `json:"id" xorm:"not null pk autoincr INT(11)"`
    Uuid                 string    `json:"uuid" xorm:"unique VARCHAR(64)"`
    No                   string    `json:"no" xorm:"comment('商品编号（标准规范格式）') index VARCHAR(64)"`
    CustomNo             string    `json:"custom_no" xorm:"comment('商品编号（自定义）') index VARCHAR(128)"`
    CategoryNo           string    `json:"category_no" xorm:"comment('类别编号') index VARCHAR(8)"`
    OriginalPrice        string    `json:"original_price" xorm:"not null default 0.00 comment('零售原价') DECIMAL(8,2)"`
    RetailPrice          string    `json:"retail_price" xorm:"not null default 0.00 comment('零售现价') index DECIMAL(8,2)"`
    ShippingPrice        string    `json:"shipping_price" xorm:"not null default 0.00 comment('运费') DECIMAL(8,2)"`
    Currency             string    `json:"currency" xorm:"comment('零售价币种') VARCHAR(4)"`
    Name                 string    `json:"name" xorm:"not null comment('商品名称') index(idx_fulltext_name_keywords) VARCHAR(512)"`
    Keywords             string    `json:"keywords" xorm:"comment('关键字，逗号分隔') index(idx_fulltext_name_keywords) VARCHAR(512)"`
    Status               int       `json:"status" xorm:"not null comment('状态') TINYINT(3)"`
    SupplierUuid         string    `json:"supplier_uuid" xorm:"comment('供应商uuid') VARCHAR(48)"`
    RetailerUuid         string    `json:"retailer_uuid" xorm:"comment('零售商uuid') index VARCHAR(48)"`
    StoreUuid            string    `json:"store_uuid" xorm:"comment('店铺uuid') index VARCHAR(64)"`
    MainPhoto            string    `json:"main_photo" xorm:"comment('主图地址') VARCHAR(255)"`
    CreatedAt            time.Time `json:"created_at" xorm:"default 'CURRENT_TIMESTAMP' TIMESTAMP"`
    UpdatedAt            time.Time `json:"updated_at" xorm:"DATETIME"`
    PublishAt            time.Time `json:"publish_at" xorm:"comment('发布日期') DATETIME"`
    IsDeleted            int       `json:"is_deleted" xorm:"not null default 0 TINYINT(3)"`
    DeletedAt            time.Time `json:"deleted_at" xorm:"DATETIME"`
    Description          string    `json:"description" xorm:"comment('商品描述') TEXT"`
    Rating               float32   `json:"rating" xorm:"comment('用户评分') FLOAT"`
    Score                float64   `json:"score" xorm:"comment('算法得分') index DOUBLE"`
    RefundRate           float32   `json:"refund_rate" xorm:"comment('退货率') FLOAT"`
    ShippingMinDays      int       `json:"shipping_min_days" xorm:"comment('最小运输天数') TINYINT(3)"`
    ShippingMaxDays      int       `json:"shipping_max_days" xorm:"comment('最大运输天数') TINYINT(3)"`
    AutoRefundDays       int       `json:"auto_refund_days" xorm:"comment('商家未发货时的自动退款所需要等待的天数') TINYINT(3)"`
    TotalReviews         int       `json:"total_reviews" xorm:"default 0 comment('总评论数') INT(11)"`
    TotalSales           int       `json:"total_sales" xorm:"not null default 0 comment('总销量数') INT(11)"`
    SalesTotal           int       `json:"sales_total" xorm:"not null default 0 comment('虚拟销量') INT(11)"`
    TotalRefunds         int       `json:"total_refunds" xorm:"default 0 INT(11)"`
    TotalViews           int       `json:"total_views" xorm:"default 0 comment('总浏览数') INT(11)"`
    TotalShares          int       `json:"total_shares" xorm:"default 0 comment('总分享数') INT(11)"`
    TotalCollections     int       `json:"total_collections" xorm:"default 0 comment('总收藏数') INT(11)"`
    Idx                  int       `json:"idx" xorm:"INT(11)"`
    NoUpdatedCount       int       `json:"no_updated_count" xorm:"default 0 TINYINT(3)"`
    PhotosStr            string    `json:"photos_str" xorm:"VARCHAR(8192)"`
    ShippingArrivalDesc  string    `json:"shipping_arrival_desc" xorm:"comment('快递预计到达时间描述') VARCHAR(128)"`
    WfName               string    `json:"wf_name" xorm:"VARCHAR(255)"`
    WfState              string    `json:"wf_state" xorm:"VARCHAR(48)"`
    //WfUuid               string    `json:"wf_uuid" xorm:"VARCHAR(48)"`
    //PlatformIntervene    float32   `json:"platform_intervene" xorm:"FLOAT"`
    DefNo                string    `json:"def_no" xorm:"unique VARCHAR(64)"`
    //ForbiddenAdjustPrice int       `json:"forbidden_adjust_price" xorm:"not null default 0 comment('禁止加价 0-不禁止,1-禁止') TINYINT(3)"`
    MarketingType        int       `json:"marketing_type" xorm:"not null default 0 comment('营销类型 0-普通 1-网红 2-新手 4-闪购 8-热销') INT(11)"`
 */
