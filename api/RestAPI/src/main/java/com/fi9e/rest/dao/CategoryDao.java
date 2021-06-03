package com.fi9e.rest.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.fi9e.rest.dto.CategoryDTO;
import com.fi9e.rest.entity.Article;
import com.fi9e.rest.entity.Category;

/**
 * 
 * @author Wiktor
 *
 */
public class CategoryDao {
	
	public int createCategory(String name, String slug, String content) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.getCurrentSession();

		Category category = new Category(name);
		
		int newCategoryId = -1;
		try {
			session.beginTransaction();
			newCategoryId = (int) session.save(category);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			//@TODO: add throw exception on failure.
		} finally {
			if ( session.isOpen()) {
				session.close();
			}
			factory.close();
		}
		
		return newCategoryId;
	}
	
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
	
	public int createCategory(CategoryDTO dto) {
		return createCategory(dto.getName(), null, null);
	}
	
	public void updateCategory(Category category) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.getCurrentSession();

		Category oldCategory = getCategoryById(category.getId());

		oldCategory.setName(category.getName());

		try {
			session.beginTransaction();
			session.update(oldCategory);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if ( session.isOpen()) {
				session.close();
			}
			factory.close();
		}
	}

	public void deleteCategoryById(int id) {

		Category category = getCategoryById(id);

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
			session.delete(category);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if ( session.isOpen()) {
				session.close();
			}
			factory.close();
		}
	}
	
	//TODO get all categories

	public List<?> getAllCategories() {
		List<?> categoriesRaw = new ArrayList<>();
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
			categoriesRaw = session.createSQLQuery("SELECT * FROM category").addEntity(Category.class).list();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if ( session.isOpen()) {
				session.close();
			}
			factory.close();
		}
		
		return categoriesRaw;
	}
}
