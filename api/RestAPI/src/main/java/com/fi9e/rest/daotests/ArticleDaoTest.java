package com.fi9e.rest.daotests;

import java.util.List;

import com.fi9e.rest.dao.ArticleDao;
import com.fi9e.rest.entity.Article;

/**
 * 
 * @author 
 *
 */
public class ArticleDaoTest {
	public static void main(String[] args) {
		ArticleDao ad = new ArticleDao();

		// Category testCategory = new Category();

		Integer id = ad.createArticle("titleż", "sluggyö",
				"this is a very nice and interesting article on another important subject. Probably has a lot of maths in it",
				2);

		System.out.println(id);

		Article a1 = ad.getArticleById(id);

		System.out.println(a1);

		a1.setContent("new content");

		ad.updateArticle(a1);

		a1 = ad.getArticleById(id);

		System.out.println("Updated the article, it now has the content: " + a1.getContent());

		ad.deleteArticleById(id);

		a1 = ad.getArticleById(id);

		System.out.println("after deleted, a1 should not return anything: " + a1);

		
		List<Article> allArticles = (List<Article>)ad.getAllArticles();
		 
		for (Article article : allArticles) {
				System.out.println("article id nr. " +
					article.getId() + " attributes: " + article); 
			}
		
		List<Article> allArticlesById = (List<Article>)ad.getAllArticlesByCategoryId(2);
		
		for (Article article : allArticlesById) {
			System.out.println("article id nr. " +
				article.getId() + " attributes: " + article); 
		}
		
	}

}
