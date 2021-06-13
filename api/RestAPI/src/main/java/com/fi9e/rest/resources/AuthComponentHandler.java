package com.fi9e.rest.resources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import com.fi9e.rest.dto.UserDTO;
import com.fi9e.rest.exceptions.ApiException;
import com.fi9e.rest.filters.Authorized;
import com.fi9e.rest.helper.ApiResponseInterface;
import com.fi9e.rest.services.UserServiceInterface;

 
/**
 * 
 * @author Christopher
 *
 */
@Path("/")
public class AuthComponentHandler {
	
	private final ApiResponseInterface api;
	private final UserServiceInterface userService;
	
	@Inject
	public AuthComponentHandler(ApiResponseInterface api, UserServiceInterface userService) {
		this.api = api;
		this.userService = userService;
	}
	
	@POST
	@Path("login")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(MultivaluedMap<String, String> form) throws ApiException {
		return this.api.success(this.userService.login(form), "login successfull");
	}
	
	
	@POST
	@Path("register")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON) 
	public Response store(UserDTO user) throws ApiException {
		
		if(user.getUsername().isEmpty()) {
			this.api.error(user, "Username required");
		} else if (user.getEmail().isEmpty()) {
			this.api.error(user, "Email required");
		} else if (user.getPassword().isEmpty()) {
			this.api.error(user, "Password cannot be empty");
		}
		
		//check email taken
		if(this.userService.isEmailTaken( user.getEmail() )) {
			throw new ApiException("Email is already taken");
		}
		
		UserDTO userDto = this.userService.createUser(user);
		
		return this.api.success(userDto, "");
	}
	
	
	@POST
	@Path("logout")
	@Authorized
	public Response logout(@HeaderParam("authorization") String authHeader ) {
		this.userService.logout(authHeader);
		
		return this.api.success(null, "successfully logged out");
	}
}
