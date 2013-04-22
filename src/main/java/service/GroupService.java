package service;

import org.springframework.beans.factory.annotation.Autowired;

import assembler.CategoryGroupAssembler;
import dao.CategoryGroupDaoImpl;
import dto.CategoryGroupDto;
import entity.CategoryGroup;

public class GroupService {

	
	private CategoryGroupDaoImpl groupDao;	
	private CategoryGroupAssembler groupAssembler;
	
	
	public void saveOrUpdate(Object object) {

					groupDao.getSession().beginTransaction();

			CategoryGroup categorygroup = groupAssembler
					.assembleToEntity((CategoryGroupDto) object);
			groupDao.saveOrUpdate(categorygroup);

			groupDao.getSession().getTransaction().commit();
			//groupDao.getSession().close();		

	}

	
	public void delete(Object object) {		

	

			groupDao.getSession().beginTransaction();

			CategoryGroup categorygroup = groupAssembler
					.assembleToEntity((CategoryGroupDto) object);
			groupDao.delete(categorygroup);

			groupDao.getSession().getTransaction().commit();
			//groupDao.getSession().close();
		

	}


	public CategoryGroupDto find(Integer id) {
		CategoryGroupDto resultDto = new CategoryGroupDto();
		
		groupDao.getSession().beginTransaction();

		resultDto = groupAssembler.assembleToDto(groupDao
				.find(id));

		groupDao.getSession().getTransaction().commit();

		return resultDto;
	}

	

	public CategoryGroupDaoImpl getGroupDao() {
		return groupDao;
	}

	@Autowired
	public void setGroupDao(CategoryGroupDaoImpl groupDao) {
		this.groupDao = groupDao;
	}

	
	public CategoryGroupAssembler getGroupAssembler() {
		return groupAssembler;
	}

	@Autowired
	public void setGroupAssembler(CategoryGroupAssembler groupAssembler) {
		this.groupAssembler = groupAssembler;
	}

}
