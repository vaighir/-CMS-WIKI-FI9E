package com.fi9e.rest.daotests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fi9e.rest.dao.ArticleDao;

/**
 * 
 * @author 
 *
 */
class ArticleDaoTestJUnit {

		@Test
		public void testCreateArticleStringStringStringInt() {
			System.out.println("Running testCreateArticleStringStringStringInt...");
			
			//session.beginTransaction();
			
			ArticleDao articleDao = new ArticleDao();
			
			System.out.println("article Dao created");
			
			Integer id = 0;
			
			id = articleDao.createArticle("titleż", "sluggyö", "lots of content", 2);
			
			System.out.println("id = " + id);
			
			Assertions.assertTrue(id != 0);
		}

/*		@Test
		public void testCreateArticleArticleDTO() {
			fail("Not yet implemented");
		}

		@Test
		public void testUpdateArticle() {
			fail("Not yet implemented");
		}

		@Test
		public void testDeleteArticleById() {
			fail("Not yet implemented");
		}

		@Test
		public void testGetAllArticles() {
			fail("Not yet implemented");
		}

		@Test
		public void testGetAllArticlesByCategoryId() {
			fail("Not yet implemented");
		}*/

	}
	
	



