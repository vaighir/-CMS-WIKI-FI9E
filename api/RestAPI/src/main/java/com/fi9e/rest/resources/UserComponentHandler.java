package com.fi9e.rest.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import com.fi9e.rest.entity.User;
import com.fi9e.rest.exceptions.ApiException;
import com.fi9e.rest.helper.ApiResponse;
import com.fi9e.rest.managers.UserManager;
import com.fi9e.rest.dao.UserDao;
import com.fi9e.rest.dto.UserDTO;

@Path("/user")
public class UserComponentHandler {
	UserDao userDao = new UserDao();
	
	private UserManager mngr;
	private ApiResponse api;
	
	
	public UserComponentHandler() {
		this.getApiResponse();
	}
	
	UserManager getManager() {
		if(this.mngr == null) {
			this.mngr = new UserManager();
		}
		
		return mngr;
	}
	
	ApiResponse getApiResponse() {
		if(this.api == null) {
			this.api = new ApiResponse();
		}
		
		return this.api;
	}
	
	UserDTO userDTO;

	@GET
	@Path("/{id}")
	public Response getUserById(@PathParam("id") int id) {
		User user = userDao.getUserById(id);

		Gson gson = new Gson();
		String jsonString = gson.toJson(user);

		 System.out.println(jsonString);
		return Response.status(200).entity(jsonString).build();
		/*
		String user = "Peter Knerz";
		return Response.status(200).entity(user).build();*/
	}
	
	@POST
	@Path("/register")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response store(UserDTO user) throws ApiException {
		
		if(user.getName().isEmpty()) {
			this.api.error(user, "Username required");
		} else if (user.getEmail().isEmpty()) {
			this.api.error(user, "Email required");
		} else if (user.getPassword().isEmpty()) {
			this.api.error(user, "Password cannot be empty");
		}
		
		userDTO = this.getManager().createUser(user);
		
		return Response.ok(userDTO, MediaType.APPLICATION_JSON).build();
	}

}
