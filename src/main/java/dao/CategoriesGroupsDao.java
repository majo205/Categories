package dao;

import entity.CommonCategories;
import entity.CommonCategoriesGroups;

public interface CategoriesGroupsDao {
	
	CommonCategoriesGroups findCategoryGroup();
	
	CommonCategoriesGroups saveOrUpdateCategoryGroup();
	
	CommonCategoriesGroups deleteCategoryCategoriesGroup();


}
