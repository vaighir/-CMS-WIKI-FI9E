package com.fi9e.rest.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * 
 * @author Christopher
 *
 */
public class ApiExceptionHandler implements ExceptionMapper<ApiException> {

	@Override
	public Response toResponse(ApiException exception) {
		return Response.status(Status.BAD_REQUEST).entity(exception.getMessage()).build();
	}

}
