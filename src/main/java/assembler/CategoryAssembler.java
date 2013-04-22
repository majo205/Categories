package assembler;

import java.util.ArrayList;
import java.util.List;

import dao.CategoryDaoImpl;
import dao.CategoryGroupDaoImpl;
import dto.CategoryDto;
import entity.Category;
import entity.CategoryGroup;

public class CategoryAssembler {
	
	private CategoryDaoImpl categoryDao;
	//private CategoryGroupDaoImpl groupDao;
	//private CategoryAssembler categoryAssembler;
	private CategoryGroupAssembler groupAssembler;

	public CategoryDto assembleToDto(Category category) {
		return setDto(category);

	}

	public List<CategoryDto> assembleToDtos(List<Category> categoryList) {

		List<CategoryDto> resultDtoList = new ArrayList<CategoryDto>();

		for (Category category : categoryList) {

			resultDtoList.add(setDto(category));
		}
		return resultDtoList;

	}

	public Category assembleToEntity(CategoryDto categoryDto) {

		// Category entity=setEntity(categoryDto);

		return setEntity(categoryDto);

	}

	public List<Category> assembleToEntities(List<CategoryDto> categoryDtoList) {

		List<Category> resultEntityList = new ArrayList<Category>();

		for (CategoryDto categoryDto : categoryDtoList) {
			resultEntityList.add(setEntity(categoryDto));
		}
		return resultEntityList;

	}

	private CategoryDto setDto(Category category) {
		
		System.out.println("Assembling category to dto..");

		CategoryDto resultDto = new CategoryDto();

		resultDto.setCategoryId(category.getCategoryId());
		resultDto.setDeleted(category.isDeleted());
		resultDto.setDescription(category.getDescription());
		resultDto.setName(category.getName());
		resultDto.setOrganisationId(category.getOrganisationId());
		resultDto.setParentCategory(category.getParentCategory());
		resultDto.setPosition(category.getPosition());
		resultDto.setUpdateDate(category.getUpdateDate());
		resultDto.setUuid(category.getUuid());
		resultDto.setGroups( groupAssembler.assembleToDtos(category.getGroups()));
		return resultDto;
	}

	private Category setEntity(CategoryDto categoryDto) {
		
		System.out.println("Assembling category to entity..");

		Category resultEntity = new Category();
		List<CategoryGroup> groupsList = new ArrayList<CategoryGroup>();
//
//		 if (categoryDao.find(categoryDto.getCategoryId()) != null) {
//
//				resultEntity = categoryDao.find(categoryDto.getCategoryId());
//
//			} 
//		 else {
//				resultEntity = new Category();
//			//	resultEntity.setCategoryId(categoryDto.getCategoryId());
//			}
		
		try{
			resultEntity = categoryDao.find(categoryDto.getCategoryId());
			groupsList = groupAssembler.assembleToEntities(categoryDto.getGroups());
			
		}catch (NullPointerException e){
			System.err.println("Category with selected id does not exist");
			resultEntity = new Category();
			
		}finally{		
		resultEntity.setDeleted(categoryDto.isDeleted());
		resultEntity.setDescription(categoryDto.getDescription());
		resultEntity.setName(categoryDto.getName());
		resultEntity.setOrganisationId(categoryDto.getOrganisationId());
		resultEntity.setParentCategory(categoryDto.getParentCategory());
		resultEntity.setPosition(categoryDto.getPosition());
		resultEntity.setUpdateDate(categoryDto.getUpdateDate());
		resultEntity.setUuid(categoryDto.getUuid());
		resultEntity.setGroups(groupsList);
		}
		return resultEntity;
	}

}
