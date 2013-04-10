package entity;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.Type;
import org.hibernate.type.TrueFalseType;


@Entity (name="COMMON_CATEGORIES")
public class Category {
	
	@Id
	@Column (name= "COMMON_CATEGORY_ID", nullable= false, unique= true, length=38)
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int commonCategoryId;
	
	@Column (name="NAME", nullable=true, length=150)
	private String name;
	
	@Column (name="DESCRIPTION", nullable=true, length= 500)
	private String description;
	
	@Column (name="PARENT_CATEGORY", nullable=true, length=38)
	private int parentCategory;
	
	@Column (name="POSITION", nullable=false, length=38)	
	private int position;
	
	@Column (name="UPDATED_DATE", nullable=true)
	private Date updateDate;
	
	@Column (name="DELETED", nullable=true )
	@Type (type="true_false")
	private boolean deleted; //yesorno
	
	@Column (name="ORGN_ID", nullable=true, length=10)
	private int organisationId;
	
	@Column (name="UUID", nullable=true, length=36)
	private String uuid;
	
	@ManyToOne ()
	@JoinTable(
	    joinColumns = @JoinColumn(name = "commonCategoryId", 
	                              referencedColumnName = "commonCategoryId"), 
	    inverseJoinColumns = @JoinColumn(name = "categoryGroupId", 
	                              referencedColumnName = "categoryGroupId"))
		private CategoryGroup group;

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

	public CategoryGroup getGroup() {
		return group;
	}

	public void setGroup(CategoryGroup group) {
		this.group = group;
	}
	
	
		
}
