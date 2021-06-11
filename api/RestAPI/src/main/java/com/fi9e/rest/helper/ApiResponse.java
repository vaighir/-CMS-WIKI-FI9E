package com.fi9e.rest.helper;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class ApiResponse {
	static final int HTTP_ERROR = 422;
	static final int HTTP_UNAUTHORIZED = 403;
	
	public ApiResponse() {
		//
	}
	
	/**
	 * @param obj | data to send
	 * @param messages | messages for user
	 * @return 
	 */
	public Response success(Object obj, String... messages) {
		return Response.ok(this.makeResponse(obj, messages), MediaType.APPLICATION_JSON).build();
	}
	
	/**
	 * 
	 * @param obj | data to send
	 * @param messages | messages for user
	 * @return
	 */
	public Response error(Object obj, String... messages) {
		return Response.status(HTTP_ERROR).entity( this.makeResponse(obj, messages)).build();
	}
	
	/**
	 * Send user unauthorized message
	 * 
	 * @return Response
	 */
	public Response unauthorized() {
		return Response.status(HTTP_UNAUTHORIZED).entity( this.makeResponse(null, "Unauthorized!")).build();
	}
	
	
	private ApiResponseObject makeResponse(Object obj, String... messages) {
		ApiResponseObject response = new ApiResponseObject();
		response.data = obj;
		response.message =  messages.length > 0 ? messages : new String[0];
		
		return response;
	}
}
