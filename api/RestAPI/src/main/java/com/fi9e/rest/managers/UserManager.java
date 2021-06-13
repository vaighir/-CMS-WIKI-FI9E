package com.fi9e.rest.managers;


import com.fi9e.rest.dao.UserDao;
import com.fi9e.rest.dto.UserDTO;
import com.fi9e.rest.entity.User;
import com.fi9e.rest.mappers.UserMapper;

/**
 * 
 * @author Wiktor
 *
 */
public class UserManager {

	private UserDao dao;

	private UserDao getDao() {
		if (this.dao == null) {
			this.dao = new UserDao();
		}

		return this.dao;
	}

	/**
	 * Create a user in DB and return created object as DTO
	 * 
	 * @param user
	 * @return
	 */
	public UserDTO createUser(UserDTO user) {

		int newUserId = this.getDao().createUser(user);

		User newUser = this.getDao().getUserById(newUserId);

		UserDTO userDTO = UserMapper.mapUserToUserDTO(newUser);

		return userDTO;
	}

	/**
	 * Get specific user by id
	 * 
	 * @param id
	 * @return
	 */
	public UserDTO getUserById(final int id) {

		User user = this.getDao().getUserById(id);

		UserDTO dto = UserMapper.mapUserToUserDTO(user);

		return dto;
	}

	/**
	 * Get specific user by id
	 * 
	 * @param id
	 * @return
	 */
	public UserDTO getUserById(final String id) {
		return this.getUserById(Integer.parseInt(id));
	}

	

}
