package com.laptrinhjavaweb.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.laptrinhjavaweb.dao.ICategoryDAO;
import com.laptrinhjavaweb.dao.impl.CategoryDAO;
import com.laptrinhjavaweb.model.CategoryModel;
import com.laptrinhjavaweb.service.ICategoryService;

public class CategoryService implements ICategoryService{
	
	@Inject
	private ICategoryDAO categoryDao;
	
	
	
		
	public List<CategoryModel> findAll() {
		return categoryDao.findAll();
	}




	public CategoryModel findOneByCode(String code) {
		return categoryDao.findOneByCode(code);
	}




	public Long save(CategoryModel o) {
		// TODO Auto-generated method stub
		return categoryDao.save(o);
	}

}
