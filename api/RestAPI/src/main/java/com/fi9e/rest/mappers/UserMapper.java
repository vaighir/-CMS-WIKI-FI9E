package com.fi9e.rest.mappers;

import com.fi9e.rest.dto.RoleDTO;
import com.fi9e.rest.dto.UserDTO;
import com.fi9e.rest.entity.User;

/**
 * @author Wiktor
 */
public class UserMapper {
	
	/**
	 * Map User Entity to UserDTO
	 * 
	 * @param user
	 * @return
	 */
	public static UserDTO mapUserToUserDTO(User user) {
		UserDTO dto = new UserDTO();
		
		if(user != null) {
			dto.setName(user.getName());
			dto.setEmail(user.getEmail());
			dto.setId(user.getId());
			dto.setPassword(user.getPassword());
		}
		
		RoleDTO roleDTO = new RoleDTO();
		roleDTO.setId(user.getRoleId());
		
		dto.setRole(roleDTO);
		
		return dto;
	}
	
}
