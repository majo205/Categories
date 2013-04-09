package entity;

import java.util.Date;

public class CommonCategoriesGroups {

	private int categoryGroupId;
	private String name;
	private String description;
	private Date updatedDate;
	private char deleted; //yesorno
	private int organizatonId;
	
	
	public int getCategoryGroupId() {
		return categoryGroupId;
	}
	public void setCategoryGroupId(int categoryGroupId) {
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
	public char getDeleted() {
		return deleted;
	}
	public void setDeleted(char deleted) {
		this.deleted = deleted;
	}
	public int getOrganizatonId() {
		return organizatonId;
	}
	public void setOrganizatonId(int organizatonId) {
		this.organizatonId = organizatonId;
	}
	
}
