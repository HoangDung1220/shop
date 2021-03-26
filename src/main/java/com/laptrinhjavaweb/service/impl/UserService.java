package com.laptrinhjavaweb.service.impl;

import javax.inject.Inject;

import com.laptrinhjavaweb.dao.IUserDao;
import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.service.IUserService;

public class UserService implements IUserService{

	@Inject
	IUserDao userDao;
	
	public UserModel findUserByAccount(String username, String password, int status) {
		return userDao.findUserByAccount(username, password, status);
	}

}
