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
//public class DealyCategory {
//    @Id
//    private Integer id;
//    private String name;
//
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "dealyCategory")
//    private List<DealySubCategory> dealySubCategoryList;
//}
