package com.laptrinhjavaweb.dao;


import com.laptrinhjavaweb.model.UserModel;

public interface IUserDao {
	
	public UserModel findUserByAccount(String username,String password,int status );
}
