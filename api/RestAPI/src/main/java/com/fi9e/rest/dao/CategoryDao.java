package com.fi9e.rest.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.fi9e.rest.entity.Article;

public class CategoryDao {
	
	public Article getCategoryById(int id) {

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

	//TODO get all categories
}
