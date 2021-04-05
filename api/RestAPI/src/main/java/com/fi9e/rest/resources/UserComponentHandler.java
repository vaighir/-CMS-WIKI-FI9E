package com.fi9e.rest.resources;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.fi9e.rest.entity.User;
import com.fi9e.rest.dao.UserDao;

@Path("/user")
public class UserComponentHandler {
	UserDao userDao = new UserDao();
	
	@GET
	@Path("/{id}")
	public Response getUserById(@PathParam("id") int id) {
		User user = userDao.getUserById(id);
		
		return Response.status(200).entity(user.toString()).build();
	}
	
	
	@DELETE
	@Path("/{2}")
	public Response deleteUserById() {
		String user = "Peter Knerz";
		
		return Response.status(200).entity(user).build();
	}
}
