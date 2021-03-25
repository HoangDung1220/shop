package com.laptrinhjavaweb.dao;

import java.util.List;

import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.paging.Pageble;

public interface INewDao {

	public List<NewModel> findAll(Pageble pageble);
	public Long save(NewModel o);
	public NewModel findOne(Long id);
	public void update(NewModel o);
	public void delete(long id);
	public int totalItems();

}
