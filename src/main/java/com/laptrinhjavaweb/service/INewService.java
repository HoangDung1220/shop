package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.paging.Pageble;

public interface INewService {

	public List<NewModel> findAll(Pageble pageble);
	public NewModel save(NewModel o);
	public void update(NewModel o);
	public void delete(long[] ids);
	public int totalItems();
}
