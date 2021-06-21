package com.fi9e.rest.mappers;

import com.fi9e.rest.dto.RoleDTO;
import com.fi9e.rest.dto.UserDTO;
import com.fi9e.rest.entity.User;

/**
 * Simple mapper class, to map between types
 * 
 * @author Wiktor, Christopher
 */
public class UserMapper {
	
	/**
	 * Map User Entity to UserDTO
	 * 
	 * @param user the user to map
	 * @return UserDTO
	 */
	public static UserDTO mapUserToUserDTO(User user) {
		UserDTO dto = new UserDTO();
		
		if(user != null) {
			dto.setUsername(user.getName());
			dto.setEmail(user.getEmail());
			dto.setId(user.getId());
			dto.setPassword(user.getPassword());
			dto.setToken(user.getToken());
		}
		
		RoleDTO roleDTO = new RoleDTO();
		roleDTO.setId(user.getRoleId());
		
		dto.setRole(roleDTO);
		
		return dto;
	}
	
	/***
	 * 
	 * @param dto the userDTO
	 * @param user the user
	 * @return User
	 */
	public static User mapUserDTOtoUser(UserDTO dto, User user) {
		user.setEmail(dto.getEmail());
		user.setName(dto.getUsername());
		user.setToken(dto.getToken());
		user.setPassword(dto.getPassword());//hashed password!
		user.setRoleId(dto.getRole().getId());
		
		return user;
	}
}
