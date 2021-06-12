package com.fi9e.rest.services;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.core.MultivaluedMap;

import org.mindrot.jbcrypt.BCrypt;

import com.fi9e.rest.dao.UserDao;
import com.fi9e.rest.dto.UserDTO;
import com.fi9e.rest.entity.User;
import com.fi9e.rest.exceptions.ApiException;
import com.fi9e.rest.mappers.UserMapper;
import com.fi9e.rest.models.UserCredentials;

public class UserService implements UserServiceInterface {

	private final UserDao userDao;
	private final TokenServiceInterface tokenService;
	
	@Inject
	public UserService(TokenServiceInterface tokenService) {
		this.userDao = new UserDao();
		this.tokenService = tokenService;
	}
	
	/**
	 * 
	 * @param plainPassword
	 * @param hashedPassword
	 * @return
	 */
	public boolean checkPassword(String plainPassword, String hashedPassword) {
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
	public UserDTO getUserDTOByEmail(UserCredentials credentials) {
		User user = this.getUserByEmail(credentials);
		
		return UserMapper.mapUserToUserDTO(user);
	}
	
	
	public User getUserByEmail(UserCredentials credentials) {
		List<User> users = this.userDao.get(credentials.getUserName());
		
		if(users.size() > 0) {
			return users.get(0);
		}
		
		return null;
	}
	
	
	public String login(MultivaluedMap<String, String> form) throws ApiException {
		String token = "";
		
		if(form == null) {
			throw new ApiException("Invalid form data");
		}
		
		String email;
		String password;
		email = !form.getFirst("username").isEmpty() ? form.getFirst("username") : "";
		password = !form.getFirst("password").isEmpty() ? form.getFirst("password"): "";
		
		UserCredentials credentials = new UserCredentials(email, password);
		
		User user = this.getUserByEmail(credentials);
		
		if(user == null) {
			throw new ApiException("User with email not found");
		}
		
		if(!this.checkPassword(password, user.getPassword())) {
			throw new ApiException("Passwords do not match our records");
		}
		
		//make token for user
		token = this.tokenService.createToken(user);
		
		//update user and save token
		user.setToken(token);
		this.userDao.updateUser(user);
		
		return token;
	}
}
