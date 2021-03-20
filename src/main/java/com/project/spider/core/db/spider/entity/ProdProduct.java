package com.project.spider.core.db.spider.entity;

import com.project.spider.core.db.spider.model.ProductModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
public class ProdProduct extends ProductModel {
    @OneToMany(mappedBy = "prodProduct", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ProdSku> prodProductSkuList;
}
