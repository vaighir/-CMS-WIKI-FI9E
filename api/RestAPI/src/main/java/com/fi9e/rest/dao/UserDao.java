package com.fi9e.rest.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.fi9e.rest.entity.User;

public class UserDao {

	// create session factory
	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class)
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
			}
		}

		return user;
	}

	// create user

	// update user

	// delete user

}
