package com.laptrinhjavaweb.model;

import java.sql.Timestamp;

public class UserModel extends AbstractModel<UserModel>{
	private String userName;
	private String fullName;
	private String password;
	private int status;
	private Long roleid;
	private RoleModel roleModel;
	
	public UserModel() {
		super();
	}

	public UserModel(Long id, Timestamp createdDate, Timestamp modifiedDate, String createdBy, String modifiedBy,
			String userName, String fullName, String password, int status, Long roled) {
		super(id, createdDate, modifiedDate, createdBy, modifiedBy);
		this.userName = userName;
		this.fullName = fullName;
		this.password = password;
		this.status = status;
		this.roleid = roled;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Long getRoleid() {
		return roleid;
	}

	public void setRoleid(Long roled) {
		this.roleid = roled;
	}

	public RoleModel getRoleModel() {
		return roleModel;
	}

	public void setRoleModel(RoleModel roleModel) {
		this.roleModel = roleModel;
	}
	
	
	
	

}
