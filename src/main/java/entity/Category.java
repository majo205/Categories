package entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Type;
import org.hibernate.type.TrueFalseType;
import org.springframework.beans.factory.annotation.Required;

@Entity(name = "COMMON_CATEGORIES")
public class Category {

	@Id
	@Column(name = "COMMON_CATEGORY_ID", nullable = false, unique = true, length = 38)
	@GeneratedValue(strategy = GenerationType.AUTO)
	//@NotFound (action=NotFoundAction.IGNORE)
	private Integer categoryId;

	@Column(name = "NAME", nullable = true, length = 150)
	private String name;

	@Column(name = "DESCRIPTION", nullable = true, length = 500)
	private String description;

	@Column(name = "PARENT_CATEGORY", nullable = true, length = 38)
	private Integer parentCategory;

	@Column(name = "POSITION", nullable = false, length = 38)
	private Integer position;
	
	@Column(name = "UPDATED_DATE", nullable = true)
	private Date updateDate;

	@Column(name = "DELETED", nullable = false)
	@Type(type = "true_false")	
	private boolean deleted; // yesorno

	@Column(name = "ORGN_ID", nullable = true, length = 10)
	private Integer organisationId;

	@Column(name = "UUID", nullable = true, length = 36)
	private String uuid;
	
//	@Column(name = "GROUP_ID", nullable = true, length = 36)
//	private CategoryGroup categoryGroup;
	
	@ManyToMany(mappedBy="categories")
	//@NotFound (action=NotFoundAction.IGNORE)
	private List<CategoryGroup> groups;

	public Category(){
		
	}
	
	
	public Category(String name, String description, int position) {
		super();
		this.name = name;
		this.description = description;
		this.position = position;
	}


	public Category(String name, String description, Integer parentCategory,
			int position, Date updateDate, boolean deleted, int organisationId,
			String uuid) {
		super();
		
		this.name = name;
		this.description = description;
		this.parentCategory = parentCategory;
		this.position = position;
		this.updateDate = updateDate;
		this.deleted = deleted;
		this.organisationId = organisationId;
		this.uuid = uuid;
	}

	// @ManyToOne //(targetEntity="")
	// @JoinTable(name="COMMN_CATG_CATG_GRPS",
	// joinColumns = @JoinColumn(name = "COMMON_CATEGORY_ID",
	// referencedColumnName = "COMMON_CATEGORY_ID"),
	// inverseJoinColumns = @JoinColumn(name = "COMMN_CATG_GROUP_ID",
	// referencedColumnName = "COMMN_CATG_GROUP_ID"))
	// private List<CategoryGroup> group;

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
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

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
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


	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", name=" + name
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

	// public List<CategoryGroup> getGroup() {
	// return group;
	// }
	//
	// public void setGroup(List<CategoryGroup> group) {
	// this.group = group;
	// }

}
