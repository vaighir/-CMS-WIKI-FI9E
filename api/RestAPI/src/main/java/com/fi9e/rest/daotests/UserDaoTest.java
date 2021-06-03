package com.fi9e.rest.daotests;

import com.fi9e.rest.dao.UserDao;
import com.fi9e.rest.entity.Role;
import com.fi9e.rest.entity.User;

/**
 * 
 * @author 
 *
 */
public class UserDaoTest {
	public static void main(String[] args) {
		UserDao ud = new UserDao();
		
		Role tempRole = new Role();

		ud.createUser("Jackaf Sparrow", "john.smith@test.com", "password", tempRole);
		ud.createUser("Katewr Johnson", "kate.johnson@test.com", "waefsd", tempRole);

		User u1 = ud.getUserById(2);

		System.out.println("got user by id: " + u1);

		u1.setEmail("new_email@tet.com");

		ud.updateUser(u1);
		
		User u2 = ud.getUserById(2);
		
		System.out.println("updated user = " + u2);
		
		ud.deleteUserById(2);
		
		u2 = ud.getUserById(2);
		
		System.out.println("deleted user = " + u2);
	}

}
