
package com.fi9e.rest.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.fi9e.rest.filters.Authorized;

/** Example resource class hosted at the URI path "/hi"
 */
@Path("/hi")
public class MyResource {
    
    /** Method processing HTTP GET requests, producing "text/plain" MIME media
     * type.
     * @return String that will be send back as a response of type "text/plain".
     */
    @GET 
    @Produces("text/plain")
    public String getIt() {
        return "Hi there!";
    }
    
    @GET
    @Path("/{name}")
    public Response getItHello(@PathParam("name") String name) {
    	String result = "Hello "+ name;
    	return Response.status(200).entity(result).build();
    }
}
