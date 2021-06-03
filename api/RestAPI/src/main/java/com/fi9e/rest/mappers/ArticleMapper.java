package com.fi9e.rest.mappers;

import com.fi9e.rest.dto.ArticleDTO;
import com.fi9e.rest.dto.CategoryDTO;
import com.fi9e.rest.entity.Article;

/**
 * Mapper class, used to map between datatypes
 * 
 * Note: this can be refactored into an Mapper Interface, when using Jackson Mapper.
 * 
 * @author Christopher
 */
public class ArticleMapper {
	
	/**
	 * Map Article Entity to ArticleDTO
	 * 
	 * @param article
	 * @return
	 */
	public static ArticleDTO mapArticleToArticleDTO(Article article) {
		ArticleDTO dto = new ArticleDTO();
		
		if(article != null) {
			dto.setContent(article.getContent());
			dto.setCreated_at(article.getCreatedAt());
			dto.setId(article.getId());
			dto.setName(article.getName());
			dto.setSlug(article.getSlug());
			
			CategoryDTO catDTO = new CategoryDTO();
			catDTO.setId( article.getCategory() );
			//catDTO.setName(""); @TODO: put category name here...
			
			dto.setCategory( catDTO );
		}
		
		return dto;
	}
	
}
