package com.laptrinhjavaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhjavaweb.model.RoleModel;
import com.laptrinhjavaweb.model.UserModel;

public class UserMapper implements RowMapper<UserModel>{

	public UserModel mapRow(ResultSet rs) {
		UserModel user = new UserModel();
		try {
			user.setId(rs.getLong("iduser"));
			user.setFullName(rs.getString("fullname"));
			user.setUserName(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setStatus(rs.getInt("status"));
			user.setRoleid(rs.getLong("idrole"));
			try {
			RoleModel roleModel = new RoleModel();
			roleModel.setName(rs.getString("name"));
			roleModel.setCode(rs.getString("code"));
			
			user.setRoleModel(roleModel);
			} catch (Exception e) {
				
			}
			
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	

}
