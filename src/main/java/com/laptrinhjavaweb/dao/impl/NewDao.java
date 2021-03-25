package com.laptrinhjavaweb.dao.impl;

import java.util.List;

import com.laptrinhjavaweb.dao.INewDao;
import com.laptrinhjavaweb.mapper.NewMapper;
import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.paging.Pageble;

public class NewDao extends AbstractDAO<NewModel> implements INewDao{

	public List<NewModel> findAll(Pageble pageble) {
		StringBuilder querry = new StringBuilder();
		querry.append("select *from news ");
		if (pageble.getSorter().getSortName()!=null && pageble.getSorter().getSortBy()!=null) {
			querry.append("order by "+pageble.getSorter().getSortName()+" "+pageble.getSorter().getSortBy()+" ");
		}
		
		if ((Integer) pageble.getOffset()!=null && (Integer) pageble.getLimit()!=null) {
			querry.append("limit "+pageble.getOffset()+","+pageble.getLimit()+"");
			return query(querry.toString(),new NewMapper());
		}
		else 	
		{		
			return query(querry.toString(),new NewMapper());
		}
		

		
	}

	

	public Long save(NewModel o) {
		
		StringBuilder querry = new StringBuilder();
				querry.append("insert into news(tiltle,thumbnail,shortdescription,content,categoryid,createddate,createdby)");
				querry.append("values (?,?,?,?,?,?,?)");
		return insert(querry.toString(),o.getTiltle(),o.getThumbnail(),o.getShortDescription(),o.getContent(),o.getCategoryId(),o.getCreatedDate(),o.getCreatedBy());
	}



	public NewModel findOne(Long id) {

		String sql ="select *from news where id=?";
		List<NewModel> list = query(sql,new NewMapper(),id);
		return list.isEmpty()?null:list.get(0);
	}



	public void update(NewModel o) {
		
		String sql =  "update news set tiltle=?,content=?,shortdescription=?,categoryid=?,thumbnail=?,createdby=?,modifieddate=?,modifiedby=?, createddate=? where id=?";
		update(sql,o.getTiltle(),o.getContent(),o.getShortDescription(),o.getCategoryId(),o.getThumbnail(),o.getCreatedBy(),o.getModifiedDate(),o.getModifiedBy(),o.getCreatedDate(),o.getId());
		
	}



	public void delete(long id) {
		String sql ="delete from news where id=?";
		delete (sql,id);
		
	}
	
	public int totalItems() {
		String sql ="select count(*) from news";
		return count(sql);
	}

}
