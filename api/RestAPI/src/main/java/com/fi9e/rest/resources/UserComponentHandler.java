package com.fi9e.rest.resources;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/user")
public class UserComponentHandler {
	
	@GET
	@Path("/{id}")
	public Response getUserById() {
		String user = "Peter Knerz";
		
		//TODO: API doku lesen jersey, wie kann man JSON daten zurückgeben?
		
		//TODO: wie kann man java (POJO) als JSON zurückgeben... 
		
		return Response.status(200).entity(user).build();
	}
	
}
