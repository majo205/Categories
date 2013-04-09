package dao;

import entity.CategoriesAndGroups;
import entity.CommonCategories;

public interface CategoriesAndGroupsDao {

	CategoriesAndGroups findCategoryAndGroups();

	CategoriesAndGroups saveOrUpdateCategoryAndGroups();

	CategoriesAndGroups deleteCategoryCategoriesAndGroups();

}
