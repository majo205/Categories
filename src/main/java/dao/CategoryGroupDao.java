package dao;

import org.springframework.transaction.annotation.Transactional;

import entity.CategoryGroup;

public interface CategoryGroupDao {
	
	@Transactional
	CategoryGroup find(Integer id);

	@Transactional
	void saveOrUpdate(CategoryGroup group);

	@Transactional
	void delete(CategoryGroup group);

}
