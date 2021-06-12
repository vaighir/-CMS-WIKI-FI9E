package com.fi9e.rest.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.NativeQuery;

import com.fi9e.rest.entity.Role;
import com.fi9e.rest.entity.User;
import com.mysql.cj.Query;

public class UserDao {


	// get user by id
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

	// create user
	public void createUser(String name, String email, String password, Role role) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.getCurrentSession();

		User user = new User(name, email, password, role);

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
	public void updateUser(User user) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.getCurrentSession();

		User oldUser = getUserById(user.getId());
		
		oldUser.setEmail(user.getEmail());
		oldUser.setName(user.getName());
		oldUser.setPassword(user.getPassword());
		oldUser.setRole(user.getRole());
		oldUser.setToken(user.getToken());

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

	// delete user
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
	
	@SuppressWarnings({"unchecked", "deprecation"})
	public List<User> get(String email) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		List<User> users = new ArrayList<User>();
		
		try {
			session.beginTransaction();
			
			Criteria crit = session.createCriteria(User.class);
			crit.add(Restrictions.eqOrIsNull("email", email.toLowerCase()));
			users = crit.list();
	
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
				factory.close();
			}
		}
		
		return users;
	}
}
