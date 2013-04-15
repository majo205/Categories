package assembler;

import java.util.ArrayList;
import java.util.List;

import dao.CategoryDaoImpl;
import dto.CategoryDto;
import entity.Category;

public class CategoryAssembler {

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
		return resultDto;
	}

	private Category setEntity(CategoryDto categoryDto) {
		
		Category resultEntity;
		
		CategoryDaoImpl categoryDao = new CategoryDaoImpl();
		
		if (categoryDao.find(categoryDto.getCategoryId())!=null){			
			
			resultEntity = categoryDao.find(categoryDto.getCategoryId());
			
			
		}
		else {
			resultEntity = new Category();
			resultEntity.setCommonCategoryId(categoryDto.getCategoryId());
		}
		
		resultEntity.setDeleted(categoryDto.isDeleted());
		resultEntity.setDescription(categoryDto.getDescription());
		resultEntity.setName(categoryDto.getName());
		resultEntity.setOrganisationId(categoryDto.getOrganisationId());
		resultEntity.setParentCategory(categoryDto.getParentCategory());
		resultEntity.setPosition(categoryDto.getPosition());
		resultEntity.setUpdateDate(categoryDto.getUpdateDate());
		resultEntity.setUuid(categoryDto.getUuid());			
		
		
//		resultEntity.setCommonCategoryId(categoryDto.getCommonCategoryId());
//		//najst cey dao a updatnut fieldz
//		resultEntity.setDeleted(categoryDto.isDeleted());
//		resultEntity.setDescription(categoryDto.getDescription());
//		resultEntity.setName(categoryDto.getName());
//		resultEntity.setOrganisationId(categoryDto.getOrganisationId());
//		resultEntity.setParentCategory(categoryDto.getParentCategory());
//		resultEntity.setPosition(categoryDto.getPosition());
//		resultEntity.setUpdateDate(categoryDto.getUpdateDate());
//		resultEntity.setUuid(categoryDto.getUuid());
		
		return resultEntity;
	}
	
}
