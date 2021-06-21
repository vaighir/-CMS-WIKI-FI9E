package com.fi9e.rest.managers;

import java.util.ArrayList;
import java.util.List;

import com.fi9e.rest.dao.CategoryDao;
import com.fi9e.rest.dto.CategoryDTO;
import com.fi9e.rest.entity.Category;
import com.fi9e.rest.mappers.CategoryMapper;

/**
 * 
 * @author Wiktor, Su, Christopher
 *
 */
public class CategoryManager {

	private CategoryDao dao;

	private CategoryDao getDao() {
		if (this.dao == null) {
			this.dao = new CategoryDao();
		}

		return this.dao;
	}

	/**
	 * Create an category in DB and return created object as DTO
	 * 
	 * @param category the category to create
	 * @return CategoryDTO
	 */
	public CategoryDTO createCategory(CategoryDTO category) {

		int newCatecoryId = this.getDao().createCategory(category);

		Category newCategory = this.getDao().getCategoryById(newCatecoryId);

		CategoryDTO categoryDTO = CategoryMapper.mapCategoryToCategoryDTO(newCategory);

		return categoryDTO;
	}

	/**
	 * Get specific category by id
	 * 
	 * @param id the category id
	 * @return CategoryDTO
	 */
	public CategoryDTO getCategoryById(final int id) {

		Category category = this.getDao().getCategoryById(id);

		CategoryDTO dto = CategoryMapper.mapCategoryToCategoryDTO(category);

		return dto;
	}

	/**
	 * Get specific category by id
	 * 
	 * @param id the category id
	 * @return CategoryDTO
	 */
	public CategoryDTO getCategoryById(final String id) {
		return this.getCategoryById(Integer.parseInt(id));
	}

	/**
	 * Update Single category
	 * 
	 * @param categoryDTO category to update
	 * @return CategoryDTO
	 */
	public CategoryDTO updateCategory(final CategoryDTO categoryDTO) {

		Category category = this.getDao().getCategoryById(categoryDTO.getId());

		this.getDao().updateCategory(category);

		return CategoryMapper.mapCategoryToCategoryDTO(this.getDao().getCategoryById(categoryDTO.getId()));
	}

	/**
	 * Retrieve all categories
	 * 
	 * @return ArrayList
	 */
	public List<CategoryDTO> getAllCategories() {
		
		List<?> categories = getDao().getAllCategories();

		List<CategoryDTO> dtoList = new ArrayList<CategoryDTO>();

		for (Object category : categories) {
			dtoList.add(CategoryMapper.mapCategoryToCategoryDTO((Category) category));
		}

		return dtoList;
	}

}
