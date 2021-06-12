package com.fi9e.rest.services;

import com.fi9e.rest.entity.User;

public interface TokenServiceInterface {
	public boolean verifyToken(String token);
	public String createToken(User user);
}
