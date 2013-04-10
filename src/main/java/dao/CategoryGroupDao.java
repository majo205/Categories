package dao;

import entity.Category;
import entity.CategoryGroup;

public interface CategoryGroupDao {
	
	CategoryGroup findCategoryGroup();
	
	CategoryGroup saveOrUpdateCategoryGroup();
	
	CategoryGroup deleteCategoryCategoriesGroup();


}
