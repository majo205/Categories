package dao;

import entity.Category;

public interface CategoryDao {
	
	Category findCategory();
	
	Category saveOrUpdateCategory();
	
	Category deleteCategory();

}
