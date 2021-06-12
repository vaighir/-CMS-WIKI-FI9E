package com.fi9e.rest.config;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import com.fi9e.rest.filters.AuthorizationFilter;
import com.fi9e.rest.helper.ApiResponse;
import com.fi9e.rest.helper.ApiResponseInterface;


/**
 * Rest Api Bootstrap Class:
 * 
 * used to setup the API and configure Dep Inj. feature
 * 
 * @author Christopher
 */
public class RestApplication extends ResourceConfig {
	public RestApplication() {
		//register all resources for this package:
		packages("com.fi9e.rest.resources");
		register(JacksonFeature.class);
		register(CORSFilter.class);
		register(AuthorizationFilter.class);
		
		register(new AbstractBinder() {
            @Override
            protected void configure() {
            	bind(ApiResponse.class).to(ApiResponseInterface.class);
            }
        });
	}
}
