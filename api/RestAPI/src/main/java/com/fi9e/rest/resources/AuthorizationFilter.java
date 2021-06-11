package com.fi9e.rest.resources;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.StringTokenizer;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;

import com.fi9e.rest.services.AuthService;

/**
 * Header Rquest Filter
 */
public class AuthorizationFilter implements ContainerRequestFilter {
	
	private static final String AUTH_HEADER_KEY = "Auhtorization";
	private static final String AUTH_HEADER_PREFIX = "Basic ";
	
	private AuthService auth;
	
	
	private AuthService getAuthService() {
		if(this.auth == null) {
			this.auth = new AuthService();
		}
		
		return this.auth;
	}
	
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		List<String> authHeader = requestContext.getHeaders().get(AUTH_HEADER_KEY);
		
		//get headers
		String authToken = authHeader.get(0);
		//remove auth header prefix
		authToken = authToken.replaceFirst(AUTH_HEADER_PREFIX, "");
		//decode credentials
		String decodedCredentials = Base64.getDecoder().decode(authToken).toString();
		
		//get decoded credentials
		StringTokenizer tokenizer = new StringTokenizer(decodedCredentials, ":");
		String username = tokenizer.nextToken();
		String password = tokenizer.nextToken();
		
		//use auth service to check credentials
		this.getAuthService().auhtorize();
	}

}
