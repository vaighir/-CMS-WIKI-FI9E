package server.config;

import org.glassfish.jersey.server.ResourceConfig;

public class RestApplication extends ResourceConfig {
		
	public RestApplication() {
		packages("REST.UserComponentHandler");
	}
}
