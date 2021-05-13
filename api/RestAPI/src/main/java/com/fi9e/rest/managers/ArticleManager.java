package com.fi9e.rest.managers;

import com.fi9e.rest.dao.ArticleDao;
import com.fi9e.rest.dto.ArticleDTO;
import com.fi9e.rest.entity.Article;

/**
 * 
 * @author Christopher
 *
 */
public class ArticleManager {
	
	private ArticleDao dao;
	private ArticleDao getDao() {
		if(this.dao == null) {
			this.dao = new ArticleDao();
		}
		
		return this.dao;
	}
	
	/**
	 * Create an article in DB and return created object as DTO
	 * 
	 * @param article
	 * @return
	 */
	public ArticleDTO createArticle(ArticleDTO article) {
		
		ArticleDTO articleDTO = new ArticleDTO();

		int newArticleId = this.getDao().createArticle(article);

		Article newArticle = this.getDao().getArticleById(newArticleId);

		if (newArticle != null) {
			// map database Object to DTO (response object)...
			articleDTO.setContent(newArticle.getContent());
			articleDTO.setCreated_at(newArticle.getCreatedAt());
			articleDTO.setId(newArticle.getId());
			articleDTO.setName(newArticle.getName());
			articleDTO.setSlug(newArticle.getSlug());
		}
		
		return articleDTO;
	}
	
	/**
	 * Get specific article by id
	 * @param id
	 * @return
	 */
	public ArticleDTO getArticleById(final int id) {
		Article article = this.getDao().getArticleById( id );
		ArticleDTO dto = new ArticleDTO();
		
		if(article != null) {
			dto.setContent(article.getContent());
			dto.setCreated_at(article.getCreatedAt());
			dto.setId(article.getId());
			dto.setName(article.getName());
			dto.setSlug(article.getSlug());
		}
		
		return dto;
	}
	
	public ArticleDTO getArticleById(final String id) {
		return this.getArticleById( Integer.parseInt(id) );
	}

}
