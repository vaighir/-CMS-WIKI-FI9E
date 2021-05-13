package com.fi9e.rest.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.fi9e.rest.entity.Category;

public class CategoryDao {
	
	public Category getCategoryById(int id) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.getCurrentSession();

		Category category = null;

		try {
			session.beginTransaction();
			category = session.get(Category.class, id);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
			factory.close();
		}

		return category;
	}


	//TODO get all categories
}
