package com.fi9e.rest.services;

import com.fi9e.rest.dto.UserDTO;
import com.fi9e.rest.exceptions.ApiException;
import com.fi9e.rest.models.UserCredentials;

public interface AuthServiceInterface {
	public UserDTO auhtorize(UserCredentials credentials) throws ApiException;
}
