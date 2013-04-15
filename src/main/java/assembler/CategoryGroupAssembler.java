package assembler;

import java.util.ArrayList;
import java.util.List;

import dao.CategoryGroupDaoImpl;
import dto.CategoryGroupDto;
import entity.CategoryGroup;

public class CategoryGroupAssembler {

	public CategoryGroupDto assembleToDto(CategoryGroup categoryGroup) {

		return setDto(categoryGroup);

	}

	public List<CategoryGroupDto> assembleToDtos(
			List<CategoryGroup> categoryGroupList) {

		List<CategoryGroupDto> resultDtoList = new ArrayList<CategoryGroupDto>();

		for (CategoryGroup categoryGroup : categoryGroupList) {			

			resultDtoList.add(setDto(categoryGroup));

		}
		return resultDtoList;

	}

	public CategoryGroup assembleToEntity(CategoryGroupDto categoryGroupDTO) {

		CategoryGroup resultEntity = new CategoryGroup();		

		return setEntity(categoryGroupDTO);

	}

	public List<CategoryGroup> assembleToEntities(
			List<CategoryGroupDto> categoryGroupDTOList) {

		List<CategoryGroup> resultEntityList = new ArrayList<CategoryGroup>();

		for (CategoryGroupDto categoryGroupDTO : categoryGroupDTOList) {
			
			resultEntityList.add(setEntity(categoryGroupDTO));
		}
		return resultEntityList;

	}

	private CategoryGroupDto setDto(CategoryGroup categoryGroup) {
		
		CategoryGroupDto resultDto = new CategoryGroupDto();
		
		resultDto.setCategoryGroupId(categoryGroup.getCategoryGroupId());
		resultDto.setDeleted(categoryGroup.getDeleted());
		resultDto.setDescription(categoryGroup.getDescription());
		resultDto.setName(categoryGroup.getName());
		resultDto.setOrganizatonId(categoryGroup.getOrganizatonId());
		resultDto.setUpdatedDate(categoryGroup.getUpdatedDate());
		resultDto.setCategories(categoryGroup.getCategories());
		
		return resultDto;
	}

	private CategoryGroup setEntity(CategoryGroupDto categoryGroupDTO) {
		
		CategoryGroup resultEntity;
		
		if((new CategoryGroupDaoImpl().find(categoryGroupDTO.getCategoryGroupId()))!=null){
			
			resultEntity = new CategoryGroupDaoImpl().find(categoryGroupDTO.getCategoryGroupId());
		}else{
			resultEntity = new CategoryGroup();
			resultEntity.setCategoryGroupId(categoryGroupDTO.getCategoryGroupId());
		}
		
		resultEntity.setCategoryGroupId(categoryGroupDTO.getCategoryGroupId());
		resultEntity.setDeleted(categoryGroupDTO.isDeleted());
		resultEntity.setDescription(categoryGroupDTO.getDescription());
		resultEntity.setName(categoryGroupDTO.getName());
		resultEntity.setOrganizatonId(categoryGroupDTO.getOrganizatonId());
		resultEntity.setUpdatedDate(categoryGroupDTO.getUpdatedDate());
		resultEntity.setCategories(categoryGroupDTO.getCategories());
		
		return resultEntity;
	}

}
