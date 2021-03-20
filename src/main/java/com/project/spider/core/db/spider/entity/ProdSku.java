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
public class ProdSku extends ProductSkuModel {
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "prodProduct")
    private ProdProduct prodProduct;
}
