package com.fi9e.rest.mappers;

import com.fi9e.rest.dto.UserDTO;
import com.fi9e.rest.entity.User;

/**
 * 
 * @author Christopher
 *
 */
public class UserMapper {
	
	//map user entity to DTO
	public static UserDTO mapUserToUserDTO(User user) {
		UserDTO dto = new UserDTO();
		
		dto.setEmail(user.getEmail());
		dto.setId(user.getId());
		dto.setUsername(user.getName());
		dto.setPassword(user.getPassword());
		//add role
		
		return dto;
	}
}
