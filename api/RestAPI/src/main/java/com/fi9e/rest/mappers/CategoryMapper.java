package com.fi9e.rest.mappers;

import com.fi9e.rest.dto.CategoryDTO;
import com.fi9e.rest.entity.Category;

/**
 * 
 * @author 
 *
 */
public class CategoryMapper {
	
	/**
	 * Map Article Entity to CategoryDTO
	 * 
	 * @param category
	 * @return
	 */
	public static CategoryDTO mapCategoryToCategoryDTO(Category category) {
		CategoryDTO dto = new CategoryDTO();
		
		if(category != null) {
			dto.setId(category.getId());
			dto.setName(category.getName());
			dto.setDescription(category.getDescription());
		}
		
		return dto;
	}
	
}
