package com.fi9e.rest.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.fi9e.rest.entity.User;

public class UserDao {

	public User getUserById(int id) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.getCurrentSession();
	
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

	public void createUser(String name, String email, String password) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.getCurrentSession();

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

	public void updateUser(User user) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.getCurrentSession();

		User oldUser = getUserById(user.getId());
		
		oldUser.setEmail(user.getEmail());
		oldUser.setName(user.getName());
		oldUser.setPassword(user.getPassword());
		oldUser.setRole(user.getRole());

		try {
			session.beginTransaction();
			session.update(oldUser);
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

	public void deleteUserById(int id) {
		User user = getUserById(id);
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
			session.delete(user);
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

}
