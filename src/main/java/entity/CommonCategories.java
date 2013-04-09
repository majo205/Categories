package entity;

import java.util.Date;

public class CommonCategories {
	
	
	private int commonCategoryId;
	private String name;
	private String description;
	private int parentCategory;
	private int position;
	private Date updateDate;
	private char deleted; //yesorno
	private int organisationId;
	private String uuid;
	
	
	public int getCommonCategoryId() {
		return commonCategoryId;
	}
	public void setCommonCategoryId(int commonCategoryId) {
		this.commonCategoryId = commonCategoryId;
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
	public int getParentCategory() {
		return parentCategory;
	}
	public void setParentCategory(int parentCategory) {
		this.parentCategory = parentCategory;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public char getDeleted() {
		return deleted;
	}
	public void setDeleted(char deleted) {
		this.deleted = deleted;
	}
	public int getOrganisationId() {
		return organisationId;
	}
	public void setOrganisationId(int organisationId) {
		this.organisationId = organisationId;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	
	
}
