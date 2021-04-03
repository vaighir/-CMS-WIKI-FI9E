package com.fi9e.rest.config;

import org.glassfish.jersey.server.ResourceConfig;

public class RestApplication extends ResourceConfig {
	public RestApplication() {
		initResources();
	}
	
	
	public void initResources() {
		packages("com.fi9e.rest.resources");
		ClassLoader cl = getClass().getClassLoader();
		cl.getParent();
	}
}
