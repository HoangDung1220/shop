package com.laptrinhjavaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhjavaweb.model.NewModel;

public class NewMapper implements RowMapper<NewModel> {

	public NewModel mapRow(ResultSet rs) {
		NewModel o = new NewModel();
		try {
			o.setCategoryId(rs.getLong("categoryid"));
			o.setContent(rs.getString("content"));
			o.setCreatedBy(rs.getString("createdby"));
			o.setCreatedDate(rs.getTimestamp("createddate"));
			o.setTiltle(rs.getString("tiltle"));
			o.setShortDescription(rs.getString("shortdescription"));
			o.setThumbnail(rs.getString("thumbnail"));
			o.setId(rs.getLong("id"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return o;
	}

}
