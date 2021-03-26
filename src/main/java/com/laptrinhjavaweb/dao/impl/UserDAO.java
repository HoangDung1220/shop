package com.laptrinhjavaweb.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.dao.IUserDao;
import com.laptrinhjavaweb.mapper.UserMapper;
import com.laptrinhjavaweb.model.UserModel;

public class UserDAO extends AbstractDAO<UserModel> implements IUserDao {

	public UserModel findUserByAccount(String username, String password, int status) {
		List<UserModel> list = new ArrayList<UserModel>();
		String st ="select *from user inner join role on user.idrole=role.idrole  where username =? and password =? and status=?";
		list = query(st,new UserMapper(),username,password,status);
		return list.get(0);
	}

}
