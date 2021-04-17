package com.fi9e.rest.dao;

import com.fi9e.rest.entity.User;

public class UserDaoTest {

	public static void main(String[] args) {
		UserDao userDao = new UserDao();
		
		User user = userDao.getUserById(2);
		
		System.out.println(user);
	}

}
