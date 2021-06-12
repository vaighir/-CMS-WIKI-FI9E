package com.fi9e.rest.services;

import javax.ws.rs.core.MultivaluedMap;

import com.fi9e.rest.dto.UserDTO;
import com.fi9e.rest.entity.User;
import com.fi9e.rest.exceptions.ApiException;
import com.fi9e.rest.models.UserCredentials;

public interface UserServiceInterface {
	public UserDTO getUserById(int id);
	public User getUserByEmail(UserCredentials credentials);
	public UserDTO getUserDTOByEmail(UserCredentials credentials);
	public boolean checkPassword(String plainPassword, String hashedPassword);
	public String login(MultivaluedMap<String, String> form) throws ApiException;
	public void logout(String token);
	public String stripToken(String authHeader);
}
