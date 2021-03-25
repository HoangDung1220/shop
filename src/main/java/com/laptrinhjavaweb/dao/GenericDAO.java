package com.laptrinhjavaweb.dao;

import java.util.List;

import com.laptrinhjavaweb.mapper.RowMapper;

public interface GenericDAO<T> {
	
	public List<T> query(String query,RowMapper<T> rowMapper,Object... paramters);
	public Long insert(String querry,Object... paramters);
	public void update(String querry,Object... paramters);
	public void delete(String querry,Object... paramters);
	public int count(String querry,Object... paramters);
	
	}
