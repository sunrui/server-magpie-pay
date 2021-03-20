package com.project.spider.core.db.spider.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.spider.core.db.spider.model.ProductSkuModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class SpiderProductSku extends ProductSkuModel {
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "spiderProduct")
    private SpiderProduct spiderProduct;
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
