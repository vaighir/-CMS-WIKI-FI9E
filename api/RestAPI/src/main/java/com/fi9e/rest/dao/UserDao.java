package com.fi9e.rest.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.fi9e.rest.dto.UserDTO;
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

	public int createUser(String name, String email, String password, int roleId) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.getCurrentSession();

		User user = new User(name, email, password, roleId);

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

	public void updateUser(User user) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.getCurrentSession();

		User oldUser = getUserById(user.getId());
		
		oldUser.setEmail(user.getEmail());
		oldUser.setName(user.getName());
		//oldUser.setPassword(user.getPassword());
		oldUser.setRoleId(user.getRoleId());
		oldUser.setToken(user.getToken());
		oldUser.setRoleId(user.getRoleId());

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
	
	public int createUser(UserDTO dto) {
		return createUser(dto.getUsername(), dto.getEmail(), dto.getPassword(), dto.getRole().getId());
	}

}
