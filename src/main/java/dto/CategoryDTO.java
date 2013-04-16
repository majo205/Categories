package dto;

import java.util.Date;
import java.util.List;

import entity.CategoryGroup;

public class CategoryDto {
	
	
	private Integer categoryId;	
	private String name;	
	private String description;	
	private Integer parentCategory;	
	private Integer position;	
	private Date updateDate;	
	private boolean deleted; 	
	private Integer organisationId;	
	private String uuid;
	private List<CategoryGroup> groups;
	
	public CategoryDto(){
		
	}
	
	public void setCategoryDto(String name, String description, Integer parentCategory,
			Integer position, Date updateDate, boolean deleted,
			Integer organisationId, String uuid) {
		
		this.name = name;
		this.description = description;
		this.parentCategory = parentCategory;
		this.position = position;
		this.updateDate = updateDate;
		this.deleted = deleted;
		this.organisationId = organisationId;
		this.uuid = uuid;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer commonCategoryId) {
		this.categoryId = commonCategoryId;
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
	public Integer getParentCategory() {
		return parentCategory;
	}
	public void setParentCategory(Integer parentCategory) {
		this.parentCategory = parentCategory;
	}
	public Integer getPosition() {
		return position;
	}
	public void setPosition(Integer position) {
		this.position = position;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public Integer getOrganisationId() {
		return organisationId;
	}
	public void setOrganisationId(Integer organisationId) {
		this.organisationId = organisationId;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	@Override
	public String toString() {
		return "CategoryDto [categoryId=" + categoryId + ", name=" + name
				+ ", description=" + description + ", parentCategory="
				+ parentCategory + ", position=" + position + ", updateDate="
				+ updateDate + ", deleted=" + deleted + ", organisationId="
				+ organisationId + ", uuid=" + uuid + "]";
	}

	public List<CategoryGroup> getGroups() {
		return groups;
	}

	public void setGroups(List<CategoryGroup> groups) {
		this.groups = groups;
	}


}
