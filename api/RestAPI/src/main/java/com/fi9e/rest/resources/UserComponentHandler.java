package com.fi9e.rest.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/user")
public class UserComponentHandler {
	
	@GET
	@Path("/{id}")
	public Response getUserById() {
		String user = "Peter Knerz";
		
		return Response.status(200).entity(user).build();
	}
	
}
