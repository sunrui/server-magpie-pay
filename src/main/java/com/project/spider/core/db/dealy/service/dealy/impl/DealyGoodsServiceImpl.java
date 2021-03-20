//package com.project.spider.core.db.menu.dealy.service.dealy.impl;
//
//import com.project.spider.core.db.menu.dealy.entity.DealyGoods;
//import com.project.spider.core.db.menu.dealy.repository.DealyGoodsRepository;
//import com.project.spider.core.db.menu.dealy.service.dealy.DealyGoodsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class DealyGoodsServiceImpl implements DealyGoodsService {
//    @Autowired
//    private DealyGoodsRepository dealyGoodsRepository;
//
//    @Override
//    public boolean insert(DealyGoods dealyGoods) {
//        if (dealyGoods == null) {
//            return false;
//        }
//
//        dealyGoodsRepository.save(dealyGoods);
//        return true;
//    }
//
//    @Override
//    public DealyGoods findById(Integer id) {
//        if (id == null) {
//            return null;
//        }
//
//        Optional<DealyGoods> dealyGoods = dealyGoodsRepository.findById(id);
//        return dealyGoods.orElse(null);
//    }
//
//    @Override
//    public boolean deleteById(Integer id) {
//        if (id == null) {
//            return false;
//        }
//
//        Optional<DealyGoods> dealyGoods = dealyGoodsRepository.findById(id);
//        if (!dealyGoods.isPresent()) {
//            return false;
//        }
//
//        dealyGoodsRepository.deleteById(id);
//        return true;
//    }
//}
