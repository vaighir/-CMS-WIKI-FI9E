package com.fi9e.rest.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import com.fi9e.rest.helper.ApiResponse;

/**
 * Custom Exception mapper that streamlines error responses to our needs 
 * @author Christopher
 */
public class ApiExceptionHandler implements ExceptionMapper<ApiException> {

	@Override
	public Response toResponse(ApiException exception) {
		ApiResponse api = new ApiResponse();
		
		return api.error(null, exception.getMessage());
	}

}
