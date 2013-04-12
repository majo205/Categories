package dao;

import entity.CategoryGroup;

public interface CategoryGroupDao {

	CategoryGroup find(Integer id);

	void saveOrUpdate(CategoryGroup group);

	void delete(CategoryGroup group);

}
