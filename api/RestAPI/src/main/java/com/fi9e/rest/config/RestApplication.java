package com.fi9e.rest.config;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import com.fi9e.rest.exceptions.ApiExceptionHandler;
import com.fi9e.rest.resources.AuthenticationHandler;

/**
 * Main configuration class for Jersey Application
 * 
 * Registers all needed filters, resources etc for the API 
 *  
 * @author Christopher
 */
public class RestApplication extends ResourceConfig {
	public RestApplication() {
		//add CORSFilters for server side CORS handling
		register(CORSFilter.class);
		
		//add jackson POJO mapping feature
		register(JacksonFeature.class);
		
		//register all resources from this package
		packages("com.fi9e.rest.resources");
		
		//register auth filter for jwt based login
		//register(AuthenticationFilter.class);
		
		//register custom exception mapper
		//register(ApiExceptionHandler.class);
	}
}
