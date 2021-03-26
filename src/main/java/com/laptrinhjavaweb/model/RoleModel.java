package com.laptrinhjavaweb.model;

public class RoleModel {
	private int id;
	private String code;
	private String name;
	
	public RoleModel() {
		super();
	}

	public RoleModel(int id, String code, String name) {
		super();
		this.id = id;
		this.code = code;
		this.setName(name);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
