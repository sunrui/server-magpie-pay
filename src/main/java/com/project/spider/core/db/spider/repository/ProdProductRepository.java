package com.project.spider.core.db.spider.repository;

import com.project.spider.core.db.spider.entity.ProdProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ProdProductRepository extends JpaRepository<ProdProduct, Integer> {
    ProdProduct findByUuid(String uuid);
    Page<ProdProduct> findAll(Pageable pageable);
    Page<ProdProduct> findAllByOrderByCreatedAtDesc(Pageable pageable);
    Page<ProdProduct> findAllByCreatedAtAfter(Date date, Pageable pageable);
    List<ProdProduct> findAllByCreatedAtAfter(Date date);
}
