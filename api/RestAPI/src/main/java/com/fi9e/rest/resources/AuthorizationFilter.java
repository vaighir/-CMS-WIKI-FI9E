package com.fi9e.rest.resources;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.StringTokenizer;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;

import com.fi9e.rest.exceptions.ApiException;
import com.fi9e.rest.helper.ApiResponse;
import com.fi9e.rest.models.UserCredentials;
import com.fi9e.rest.services.AuthService;

/**
 * Header Rquest Filter
 */
public class AuthorizationFilter implements ContainerRequestFilter {
	
	private static final String AUTH_HEADER_KEY = "Auhtorization";
	private static final String AUTH_HEADER_PREFIX = "Basic ";
	
	private AuthService auth;
	private ApiResponse api;
	
	
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		
		//retrieve user credentials from auth header
		UserCredentials credentials = this.getCredentialsFromHeader(requestContext);
		
		//get user
		try {
			this.getAuthService().auhtorize(credentials);
		} catch (ApiException e) {
			this.getApi().unauthorized();
		}
	}
	
	private AuthService getAuthService() {
		if(this.auth == null) {
			this.auth = new AuthService();
		}
		
		return this.auth;
	}
	
	private ApiResponse getApi() {
		if(this.api == null) {
			this.api = new ApiResponse();
		}
		
		return this.api;
	}
	
	
	private UserCredentials getCredentialsFromHeader(ContainerRequestContext requestContext) {
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
		
		return new UserCredentials(username, password);
	}

}
