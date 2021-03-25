package com.laptrinhjavaweb.model;

import java.sql.Timestamp;

public class NewModel extends AbstractModel<NewModel>{
	
	private String tiltle;
	private String thumbnail;
	private String shortDescription;
	private String content;
	private Long categoryId;
	
	public NewModel() {
	}
	
	public NewModel(Long id, Timestamp createdDate, Timestamp modifiedDate, String createdBy, String modifiedBy) {
		super(id, createdDate, modifiedDate, createdBy, modifiedBy);
	}

	public NewModel(Long id, Timestamp createdDate, Timestamp modifiedDate, String createdBy, String modifiedBy,
			String title, String thumbnail, String shortDescription, String content, Long categoryId) {
		super(id, createdDate, modifiedDate, createdBy, modifiedBy);
		this.tiltle = title;
		this.thumbnail = thumbnail;
		this.shortDescription = shortDescription;
		this.content = content;
		this.categoryId = categoryId;
	}

	public String getTiltle() {
		return tiltle;
	}

	public void setTiltle(String title) {
		this.tiltle = title;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	
	
	
	

}
