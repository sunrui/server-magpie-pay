//package com.project.spider.core.db.menu.dealy.service.dealy.impl;
//
//import com.project.spider.core.db.menu.dealy.entity.DealySubCategory;
//import com.project.spider.core.db.menu.dealy.repository.DealySubCategoryRepository;
//import com.project.spider.core.db.menu.dealy.service.dealy.DealySubCategoryService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class DealySubCategoryServiceImpl implements DealySubCategoryService {
//    @Autowired
//    private DealySubCategoryRepository dealySubCategoryRepository;
//
//    @Override
//    public boolean insert(DealySubCategory dealySubCategory) {
//        if (dealySubCategory == null) {
//            return false;
//        }
//
//        dealySubCategoryRepository.save(dealySubCategory);
//        return true;
//    }
//
//    @Override
//    public DealySubCategory findById(Integer id) {
//        if (id == null) {
//            return null;
//        }
//
//        Optional<DealySubCategory> dealySubCategory = dealySubCategoryRepository.findById(id);
//        return dealySubCategory.orElse(null);
//    }
//
//    @Override
//    public boolean deleteById(Integer id) {
//        if (id == null) {
//            return false;
//        }
//
//        Optional<DealySubCategory> dealySubCategory = dealySubCategoryRepository.findById(id);
//        if (!dealySubCategory.isPresent()) {
//            return false;
//        }
//
//        dealySubCategoryRepository.deleteById(id);
//        return true;
//    }
//}
