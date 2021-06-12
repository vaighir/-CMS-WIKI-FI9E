package com.fi9e.rest.services;

import com.fi9e.rest.dto.UserDTO;
import com.fi9e.rest.exceptions.ApiException;
import com.fi9e.rest.models.UserCredentials;

/**
 * 
 * @author Christopher
 *
 */
public class AuthService implements AuthServiceInterface  {

	public AuthService() {
		//
	}
	
	/**
	 * Auhtorize user
	 * 
	 * @param credentials
	 * @return
	 * @throws ApiException
	 */
	public UserDTO auhtorize(UserCredentials credentials) throws ApiException {
//		UserDTO user = this.userService.getUserDTOByEmail(credentials);
//		
//		if(user == null) {
//			throw new ApiException("User with email not found");
//		}
//		
//		if(!this.userService.checkPassword(credentials.getPassword(), user.getPassword())) {
//			throw new ApiException("Passwords do not match");
//		}
//		
//		return user;
		return null;
	}
	
}