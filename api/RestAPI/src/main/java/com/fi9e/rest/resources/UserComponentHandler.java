package com.fi9e.rest.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.fi9e.rest.dto.UserDTO;
import com.fi9e.rest.filters.Authorized;
import com.fi9e.rest.helper.ApiResponse;
import com.fi9e.rest.services.UserService;

/**
 * 
 * @author Christopher
 *
 */
@Path("/user")
@Authorized
public class UserComponentHandler {

	private UserService userService;
	private ApiResponse api;
	
	public UserComponentHandler() {
		this.userService = new UserService();
		this.api = new ApiResponse();
	}
	
	@GET
	@Path("/{id}")
	public Response getUserById(@PathParam("id") int id) {
		UserDTO user = this.userService.getUserById(id);

		return this.api.success(user, "");
	}

}
