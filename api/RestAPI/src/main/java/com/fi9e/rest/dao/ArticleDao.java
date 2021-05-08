package com.fi9e.rest.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.fi9e.rest.entity.Article;

public class ArticleDao {
	
	public Article getArticleById(int id) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.getCurrentSession();

		Article article = null;

		try {
			session.beginTransaction();
			article = session.get(Article.class, id);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
			factory.close();
		}

		return article;
	}

	public void createArticle(String name, String slug, String content) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.getCurrentSession();

		Article article = new Article(name, slug, content, new java.util.Date(), new java.util.Date());

		try {
			session.beginTransaction();
			session.save(article);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
			factory.close();
		}
	}

	public void updateArticle(Article article) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.getCurrentSession();

		Article oldArticle = getArticleById(article.getId());

		oldArticle.setContent(article.getContent());
		oldArticle.setSlug(article.getSlug());
		oldArticle.setUpdatedAt(new java.util.Date());

		try {
			session.beginTransaction();
			session.update(oldArticle);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
			factory.close();
		}
	}

	public void deleteArticleById(int id) {

		Article article = getArticleById(id);

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
			session.delete(article);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
			factory.close();
		}
	}
	
	//TODO: get all articles with id
}
