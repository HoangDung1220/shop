package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.model.UserModel;

public interface IUserService {
	public UserModel findUserByAccount(String username,String password,int status);

}
