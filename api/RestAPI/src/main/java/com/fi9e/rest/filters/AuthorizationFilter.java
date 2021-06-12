package com.fi9e.rest.filters;

import java.io.IOException;
import java.util.Base64;
import java.util.StringTokenizer;

import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fi9e.rest.exceptions.ApiException;
import com.fi9e.rest.helper.ApiResponse;
import com.fi9e.rest.helper.ApiResponseInterface;
import com.fi9e.rest.models.UserCredentials;
import com.fi9e.rest.services.AuthService;
import com.fi9e.rest.services.AuthServiceInterface;

/**
 * Header Request Filter | checks for credentials
 */
@Provider
@Authorized
public class AuthorizationFilter implements ContainerRequestFilter {
	
	private static final String AUTH_HEADER_KEY = "authorization";
	private static final String AUTH_HEADER_PREFIX_BASIC = "Basic ";
	private static final String AUTH_HEADER_PREFIX_BEARER = "Bearer ";
	
	private AuthServiceInterface auth;
	private ApiResponseInterface api;
	
	@Inject
	public AuthorizationFilter(AuthServiceInterface auth, ApiResponseInterface api) {
		this.auth = auth;
		this.api = api;
	}
	
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		//Basic Auth Login
		this.doBasicAuthVariantVerify(requestContext);
		
		//Token Based Login
		//@TODO: add token based login
	}
	
	/***
	 * Basic Auth login variant
	 * @param requestContext
	 * @return
	 */
	private UserCredentials getCredentialsFromHeader(ContainerRequestContext requestContext) {
		MultivaluedMap<String, String> authHeader = requestContext.getHeaders();//.get(AUTH_HEADER_KEY);
		
		if(authHeader == null) {
			return null;
		}
		
		//get headers
		String authToken = (authHeader.get(AUTH_HEADER_KEY) != null) ? authHeader.get(AUTH_HEADER_KEY).get(0) : "";
		
		if(authToken.isEmpty()) {
			return null;
		}
		
		//remove auth header prefix
		authToken = authToken.replaceFirst(AUTH_HEADER_PREFIX_BASIC, "");
		//decode credentials
		String decodedCredentials = "";
		try {
			byte[] decoded = Base64.getDecoder().decode(authToken.getBytes("UTF-8")); 
			decodedCredentials = new String(decoded, "UTF-8");
		} catch (Exception e) {
			return null;
		}
		
		//get decoded credentials
		StringTokenizer tokenizer = new StringTokenizer(decodedCredentials, ":");
		String username = tokenizer.nextToken();
		String password = tokenizer.nextToken();
		
		return new UserCredentials(username, password);
	}
	
	/**
	 * Check Auth Header for Bearer Token and either grant acces or deny
	 * 
	 * @param requestContext
	 */
	private void doBearerTokenVerify(ContainerRequestContext requestContext) {
		//@TODO: get token from bearer header
		
		//@CHECK IF Token is Valid
		
		//@CHECK IF USER has same TOKEN (is isCurrentUserToken)
		
		//return errors if login failed
	}
	
	
	/**
	 * Check Auth header for Basic user Credentials.
	 * When Credentials found, grant acces. If not return unauth error.
	 * @param requestContext
	 * @throws JsonProcessingException
	 */
	private void doBasicAuthVariantVerify(ContainerRequestContext requestContext) throws JsonProcessingException {
		//retrieve user credentials from auth header
		UserCredentials credentials = null;
		
		credentials = this.getCredentialsFromHeader(requestContext);
		
		if(credentials == null) {
			requestContext.abortWith( this.api.unauthorized() );
			return;
		}
		
		//get user
		try {
			this.auth.auhtorize(credentials);
			return;
		} catch (ApiException e) {
			requestContext.abortWith( this.api.unauthorized() );
			return;
		}
	}

}
