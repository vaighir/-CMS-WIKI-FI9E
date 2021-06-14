package com.fi9e.rest.exceptions;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import com.fi9e.rest.helper.ApiResponseInterface;

/**
 * 
 * @author Christopher
 * 
 */
public class ApiExceptionHandler implements ExceptionMapper<ApiException> {
	
	private final ApiResponseInterface api;
	
	/**
	 * Make us of Dep. Inj.
	 * @param api
	 */
	@Inject
	public ApiExceptionHandler(ApiResponseInterface api) {
		this.api = api;
	}
	
	/**
	 * Respond to every ApiException with proper API response structure 
	 */
	@Override
	public Response toResponse(ApiException exception) {
		return this.api.error(null, exception.getMessage());
	}

}
