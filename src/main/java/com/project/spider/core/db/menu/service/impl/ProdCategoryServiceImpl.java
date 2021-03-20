package com.project.spider.core.db.menu.service.impl;

import com.project.spider.core.db.menu.entity.ProdCategory;
import com.project.spider.core.db.menu.model.ProdCategoryMenu;
import com.project.spider.core.db.menu.model.ProdSubCategoryMenu;
import com.project.spider.core.db.menu.repository.ProdCategoryRepository;
import com.project.spider.core.db.menu.service.ProdCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdCategoryServiceImpl implements ProdCategoryService {
	@Autowired
	private ProdCategoryRepository prodCategoryRepository;

	@Override
	public List<ProdCategoryMenu> findAllMenu() {
		List<ProdCategory> prodCategoryList = prodCategoryRepository.findAllByParentUuid(""); // 数据库使用的是 empty 不是 null
		List<ProdCategoryMenu> prodCategoryMenuList = new ArrayList<>();
		for (ProdCategory prodCategory : prodCategoryList) {
			// 类目有软删除
			if (prodCategory.getIsDeleted() != null && prodCategory.getIsDeleted() != 0) {
				continue;
			}

			ProdCategoryMenu prodCategoryMenu = new ProdCategoryMenu();
			prodCategoryMenu.setCategoryNo(prodCategory.getNo());
			prodCategoryMenu.setName(prodCategory.getName());
			prodCategoryMenu.setNameZh(prodCategory.getNameZh());

			List<ProdCategory> subProdCategoryList = prodCategoryRepository.findAllByParentUuid(prodCategory.getUuid());
			List<ProdSubCategoryMenu> prodSubCategoryMenuList = new ArrayList<>();
			for (ProdCategory subProdCategory : subProdCategoryList) {
				if (subProdCategory.getIsDeleted() != null && subProdCategory.getIsDeleted() != 0) {
					continue;
				}

				ProdSubCategoryMenu prodSubCategoryMenu = new ProdSubCategoryMenu();
				prodSubCategoryMenu.setName(subProdCategory.getName());
				prodSubCategoryMenu.setNameZh(subProdCategory.getNameZh());
				prodSubCategoryMenu.setCategoryNo(subProdCategory.getNo());
				prodSubCategoryMenuList.add(prodSubCategoryMenu);
			}

			prodCategoryMenu.setMenuList(prodSubCategoryMenuList);
			prodCategoryMenuList.add(prodCategoryMenu);
		}

		return prodCategoryMenuList;
	}
}
