package com.fi9e.rest.services;

import com.fi9e.rest.entity.User;

/**
 * 
 * @author Christopher
 *
 */
public class TokenService implements TokenServiceInterface {
	
	//used to sign keys
	private final String KEY_SECRET = "fi9e_super_secret_secret";
	
	
	public boolean verifyToken(String token) {
		
		return false;
	}
	
	public String createToken(User user) {
		String token = "";
		//@TODO: make token
		
		//@TODO: update user and add token
		
		return token;
	}
	
	
	
}
