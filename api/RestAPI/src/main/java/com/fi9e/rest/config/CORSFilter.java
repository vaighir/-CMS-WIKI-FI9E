package com.fi9e.rest.config;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;

/**
 * Adds CORS settings and JSON headers to every request
 * @author Christopher
 *
 */
public class CORSFilter implements ContainerResponseFilter {

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {

		requestContext.getHeaders().add("Accept", "application/json");
		requestContext.getHeaders().add("Content-Type", "application/json");
		requestContext.getHeaders().add("Access-Control-Allow-Origin", "*");
		requestContext.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PATCH, PUT, DELETE, OPTIONS");
		requestContext.getHeaders().add("Access-Control-Allow-Headers", "Origin, Content-Type, X-Auth-Token");
	}

}
