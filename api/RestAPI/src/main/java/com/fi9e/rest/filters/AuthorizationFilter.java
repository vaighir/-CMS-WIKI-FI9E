package com.fi9e.rest.filters;

import java.io.IOException;

import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fi9e.rest.dao.UserDao;
import com.fi9e.rest.entity.User;
import com.fi9e.rest.helper.ApiResponseInterface;
import com.fi9e.rest.services.TokenServiceInterface;
import com.fi9e.rest.services.UserServiceInterface;

import io.jsonwebtoken.Claims;

/**
 * Header Request Filter | checks for credentials
 */
@Provider
@Authorized
public class AuthorizationFilter implements ContainerRequestFilter {
	
	private static final String AUTH_HEADER_KEY = "authorization";
	
	private UserServiceInterface userService;
	private ApiResponseInterface api;
	private TokenServiceInterface tokenService;
	private UserDao userDao;
	
	
	@Inject
	public AuthorizationFilter(ApiResponseInterface api, UserServiceInterface users, TokenServiceInterface tokens) {
		this.api = api;
		this.userService = users;
		this.tokenService = tokens;
		this.userDao = new UserDao();
	}
	
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		this.doBearerTokenVerify(requestContext);
	}
	
	/**
	 * Check Auth Header for Bearer Token and either grant acces or deny
	 * 
	 * @param requestContext
	 * @throws JsonProcessingException 
	 */
	private void doBearerTokenVerify(ContainerRequestContext requestContext) throws JsonProcessingException {
		MultivaluedMap<String, String> authHeaders = requestContext.getHeaders();
		
		if(authHeaders == null) {
			requestContext.abortWith( this.api.unauthorized() );
			return;
		}
		
		//get headers
		String authHeader = (authHeaders.get(AUTH_HEADER_KEY) != null) ? authHeaders.get(AUTH_HEADER_KEY).get(0) : "";
		
		if(authHeader.isEmpty()) {
			requestContext.abortWith( this.api.unauthorized() );
			return;
		}
		
		String token = this.userService.stripToken(authHeader);
		
		Claims payload = this.tokenService.verifyToken(token);
		
		int user_id =  payload.get("user_id", Integer.class);		
		
		User user = this.userDao.getUserById(user_id);
		
		if(user.getToken() == null || !user.getToken().equals(token)) {
			requestContext.abortWith( this.api.unauthorized() );
			return;
		}
	}
	
}
