package com.laptrinhjavaweb.model;

import java.sql.Timestamp;

public class CategoryModel extends AbstractModel<CategoryModel>{
	private String code;
	private String name;
	
	
	public CategoryModel() {
	}
	public CategoryModel(Long id, Timestamp createdDate, Timestamp modifiedDate, String createdBy, String modifiedBy,
			String code, String name) {
		super(id, createdDate, modifiedDate, createdBy, modifiedBy);
		this.code = code;
		this.name = name;
	}
	public CategoryModel(Long id, Timestamp createdDate, Timestamp modifiedDate, String createdBy, String modifiedBy) {
		super(id, createdDate, modifiedDate, createdBy, modifiedBy);
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
