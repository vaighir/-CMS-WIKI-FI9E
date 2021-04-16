package com.fi9e.rest.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;



@Path("/user")
public class UserComponentHandler {
	
	@GET
	@Path("/{id}")
	public Response getUserById() {

		User user = new User(1234, "Peter", "p1123@google.com");

		Gson gson = new Gson();
		String jsonString = gson.toJson(user);

		 System.out.println(jsonString);
		return Response.status(200).entity(jsonString).build();;
		/*
		String user = "Peter Knerz";
		return Response.status(200).entity(user).build();*/
	}

}
