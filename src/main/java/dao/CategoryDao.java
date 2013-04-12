package dao;

import entity.Category;

public interface CategoryDao {
	
	Category find(Integer id);
	
 	void saveOrUpdate(Category category);
	
	void delete(Category category);

}
