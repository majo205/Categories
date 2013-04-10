package entity;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Index;
import org.hibernate.annotations.Type;

@Entity
@Table (name="COMMN_CATG_GROUP")
public class CategoryGroup {
	
	@Id
	@Column (name="COMMN_CATG_GROUP_ID", nullable=false, length=38)
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int categoryGroupId;
	
	@Column (name="NAME", nullable=true, length=150)
	private String name;
	
	@Column (name="DESCRIPTION", nullable=true, length=500)
	private String description;
	
	@Column (name="UPDATED_DATE", nullable=true)
	private Date updatedDate;
	
	@Column (name="DELETED", nullable=true)
	@Type (type="true_false")
	private boolean deleted; //yesorno
	
	@Column (name="ORGN_ID", nullable=true, length=10)
	private int organizatonId;
	
	@OneToMany (mappedBy="category")
//	@JoinTable(
//			name="COMMN_CATG_CATG_GRS",
//	    joinColumns = @JoinColumn(name = "COMMON_CATG_GROUP_ID"), 
//	    inverseJoinColumns = @JoinColumn(name = "COMMON_CATEGORY_ID")
//			)
	private List<Category> categories;
	
	
	
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
	public boolean getDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public int getOrganizatonId() {
		return organizatonId;
	}
	public void setOrganizatonId(int organizatonId) {
		this.organizatonId = organizatonId;
	}
	
}
