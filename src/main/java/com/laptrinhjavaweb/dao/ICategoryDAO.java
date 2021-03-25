package com.laptrinhjavaweb.dao;

import java.util.List;

import com.laptrinhjavaweb.model.CategoryModel;

public interface ICategoryDAO {

	public List<CategoryModel> findAll();
	public CategoryModel findOneByCode(String code);
	public Long save(CategoryModel o);
}
