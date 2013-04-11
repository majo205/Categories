package dao;

import entity.CategoryGroup;

public interface CategoryGroupDao {

	CategoryGroup find(Integer id);

	CategoryGroup saveOrUpdate(CategoryGroup group);

	CategoryGroup delete(CategoryGroup group);

}
