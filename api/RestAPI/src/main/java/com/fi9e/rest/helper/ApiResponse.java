package com.fi9e.rest.helper;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * API Response "interface" that provides us a consistent way of
 * responding to our clients.
 * 
 * @author Christopher
 *
 */
public class ApiResponse {
	static final int HTTP_ERROR = 422;
	
	public ApiResponse() {
		//
	}
	
	/**
	 * Send Success Messages 
	 * 
	 * @param obj | data to send
	 * @param messages | messages for user
	 * @return 
	 */
	public Response success(Object obj, String... messages) {
		return Response.ok(this.makeResponse(obj, messages), MediaType.APPLICATION_JSON).build();
	}
	
	/**
	 * Send Error Messages
	 * 
	 * @param obj | data to send
	 * @param messages | messages for user
	 * @return
	 */
	public Response error(Object obj, String... messages) {
		return Response.status(HTTP_ERROR).entity( this.makeResponse(obj, messages)).build();
	}
	
	/**
	 * Base Response
	 * 
	 * @param obj
	 * @param messages
	 * @return
	 */
	private ApiResponseObject makeResponse(Object obj, String... messages) {
		ApiResponseObject response = new ApiResponseObject();
		response.data = obj;
		response.message =  messages.length > 0 ? messages : new String[0];
		
		return response;
	}
}
