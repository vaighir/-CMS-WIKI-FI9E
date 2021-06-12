package com.fi9e.rest.resources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import com.fi9e.rest.filters.Authorized;
import com.fi9e.rest.helper.ApiResponse;
import com.fi9e.rest.helper.ApiResponseInterface;

 
/**
 * 
 * @author Christopher
 *
 */
@Path("/")
public class AuthComponentHandler {
	
	private final ApiResponseInterface api;
	
	@Inject
	public AuthComponentHandler(ApiResponseInterface api) {
		this.api = api;
	}
	
	@POST
	@Path("login")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(MultivaluedMap<String, String> form) {
		
		//get credentials from request
		
		
		//check if user can authorize with user service
		
		//if authed, return JWT and save JWT to database (TOKEN)
		
		return this.api.success(null, "");
	}
	
	
	@POST
	@Path("register")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response register(MultivaluedMap<String, String> form) {
		
		//get credentials from request
		
		
		//check if user can authorize with user service
		
		//if authed, return JWT and save JWT to database (TOKEN)
		
		return this.api.success(null, "");
	}
	
	
	@POST
	@Path("logout")
	@Authorized
	public Response logout() {
		
		//do logout
		
		return this.api.success(null, "");
	}
}
