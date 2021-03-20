//package com.project.spider.core.db.menu.dealy.service.dealy.impl;
//
//import com.project.spider.core.db.menu.dealy.entity.DealyFlashSale;
//import com.project.spider.core.db.menu.dealy.repository.DealyFlashSaleRepository;
//import com.project.spider.core.db.menu.dealy.service.dealy.DealyFlashSaleService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class DealyFlashSaleServiceImpl implements DealyFlashSaleService {
//    @Autowired
//    private DealyFlashSaleRepository dealyFlashSaleRepository;
//
//    @Override
//    public boolean insert(DealyFlashSale dealyFlashSale) {
//        if (dealyFlashSale == null) {
//            return false;
//        }
//
//        dealyFlashSaleRepository.save(dealyFlashSale);
//        return true;
//    }
//
//    @Override
//    public DealyFlashSale findById(Integer id) {
//        if (id == null) {
//            return null;
//        }
//
//        Optional<DealyFlashSale> dealyFlashSale = dealyFlashSaleRepository.findById(id);
//        return dealyFlashSale.orElse(null);
//    }
//
//    @Override
//    public boolean deleteById(Integer id) {
//        if (id == null) {
//            return false;
//        }
//
//        Optional<DealyFlashSale> dealyFlashSale = dealyFlashSaleRepository.findById(id);
//        if (!dealyFlashSale.isPresent()) {
//            return false;
//        }
//
//        dealyFlashSaleRepository.deleteById(id);
//        return true;
//    }
//}
