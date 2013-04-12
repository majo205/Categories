package dto;

import java.util.Date;

public class CategoryGroupDTO {

	
	private Integer categoryGroupId;	
	private String name;		
	private String description;	
	private Date updatedDate;
	private boolean deleted;	
	private Integer organizatonId;
	
	
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
	
	
	
}
