package com.fi9e.rest.resources;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import com.fi9e.auth.AuthenticationTokenService;
import com.fi9e.auth.TokenBasedSecurityContext;
import com.fi9e.models.AuthenticationToken;
import com.fi9e.models.AuthenticationTokenDetails;
import com.fi9e.models.UserCredentials;
import com.fi9e.rest.entity.User;
import com.fi9e.rest.exceptions.ApiException;
import com.fi9e.rest.validators.UsernamePasswordValidator;

/**
 * Provides authentication operations for clients.
 * 
 * This class is heavily inspired by cassiomolin.
 * {@linkplain https://github.com/cassiomolin/jersey-jwt}
 * 
 * @author Christopher
 */
public class AuthenticationHandler {
	
	@Context
	private SecurityContext securityContext;
	
	@Inject
	private UsernamePasswordValidator usernamePasswordValidator;
	
	@Inject
	private AuthenticationTokenService authenticationTokenService;
	
	@POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @PermitAll
    public Response authenticate(UserCredentials credentials) {

        User user = usernamePasswordValidator.validateCredentials(credentials.getUsername(), credentials.getPassword());
        String token = authenticationTokenService.issueToken(user.getUsername(), null);
        AuthenticationToken authenticationToken = new AuthenticationToken();
        authenticationToken.setToken(token);
        return Response.ok(authenticationToken).build();
    }

    /**
     * Refresh the authentication token for the current user.
     *
     * @return
     * @throws ApiException 
     */
    @POST
    @Path("refresh")
    @Produces(MediaType.APPLICATION_JSON)
    public Response refresh() throws ApiException {

        AuthenticationTokenDetails tokenDetails =
                ((TokenBasedSecurityContext) securityContext).getAuthenticationTokenDetails();
        String token = authenticationTokenService.refreshToken(tokenDetails);

        AuthenticationToken authenticationToken = new AuthenticationToken();
        authenticationToken.setToken(token);
        return Response.ok(authenticationToken).build();
    }
	
}
