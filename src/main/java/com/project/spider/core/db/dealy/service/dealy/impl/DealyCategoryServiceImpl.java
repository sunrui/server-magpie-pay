//package com.project.spider.core.db.menu.dealy.service.dealy.impl;
//
//import com.project.spider.core.db.menu.dealy.entity.DealyCategory;
//import com.project.spider.core.db.menu.dealy.repository.DealyCategoryRepository;
//import com.project.spider.core.db.menu.dealy.service.dealy.DealyCategoryService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class DealyCategoryServiceImpl implements DealyCategoryService {
//    @Autowired
//    private DealyCategoryRepository dealyCategoryRepository;
//
//    @Override
//    public boolean insert(DealyCategory dealyCategory) {
//        if (dealyCategory == null) {
//            return false;
//        }
//
//        dealyCategoryRepository.save(dealyCategory);
//        return true;
//    }
//
//    @Override
//    public DealyCategory findById(Integer id) {
//        if (id == null) {
//            return null;
//        }
//
//        Optional<DealyCategory> dealyCategory = dealyCategoryRepository.findById(id);
//        return dealyCategory.orElse(null);
//    }
//
//    @Override
//    public boolean deleteById(Integer id) {
//        if (id == null) {
//            return false;
//        }
//
//        Optional<DealyCategory> dealyCategory = dealyCategoryRepository.findById(id);
//        if (!dealyCategory.isPresent()) {
//            return false;
//        }
//
//        dealyCategoryRepository.deleteById(id);
//        return true;
//    }
//}
