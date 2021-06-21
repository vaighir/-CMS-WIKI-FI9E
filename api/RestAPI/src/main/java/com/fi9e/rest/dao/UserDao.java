package com.fi9e.rest.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.fi9e.rest.dto.UserDTO;
import com.fi9e.rest.entity.User;

/**
 * Data Acces Class for users
 * @author Christopher
 *
 */
public class UserDao {
	
	/**
	 * Retrieve user by ID
	 * 
	 * @param id the user id
	 * @return user the required user
	 */
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
	
	/**
	 * Create single user
	 * 
	 * @param name the user name
	 * @param email the email
	 * @param password the password
	 * @return int | ID
	 */
	public int createUser(String name, String email, String password) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.getCurrentSession();

		User user = new User(name, email, password);

		int newUserId = -1;
		try {
			session.beginTransaction();
			session.save(user);

			newUserId = (int) session.save(user);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
				factory.close();
			}
		}

		return newUserId;
	}
	
	/**
	 * Update single user
	 * 
	 * @param user the user to update
	 */
	public void updateUser(User user) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.getCurrentSession();

		User oldUser = getUserById(user.getId());

		oldUser.setEmail(user.getEmail());
		oldUser.setName(user.getName());
		oldUser.setRoleId(user.getRoleId());
		oldUser.setToken(user.getToken());
		oldUser.setRoleId(user.getRoleId());
		//we don´t update the password, since this should be done in an password reset flow

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

	/**
	 * Remove user by ID
	 * 
	 * @param id the user id
	 */
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
	
	/**
	 * Retrieve users by email | can only be one user...
	 * 
	 * @param email the email to search
	 * 
	 * @return ArrayList
	 */
	public List<User> get(String email) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.getCurrentSession();

		List<User> users = new ArrayList<User>();

		try {
			session.beginTransaction();

			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<User> crit = builder.createQuery(User.class);
			
			Root<User> root = crit.from(User.class);
			crit.select(root);
			crit.where( builder.equal( root.get("email"), email.toLowerCase() ) );
			
			users = session.createQuery( crit ).getResultList();

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

	/**
	 * Overload method for create single user
	 * 
	 * @param dto the user needed to create DB entry. 
	 * @return int | ID
	 */
	public int createUser(UserDTO dto) {
		return createUser(dto.getUsername(), dto.getEmail(), dto.getPassword());
	}
	
	/**
	 * Checks if user with email exist already
	 * 
	 * @param email the email to check
	 * 
	 * @return boolean
	 */
	public boolean hasEmail(String email) {
		List<?> users = this.get(email);

		boolean hasEmail = true;

		if (users == null) {
			hasEmail = false;
		}

		if (users.size() > 0) {
			hasEmail = true;
		} else {
			hasEmail = false;
		}
		
		return hasEmail;
	}

}
