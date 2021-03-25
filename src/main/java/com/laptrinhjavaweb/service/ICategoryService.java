package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.model.CategoryModel;

public interface ICategoryService {

	public List<CategoryModel> findAll();
	public CategoryModel findOneByCode(String code);
	public Long save(CategoryModel o);
}
