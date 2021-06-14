package com.fi9e.rest.config;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import com.fi9e.rest.exceptions.ApiExceptionHandler;
import com.fi9e.rest.filters.AuthorizationFilter;
import com.fi9e.rest.helper.ApiResponse;
import com.fi9e.rest.helper.ApiResponseInterface;
import com.fi9e.rest.services.TokenService;
import com.fi9e.rest.services.TokenServiceInterface;
import com.fi9e.rest.services.UserService;
import com.fi9e.rest.services.UserServiceInterface;


/**
 * Rest Api Bootstrap Class:
 * 
 * used to setup the API and needed features like Dep. Injection, Exception handling etc.
 * 
 * @author Christopher
 */
public class RestApplication extends ResourceConfig {
	public RestApplication() {
		//register all resources for this package | Endpoints
		packages("com.fi9e.rest.resources");
		//jackson JSON data mapping
		register(JacksonFeature.class);
		//cors filter
		register(CORSFilter.class);
		//auth filters for access control
		register(AuthorizationFilter.class);
		//custom exception handler for API
		register(ApiExceptionHandler.class);
		
		register(new AbstractBinder() {
            @Override
            protected void configure() {
            	//service provider binding | each interface gets binded to a particular service impl.
            	//this can be changed at any times with different service impl.
            	bind(ApiResponse.class).to(ApiResponseInterface.class);
            	bind(UserService.class).to(UserServiceInterface.class);
            	bind(TokenService.class).to(TokenServiceInterface.class);
            }
        });
	}
}
