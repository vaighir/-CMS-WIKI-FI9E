package com.fi9e.rest.config;
import javax.annotation.Priority;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;

import com.fi9e.auth.AuthenticatedUserDetails;
import com.fi9e.auth.AuthenticationTokenDetails;
import com.fi9e.auth.AuthenticationTokenService;
import com.fi9e.auth.TokenBasedSecurityContext;
import com.fi9e.rest.entity.User;
import com.fi9e.rest.exceptions.ApiException;
import com.fi9e.rest.managers.UserManager;

import java.io.IOException;

/**
 * JWT authentication filter.
 *
 * @author cassiomolin, christopher
 */
@Provider
@Dependent
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationFilter implements ContainerRequestFilter {

    @Inject
    private UserManager userService;

    @Inject
    private AuthenticationTokenService authenticationTokenService;

    @Override
    public void filter(ContainerRequestContext requestContext) {
        String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String authenticationToken = authorizationHeader.substring(7);
            try {
				handleTokenBasedAuthentication(authenticationToken, requestContext);
			} catch (Exception e) {
				e.printStackTrace();
			}
            return;
        }
    }
    
    /**
     * 
     * @param authenticationToken
     * @param requestContext
     * @throws Exception
     */
    private void handleTokenBasedAuthentication(String authenticationToken, ContainerRequestContext requestContext) throws Exception {

        AuthenticationTokenDetails authenticationTokenDetails = authenticationTokenService.parseToken(authenticationToken);
        User user = userService.findByUsernameOrEmail(authenticationTokenDetails.getUsername());
        AuthenticatedUserDetails authenticatedUserDetails = new AuthenticatedUserDetails(user.getUsername(), user.getAuthorities());
        
        boolean isSecure = requestContext.getSecurityContext().isSecure();
        SecurityContext securityContext = new TokenBasedSecurityContext(authenticatedUserDetails, authenticationTokenDetails, isSecure);
        requestContext.setSecurityContext(securityContext);
    }
}