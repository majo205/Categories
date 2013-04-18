package service;

import org.springframework.beans.factory.annotation.Autowired;

import assembler.CategoryAssembler;
import assembler.CategoryGroupAssembler;
import dao.CategoryDaoImpl;
import dao.CategoryGroupDaoImpl;
import dto.CategoryDto;
import dto.CategoryGroupDto;
import entity.Category;
import entity.CategoryGroup;

public class Service {

	private CategoryDaoImpl categoryDao;
	private CategoryGroupDaoImpl groupDao;
	private CategoryAssembler categoryAssembler;
	private CategoryGroupAssembler groupAssembler;

	public void saveOrUpdate(Object object) {

		if (object instanceof CategoryDto) {

			categoryDao.getSession().beginTransaction();

			Category category = categoryAssembler
					.assembleToEntity((CategoryDto) object);
			categoryDao.saveOrUpdate(category);

			categoryDao.getSession().getTransaction().commit();
			categoryDao.getSession().close();
		}

		if (object instanceof CategoryGroupDto) {

			groupDao.getSession().beginTransaction();

			CategoryGroup categorygroup = groupAssembler
					.assembleToEntity((CategoryGroupDto) object);
			groupDao.saveOrUpdate(categorygroup);

			groupDao.getSession().getTransaction().commit();
			groupDao.getSession().close();

		}

	}

	public void delete(Object object) {

		if (object instanceof CategoryDto) {

			categoryDao.getSession().beginTransaction();

			Category category = categoryAssembler
					.assembleToEntity((CategoryDto) object);
			categoryDao.delete(category);

			categoryDao.getSession().getTransaction().commit();
			categoryDao.getSession().close();

		}

		if (object instanceof CategoryGroupDto) {

			groupDao.getSession().beginTransaction();

			CategoryGroup categorygroup = groupAssembler
					.assembleToEntity((CategoryGroupDto) object);
			groupDao.delete(categorygroup);

			groupDao.getSession().getTransaction().commit();
			groupDao.getSession().close();
		}

	}



	public CategoryDto findCategory(Integer id) {

		CategoryDto resultDto = new CategoryDto();
		
		categoryDao.getSession().beginTransaction();

		resultDto = categoryAssembler.assembleToDto(categoryDao.find(id));

		categoryDao.getSession().getTransaction().commit();

		return resultDto;
	}

	public CategoryGroupDto findGroup(Integer id) {
		CategoryGroupDto resultDto = new CategoryGroupDto();
		
		groupDao.getSession().beginTransaction();

		resultDto = groupAssembler.assembleToDto(groupDao
				.find(id));

		groupDao.getSession().getTransaction().commit();

		return resultDto;
	}

	public CategoryDaoImpl getCategoryDao() {
		return categoryDao;
	}

	@Autowired
	public void setCategoryDao(CategoryDaoImpl categoryDao) {
		this.categoryDao = categoryDao;
	}

	public CategoryGroupDaoImpl getGroupDao() {
		return groupDao;
	}

	@Autowired
	public void setGroupDao(CategoryGroupDaoImpl groupDao) {
		this.groupDao = groupDao;
	}

	public CategoryAssembler getCategoryAssembler() {
		return categoryAssembler;
	}

	@Autowired
	public void setCategoryAssembler(CategoryAssembler categoryAssembler) {
		this.categoryAssembler = categoryAssembler;
	}

	public CategoryGroupAssembler getGroupAssembler() {
		return groupAssembler;
	}

	@Autowired
	public void setGroupAssembler(CategoryGroupAssembler groupAssembler) {
		this.groupAssembler = groupAssembler;
	}

}
