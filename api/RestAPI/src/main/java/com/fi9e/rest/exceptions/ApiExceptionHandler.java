package com.fi9e.rest.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import com.fi9e.rest.helper.ApiResponse;

/**
 * 
 * @author Christopher
 *
 */
public class ApiExceptionHandler implements ExceptionMapper<ApiException> {
	
	private final ApiResponse api;
	
	public ApiExceptionHandler() {
		this.api = new ApiResponse();
	}
	
	@Override
	public Response toResponse(ApiException exception) {
		
		return this.api.error(null, exception.getMessage());
		//Response.status(ApiResponse.HTTP_ERROR).entity()
	}

}
