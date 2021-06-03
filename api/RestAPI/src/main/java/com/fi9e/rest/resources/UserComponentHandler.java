package com.fi9e.rest.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.fi9e.rest.dao.UserDao;
import com.fi9e.rest.entity.User;
import com.google.gson.Gson;

@Path("/user")
/**
 * User Endpoints
 * 
 * @author Christopher, Su?
 *
 */
public class UserComponentHandler {
	UserDao userDao = new UserDao();

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

}
