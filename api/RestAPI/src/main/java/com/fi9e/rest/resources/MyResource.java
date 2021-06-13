
package com.fi9e.rest.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.fi9e.rest.filters.Authorized;

/**
 *	ENDPOINT: API: EXAMPLE
 * 
 *  Base Endpoint to test API
 * 
 * @author Christopher
 *
 */
@Path("/test")
public class MyResource {
    
    /** Method processing HTTP GET requests, producing "text/plain" MIME media
     * type.
     * @return String that will be send back as a response of type "text/plain".
     */
    @GET 
    @Path("/hi")
    @Produces("text/plain")
    public String getIt() {
        return "Hi there!";
    }
    
    @GET 
    @Produces("text/plain")
    @Path("/auth")
    @Authorized
    public String authTest() {
        return "If you can see this, you are logged in!";
    }
}
