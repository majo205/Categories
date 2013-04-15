package assembler;

import dto.CategoryDTO;
import dto.CategoryGroupDTO;
import entity.Category;
import entity.CategoryGroup;

public class CategoryGroupAssembler {
	
	public CategoryGroupDTO assembleToDto(CategoryGroup categoryGroup){

		CategoryGroupDTO resultDto = new CategoryGroupDTO();
		
		resultDto.setCategoryGroupId(categoryGroup.getCategoryGroupId());
		resultDto.setDeleted(categoryGroup.getDeleted());
		resultDto.setDescription(categoryGroup.getDescription());
		resultDto.setName(categoryGroup.getName());
		resultDto.setOrganizatonId(categoryGroup.getOrganizatonId());
		resultDto.setUpdatedDate(categoryGroup.getUpdatedDate());	
		
		return resultDto;
		
	}
	
	public CategoryGroup assembleToEntity(CategoryGroupDTO categoryGroupDTO){

		CategoryGroup resultEntity = new CategoryGroup();
		
		resultEntity.setCategoryGroupId(categoryGroupDTO.getCategoryGroupId());
		resultEntity.setDeleted(categoryGroupDTO.isDeleted());
		resultEntity.setDescription(categoryGroupDTO.getDescription());
		resultEntity.setName(categoryGroupDTO.getName());
		resultEntity.setOrganizatonId(categoryGroupDTO.getOrganizatonId());
		resultEntity.setUpdatedDate(categoryGroupDTO.getUpdatedDate());
		
		return resultEntity;
		
	}

}
