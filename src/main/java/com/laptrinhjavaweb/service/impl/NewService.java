package com.laptrinhjavaweb.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.laptrinhjavaweb.dao.INewDao;
import com.laptrinhjavaweb.dao.impl.AbstractDAO;
import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.paging.Pageble;
import com.laptrinhjavaweb.service.INewService;

public class NewService extends AbstractDAO<NewModel> implements INewService {
	@Inject
	INewDao newDao;

	public List<NewModel> findAll(Pageble pageble) {
		return newDao.findAll(pageble);
	}

	public NewModel save(NewModel o) {
		o.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		o.setCreatedBy("");
		Long iD = newDao.save(o);
		
		
		return newDao.findOne(iD);
	}

	public void update(NewModel o) {
		NewModel upnew = new NewModel();
		upnew = newDao.findOne(o.getId());
		o.setModifiedBy("");
		o.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		o.setCreatedBy("");
		o.setCreatedDate(upnew.getCreatedDate());
		
		newDao.update(o);
		
	}
	
	public void delete(long[] ids) {
		for (long i:ids) {
			//delete comment
			newDao.delete(i);
		}
	}

	public int totalItems() {
				return newDao.totalItems();
	}

}
