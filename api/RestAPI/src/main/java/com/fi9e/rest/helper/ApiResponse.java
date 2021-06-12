package com.fi9e.rest.helper;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.JsonObject;


public class ApiResponse implements ApiResponseInterface {
	public static final int HTTP_ERROR = 422;
	public static final int HTTP_FORBIDDEN = 403;
	
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
	 * @throws JsonProcessingException 
	 */
	public Response unauthorized() throws JsonProcessingException {
		return Response.status(HTTP_FORBIDDEN).entity( this.makeJSON(null, "Unauthorized!").toString() ).build();
	}
	
	private JsonObject makeJSON(Object obj, String...messages) throws JsonProcessingException {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String data = ow.writeValueAsString(obj);
		
		JsonObject res = new JsonObject();
		res.addProperty("data", data);
		res.addProperty("message", String.join(",", messages));
		
		return res;
	}
	
	private ApiResponseObject makeResponse(Object obj, String... messages) {
		ApiResponseObject response = new ApiResponseObject();
		response.data = obj;
		response.message =  messages.length > 0 ? messages : new String[0];
		
		return response;
	}
}
