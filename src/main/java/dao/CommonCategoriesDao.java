package dao;

import entity.CommonCategories;

public interface CommonCategoriesDao {
	
	CommonCategories findCategory();
	
	CommonCategories saveOrUpdateCategory();
	
	CommonCategories deleteCategory();

}
