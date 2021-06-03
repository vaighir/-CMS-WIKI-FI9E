package com.fi9e.rest.config;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

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
		
		//TODO: Add jwt request filters:
		
	}
}
