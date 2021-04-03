package REST;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * Handler Class:
 * - defines Resource URI for API
 * @author FEY
 */

@Path("/user")
public class UserComponentHandler {
    public static final String CLICHED_MESSAGE = "Get User with ID: ";

    @GET
    @Path("/{id}")
    public Response getUser(@PathParam("id") int id) {
    	String result = CLICHED_MESSAGE + id;
        return Response.status(200).entity(result).build();
    }

}