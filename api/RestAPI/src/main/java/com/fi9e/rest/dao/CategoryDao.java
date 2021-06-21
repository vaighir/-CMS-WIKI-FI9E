package com.fi9e.rest.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.fi9e.rest.dto.CategoryDTO;
import com.fi9e.rest.entity.Category;


/**
 * Data Access Object for Categories
 * 
 * @author Christopher, Wiktor, SU
 *
 */
public class CategoryDao {
	
	/**
	 * Create single Category
	 * 
	 * @param name the category name
	 * @param slug currently not implemented!
	 * @param content currently of no use!
	 * @return int | category ID
	 */
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
		} finally {
			if ( session.isOpen()) {
				session.close();
			}
			factory.close();
		}
		
		return newCategoryId;
	}
	
	/**
	 * Retrieve single category by ID
	 * 
	 * @param id the category id
	 * @return Category
	 */
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
	
	/**
	 * Overload create category by DTO
	 * @param dto the category DTO
	 * @return int | ID
	 */
	public int createCategory(CategoryDTO dto) {
		return createCategory(dto.getName(), null, null);
	}
	
	/**
	 * Update single category item
	 * 
	 * @param category the updated category
	 */
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

	/**
	 * Remove single category item
	 * 
	 * @param id the category id
	 */
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
	
	/**
	 * Retrieve all categories from DB
	 * 
	 * @return ArrayList categories
	 */
	public List<?> getAllCategories() {
		List<?> categoriesRaw = new ArrayList<>();
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
			//@TODO: refactor this to use Hibernate query builder | this is not practical here...
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
