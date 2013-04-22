package assembler;

import java.util.ArrayList;
import java.util.List;

import dao.CategoryDaoImpl;
import dao.CategoryGroupDaoImpl;
import dto.CategoryGroupDto;
import entity.Category;
import entity.CategoryGroup;

public class CategoryGroupAssembler {
	
	//private CategoryDaoImpl categoryDao;
	private CategoryGroupDaoImpl groupDao;
	private CategoryAssembler categoryAssembler;
	//private CategoryGroupAssembler groupAssembler;
	

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

		System.out.println("Assembling group to dto..");
		
		CategoryGroupDto resultDto = new CategoryGroupDto();

		resultDto.setCategoryGroupId(categoryGroup.getCategoryGroupId());
		resultDto.setDeleted(categoryGroup.getDeleted());
		resultDto.setDescription(categoryGroup.getDescription());
		resultDto.setName(categoryGroup.getName());
		resultDto.setOrganizatonId(categoryGroup.getOrganizatonId());
		resultDto.setUpdatedDate(categoryGroup.getUpdatedDate());
		//volat assembler kolekcii resultDto.setCategories(categoryGroup.getCategories());
		resultDto.setCategories(categoryAssembler.assembleToDtos(categoryGroup.getCategories()));

		return resultDto;
	}

	private CategoryGroup setEntity(CategoryGroupDto categoryGroupDTO) {
		
		System.out.println("Assembling group to entity..");

		CategoryGroup resultEntity = new CategoryGroup();
		List<Category> categoriesList = new ArrayList<Category>();
		
//		if ((groupDao.find(categoryGroupDTO
//		.getCategoryGroupId())) != null) {
//
//	resultEntity = groupDao.find(categoryGroupDTO
//			.getCategoryGroupId());
//} else {
//	resultEntity = new CategoryGroup();
////	resultEntity.setCategoryGroupId(categoryGroupDTO
////			.getCategoryGroupId());
//}


		try{
			
			resultEntity = groupDao.find(categoryGroupDTO.getCategoryGroupId());
			categoriesList = categoryAssembler.assembleToEntities(categoryGroupDTO.getCategories());
			
		}catch (NullPointerException e){
			System.err.println("Group with selected id does not exist");
			resultEntity = new CategoryGroup();
			
		}finally{
			
		resultEntity.setDeleted(categoryGroupDTO.isDeleted());
		resultEntity.setDescription(categoryGroupDTO.getDescription());
		resultEntity.setName(categoryGroupDTO.getName());
		resultEntity.setOrganizatonId(categoryGroupDTO.getOrganizatonId());
		resultEntity.setUpdatedDate(categoryGroupDTO.getUpdatedDate());
		resultEntity.setCategories(categoriesList);
		}
		return resultEntity;
		
	}

}
