package com.laptrinhjavaweb.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.dao.ICategoryDAO;
import com.laptrinhjavaweb.mapper.CategoryMapper;
import com.laptrinhjavaweb.model.CategoryModel;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO{
	
	

	public List<CategoryModel> findAll() {
	   
		String query1 ="SELECT *from category";
	    return query(query1,new CategoryMapper());

	

	}

	public CategoryModel findOneByCode(String code) {
		Connection conn = getConnection();
		PreparedStatement ppst = null;
		ResultSet rs = null;
		String query = "select *from category where code = ?";
		CategoryModel o = new CategoryModel();
		try {
			ppst=conn.prepareStatement(query);
			ppst.setString(1, code);
			rs=ppst.executeQuery();
			while (rs.next()) {
			o.setCreatedBy(rs.getString("createdby"));
	    	o.setCode(rs.getString("code"));
	    	o.setCreatedDate(rs.getTimestamp("createddate"));
	    	o.setId(rs.getLong("id"));
	    	o.setModifiedBy(rs.getString("modifiedby"));
	    	o.setModifiedDate(rs.getTimestamp("modifieddate"));
	    	o.setName(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return o;
	}

	public Long save(CategoryModel o) {
		String querry = "insert into category (code,name) values (?,?)";
		return insert(querry,o.getCode(),o.getName());
	}
	 
}

