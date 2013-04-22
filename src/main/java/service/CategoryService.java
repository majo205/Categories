package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import assembler.CategoryAssembler;
import dao.CategoryDaoImpl;
import dto.CategoryDto;
import entity.Category;

public class CategoryService {

	private CategoryDaoImpl categoryDao;	
	private CategoryAssembler categoryAssembler;
	
	
	public void saveOrUpdate(Object object) {

			categoryDao.getSession().beginTransaction();

			Category category = categoryAssembler
					.assembleToEntity((CategoryDto) object);
			categoryDao.saveOrUpdate(category);

			categoryDao.getSession().getTransaction().commit();
			//categoryDao.getSession().close();
		

		

	}

	
	public void delete(Object object) {

		
			categoryDao.getSession().beginTransaction();

			Category category = categoryAssembler
					.assembleToEntity((CategoryDto) object);
			categoryDao.delete(category);

			categoryDao.getSession().getTransaction().commit();
			//categoryDao.getSession().close();

		

		

	}


	@Transactional
	public CategoryDto find(Integer id) {

		CategoryDto resultDto = new CategoryDto();
		
		categoryDao.getSession().beginTransaction();
		
		resultDto = categoryAssembler.assembleToDto(categoryDao.find(id));

		categoryDao.getSession().getTransaction().commit();

		return resultDto;
	}

		

	public CategoryDaoImpl getCategoryDao() {
		return categoryDao;
	}

	@Autowired
	public void setCategoryDao(CategoryDaoImpl categoryDao) {
		this.categoryDao = categoryDao;
	}

	
	public CategoryAssembler getCategoryAssembler() {
		return categoryAssembler;
	}

	@Autowired
	public void setCategoryAssembler(CategoryAssembler categoryAssembler) {
		this.categoryAssembler = categoryAssembler;
	}

	

}
