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
public class ProductSkuModel {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id; // 主键
    @NotBlank
    @Column(unique = true)
    private String uuid; // 唯一标识
    private String productNo; // SPU编号
    private String no; // SKU编号（标准规范格式）
    private String customNo; // SKU编号（自定义）
    private String color; // 颜色
    private String size; // 尺码
    private BigDecimal originalPrice; // 零售原价
    private BigDecimal retailPrice; // 零售现价
    private String currency; // 零售价币种
    private Integer quantity; // 库存量
    private String productUuid;
    private Integer status;
    private Date createdAt;
    private Date deletedAt;
    private Integer isDeleted;
    private Date updatedAt;
    private Integer noUpdatedCount;
    private Integer idx;
    private Double weight; // 重量
    private String weightUnit; // 重量单位
    @Column(length = 8192)
    private String photosStr;
    private BigDecimal shippingPrice; // 快递价格
    private String shippingCurrency; // 快递价格币种

    @Enumerated(EnumType.STRING)
    private SpiderRefer spiderRefer;
}

/*
	Id               int       `json:"id" xorm:"not null pk autoincr INT(11)"`
	Uuid             string    `json:"uuid" xorm:"index(idx_uuid_color_size) VARCHAR(64)"`
	ProductNo        string    `json:"product_no" xorm:"not null comment('SPU编号') index VARCHAR(128)"`
	No               string    `json:"no" xorm:"comment('SKU编号（标准规范格式）') VARCHAR(128)"`
	CustomNo         string    `json:"custom_no" xorm:"comment('SKU编号（自定义）') index VARCHAR(64)"`
	Color            string    `json:"color" xorm:"not null comment('颜色') index(idx_uuid_color_size) VARCHAR(64)"`
	Size             string    `json:"size" xorm:"not null comment('尺码') index(idx_uuid_color_size) VARCHAR(64)"`
	OriginalPrice    string    `json:"original_price" xorm:"not null default 0.00 comment('零售原价') DECIMAL(8,2)"`
	RetailPrice      string    `json:"retail_price" xorm:"not null default 0.00 comment('零售现价') DECIMAL(8,2)"`
	Currency         string    `json:"currency" xorm:"comment('零售价币种') VARCHAR(4)"`
	Quantity         int       `json:"quantity" xorm:"not null default 0 comment('库存量') MEDIUMINT(6)"`
	ProductUuid      string    `json:"product_uuid" xorm:"not null index VARCHAR(48)"`
	Status           int       `json:"status" xorm:"not null comment('状态') TINYINT(1)"`
	CreatedAt        time.Time `json:"created_at" xorm:"not null default 'CURRENT_TIMESTAMP' TIMESTAMP"`
	DeletedAt        time.Time `json:"deleted_at" xorm:"DATETIME"`
	IsDeleted        int       `json:"is_deleted" xorm:"not null default 0 TINYINT(3)"`
	UpdatedAt        time.Time `json:"updated_at" xorm:"DATETIME"`
	NoUpdatedCount   int       `json:"no_updated_count" xorm:"default 0 TINYINT(3)"`
	Idx              int       `json:"idx" xorm:"INT(11)"`
	Weight           float32   `json:"weight" xorm:"comment('重量') FLOAT"`
	WeightUnit       string    `json:"weight_unit" xorm:"comment('重量单位') VARCHAR(8)"`
	PhotosStr        string    `json:"photos_str" xorm:"VARCHAR(8192)"`
	ShippingPrice    string    `json:"shipping_price" xorm:"not null default 0.00 comment('快递价格') DECIMAL(6,2)"`
	ShippingCurrency string    `json:"shipping_currency" xorm:"comment('快递价格币种') VARCHAR(4)"`
 */
