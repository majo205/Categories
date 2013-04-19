package dao;

import org.springframework.transaction.annotation.Transactional;

import entity.Category;

public interface CategoryDao {
	
	@Transactional
	Category find(Integer id);
	
	@Transactional
 	void saveOrUpdate(Category category);
	
	@Transactional
	void delete(Category category);

}
