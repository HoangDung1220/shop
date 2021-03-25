package com.laptrinhjavaweb.paging;

import com.laptrinhjavaweb.sort.Sorter;

public class PageRequest implements Pageble{
	private int page;
	private int maxPageItem;
	private Sorter sorter;
	
	public PageRequest(int page,int maxPageItem,Sorter sorter) {
		this.page=page;
		this.maxPageItem=maxPageItem;
		this.sorter =sorter;
	}
	

	public int getPage() {
		return this.page;
	}

	public int getOffset() {
	//	if ((Integer) this.page!=null) {
		return (this.page-1)*this.maxPageItem;
	//	}
	//	return null;
	}

	public int getLimit() {
		return this.maxPageItem;
	}


	public Sorter getSorter() {
		return this.sorter;
	}



}
