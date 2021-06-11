package com.fi9e.rest.resources;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.List;
import java.util.StringTokenizer;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import com.fi9e.rest.exceptions.ApiException;
import com.fi9e.rest.helper.ApiResponse;
import com.fi9e.rest.models.UserCredentials;
import com.fi9e.rest.services.AuthService;

/**
 * Header Rquest Filter
 */
@Provider
public class AuthorizationFilter implements ContainerRequestFilter {
	
	private static final String AUTH_HEADER_KEY = "authorization";
	private static final String AUTH_HEADER_PREFIX = "Basic ";
	
	private AuthService auth;
	private ApiResponse api;
	
	
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		
		//retrieve user credentials from auth header
		UserCredentials credentials = this.getCredentialsFromHeader(requestContext);
		
		if(credentials == null) {
			//error during auth | abort
			requestContext.abortWith( this.getApi().unauthorized() );
			return;
		}
		
		//get user
		try {
			this.getAuthService().auhtorize(credentials);
			return;
		} catch (ApiException e) {
			//error during auth | abort
			requestContext.abortWith( this.getApi().unauthorized() );
			return;
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
	
	
	private UserCredentials getCredentialsFromHeader(ContainerRequestContext requestContext) throws UnsupportedEncodingException {
		MultivaluedMap<String, String> authHeader = requestContext.getHeaders();//.get(AUTH_HEADER_KEY);
		
		if(authHeader == null) {
			return null;
		}
		
		//get headers
		String authToken = authHeader.get(AUTH_HEADER_KEY).get(0);
		//remove auth header prefix
		authToken = authToken.replaceFirst(AUTH_HEADER_PREFIX, "");
		//decode credentials
		byte[] decoded = Base64.getDecoder().decode(authToken.getBytes("UTF-8")); 
		String decodedCredentials = new String(decoded, "UTF-8");
		
		//get decoded credentials
		StringTokenizer tokenizer = new StringTokenizer(decodedCredentials, ":");
		String username = tokenizer.nextToken();
		String password = tokenizer.nextToken();
		
		return new UserCredentials(username, password);
	}

}
