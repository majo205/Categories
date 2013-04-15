package assembler;

import dao.CategoryDaoImpl;
import dto.CategoryDTO;
import entity.Category;

public class CategoryAssembler {

	public CategoryDTO assembleToDto(Category category){
		
		CategoryDTO resultDto = new CategoryDTO();
		
		resultDto.setCommonCategoryId(category.getCommonCategoryId());
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
	
	public Category assembleToEntity(CategoryDTO categoryDto){
		
		Category resultEntity = new Category();
		
		resultEntity.setCommonCategoryId(categoryDto.getCommonCategoryId());
		resultEntity.setDeleted(categoryDto.isDeleted());
		resultEntity.setDescription(categoryDto.getDescription());
		resultEntity.setName(categoryDto.getName());
		resultEntity.setOrganisationId(categoryDto.getOrganisationId());
		resultEntity.setParentCategory(categoryDto.getParentCategory());
		resultEntity.setPosition(categoryDto.getPosition());
		resultEntity.setUpdateDate(categoryDto.getUpdateDate());
		resultEntity.setUuid(categoryDto.getUuid());
		
		return resultEntity;
		
	}

}
