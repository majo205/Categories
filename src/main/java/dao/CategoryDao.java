package dao;

import entity.Category;

public interface CategoryDao {
	
	Category find(Integer id);
	
 	Category saveOrUpdate(Category category);
	
	Category delete(Category category);

}
