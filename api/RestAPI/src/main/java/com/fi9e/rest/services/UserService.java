package com.fi9e.rest.services;

import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

import com.fi9e.rest.dao.UserDao;
import com.fi9e.rest.dto.UserDTO;
import com.fi9e.rest.entity.User;
import com.fi9e.rest.mappers.UserMapper;
import com.fi9e.rest.models.UserCredentials;

public class UserService {

	private UserDao userDao;
	
	
	public UserService() {
		this.userDao = new UserDao();
	}
	
	/**
	 * 
	 * @param plainPassword
	 * @param hashedPassword
	 * @return
	 */
	protected boolean checkPassword(String plainPassword, String hashedPassword) {
		boolean result = false;
		
		if (BCrypt.checkpw(plainPassword, hashedPassword)) {
			result = true;
		}
		
		return result;
	}
	
	/**
	 * Get user but strip password!
	 * @param id
	 * @return
	 */
	public UserDTO getUserById(int id) {
		User user = this.userDao.getUserById(id);
		UserDTO dto = UserMapper.mapUserToUserDTO(user);
		
		dto.setPassword("");//don´t allow password read for this method!
		
		return dto;
	}
	
	/**
	 * Get full user information
	 * @param credentials
	 * @return
	 */
	public UserDTO getUserByEmail(UserCredentials credentials) {
		//get user by email | (means username)
		List<?> users = this.userDao.get(credentials.getUserName());
		List<UserDTO> dtoList = new ArrayList<UserDTO>();
		
		for (Object user : users) {
			dtoList.add(UserMapper.mapUserToUserDTO( (User) user ));
		}
		
		if(dtoList.size() > 0) {
			return dtoList.get(0);
		}
		
		return null;
	}
}
