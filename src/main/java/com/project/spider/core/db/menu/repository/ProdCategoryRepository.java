package com.project.spider.core.db.menu.repository;

import com.project.spider.core.db.menu.entity.ProdCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdCategoryRepository extends JpaRepository<ProdCategory, Integer> {
	List<ProdCategory> findAllByParentUuid(String parentUuid);
}
