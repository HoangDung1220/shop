package com.laptrinhjavaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhjavaweb.model.CategoryModel;

public class CategoryMapper implements RowMapper<CategoryModel> {

	public CategoryModel mapRow(ResultSet rs) {

		CategoryModel o = new CategoryModel();
		
		try {
			o.setCreatedBy(rs.getString("createdby"));
			o.setCode(rs.getString("code"));
	    	o.setCreatedDate(rs.getTimestamp("createddate"));
	    	o.setId(rs.getLong("id"));
	    	o.setModifiedBy(rs.getString("modifiedby"));
	    	o.setModifiedDate(rs.getTimestamp("modifieddate"));
	    	o.setName(rs.getString("name"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
		
		return o;
	}

}
