//package com.project.spider.core.db.menu.dealy.entity;
//
//import lombok.Getter;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//@Getter
//@Setter
//public class DealyFlashSale {
//    @Id
//    private Integer id; // 等同 tableTime
//    private Integer tableTime;
//    private Integer groupId;
//    private Integer goodsCount;
//
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "dealyFlashSale")
//    private List<DealyFlashSaleGoods> flashSaleGoodsList;
//}
