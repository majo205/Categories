package service;

import assembler.CategoryAssembler;
import assembler.CategoryGroupAssembler;
import dao.CategoryDaoImpl;
import dao.CategoryGroupDaoImpl;
import dto.CategoryDto;
import dto.CategoryGroupDto;
import entity.Category;
import entity.CategoryGroup;

public class Service {

	public void saveOrUpdate(Object object) {		

	if(object instanceof CategoryDto){
		
		CategoryDaoImpl catDao = new CategoryDaoImpl();
		catDao.getSession().beginTransaction();
		
		Category category = new CategoryAssembler().assembleToEntity((CategoryDto) object);
		catDao.saveOrUpdate(category);
		
		catDao.getSession().getTransaction().commit();
		catDao.getSession().close();
	}
	
	if(object instanceof CategoryGroupDto){
		
		CategoryGroupDaoImpl groupDao = new CategoryGroupDaoImpl();
		groupDao.getSession().beginTransaction();
		
		CategoryGroup categorygroup = new CategoryGroupAssembler().assembleToEntity((CategoryGroupDto) object);
		groupDao.saveOrUpdate(categorygroup);	
		
		groupDao.getSession().getTransaction().commit();
		groupDao.getSession().close();
		
	}
	
	}

	public void delete(Object object) {
		
		if(object instanceof CategoryDto){
			
			CategoryDaoImpl catDao = new CategoryDaoImpl();
			catDao.getSession().beginTransaction();
			
			Category category = new CategoryAssembler().assembleToEntity((CategoryDto) object);
			catDao.delete(category);
			
			catDao.getSession().getTransaction().commit();
			catDao.getSession().close();
			
		}
		
		if(object instanceof CategoryGroupDto){
			
			CategoryGroupDaoImpl groupDao = new CategoryGroupDaoImpl();
			groupDao.getSession().beginTransaction();
			
			CategoryGroup categorygroup = new CategoryGroupAssembler().assembleToEntity((CategoryGroupDto) object);
			groupDao.delete(categorygroup);
			
			groupDao.getSession().getTransaction().commit();
			groupDao.getSession().close();
		}

	}

//	public Object find(Integer id){
//		
//		Object resultDto=  null;
//		
//		if(object instanceof CategoryDto){
//			
//			CategoryDaoImpl catDao = new CategoryDaoImpl();
//			catDao.getSession().beginTransaction();
//			
//			//Category category = new CategoryAssembler().assembleToEntity((CategoryDto) object);
//			Category category = catDao.find(new CategoryAssembler().assembleToEntity((CategoryDto) object).getCategoryId());
//			resultDto= new CategoryAssembler().assembleToDto(category);
//			
//			catDao.getSession().getTransaction().commit();
//			catDao.getSession().close();
//			
//		}
//		
//		if(object instanceof CategoryGroupDto){
//			
//			CategoryGroupDaoImpl groupDao = new CategoryGroupDaoImpl();
//			groupDao.getSession().beginTransaction();
//			
//			CategoryGroup categoryGroup = groupDao.find(new CategoryGroupAssembler().assembleToEntity((CategoryGroupDto) object).getCategoryGroupId());
//			resultDto= new CategoryGroupAssembler().assembleToDto(categoryGroup);
//			
//			groupDao.getSession().getTransaction().commit();
//			groupDao.getSession().close();
//		}
//		
//		return resultDto;
//	}	
	
	
	public CategoryDto findCategory(Integer id){
		CategoryDto resultDto = new CategoryDto();
		
		CategoryDaoImpl catDao = new CategoryDaoImpl();
		catDao.getSession().beginTransaction();
				
		resultDto= new CategoryAssembler().assembleToDto(catDao.find(id));
		
		catDao.getSession().getTransaction().commit();
		
		
		return resultDto;
	}
	
	public CategoryGroupDto findGroup(Integer id){
		CategoryGroupDto resultDto = new CategoryGroupDto();
		
		CategoryGroupDaoImpl groupDao = new CategoryGroupDaoImpl();
		groupDao.getSession().beginTransaction();
				
		resultDto= new CategoryGroupAssembler().assembleToDto(groupDao.find(id));
		
		groupDao.getSession().getTransaction().commit();
		
		return resultDto;
	}
	
	
}
