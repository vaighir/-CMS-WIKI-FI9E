package com.fi9e.rest.config;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import com.fi9e.rest.filters.AuthorizationFilter;

/**
 * Configuration Class  
 * @author Christopher
 */
public class RestApplication extends ResourceConfig {
	public RestApplication() {
		//register all resources for this package:
		packages("com.fi9e.rest.resources");
		register(JacksonFeature.class);
		register(CORSFilter.class);
		
		register(AuthorizationFilter.class);
	}
}
