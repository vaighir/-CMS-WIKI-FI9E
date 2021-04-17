package com.fi9e.rest.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.fi9e.rest.entity.Role;
import com.fi9e.rest.entity.User;

public class UserDao {

	// create session factory
	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
			.buildSessionFactory();

	// create session
	Session session = factory.getCurrentSession();

	// get all users

	// get user by id
	public User getUserById(int id) {
		User user = null;

		try {
			session.beginTransaction();
			user = session.get(User.class, id);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
				factory.close();
			}
		}

		return user;
	}

	// create user
	public void createUser(String name, String email, String password) {
		
		User user = new User(name, email, password);
		
		try {
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
				factory.close();
			}
		}
	}

	// update user

	// delete user

}
