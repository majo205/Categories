package dto;

import java.util.Date;
import java.util.List;

import entity.Category;

public class CategoryGroupDto {

	
	private Integer categoryGroupId;	
	private String name;		
	private String description;	
	private Date updatedDate;
	private boolean deleted;	
	private Integer organizatonId;
	private List<Category> categories;
	
	
	public Integer getCategoryGroupId() {
		return categoryGroupId;
	}
	public void setCategoryGroupId(Integer categoryGroupId) {
		this.categoryGroupId = categoryGroupId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public Integer getOrganizatonId() {
		return organizatonId;
	}
	public void setOrganizatonId(Integer organizatonId) {
		this.organizatonId = organizatonId;
	}
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	@Override
	public String toString() {
		return "CategoryGroupDto [categoryGroupId=" + categoryGroupId
				+ ", name=" + name + ", description=" + description
				+ ", updatedDate=" + updatedDate + ", deleted=" + deleted
				+ ", organizatonId=" + organizatonId + ", categories="
				+ categories + "]";
	}
	
	
	
}
