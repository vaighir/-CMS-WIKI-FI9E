package com.fi9e.rest.helper;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.JsonObject;


/**
 * Proper API response interface. This class is used to provide a consistent 
 * response to clients.
 * 
 * @author Christopher
 *
 */
public class ApiResponse implements ApiResponseInterface {
	public static final int HTTP_ERROR = 422;
	public static final int HTTP_FORBIDDEN = 403;
	
	public ApiResponse() {
		//
	}
	
	/**
	 * Simple Success Response
	 * 
	 * @param obj | data to send
	 * @param messages | messages for user
	 * @return Response
	 */
	public Response success(Object obj, String... messages) {
		return Response.ok(this.makeResponse(obj, messages), MediaType.APPLICATION_JSON).build();
	}
	
	/**
	 * Simple Error Response
	 * 
	 * @param obj | data to send
	 * @param messages | messages for user
	 * @return Response
	 */
	public Response error(Object obj, String... messages) {
		return Response.status(HTTP_ERROR).entity( this.makeResponse(obj, messages)).build();
	}
	
	/**
	 * Simple Unauthorized Response
	 * 
	 * @return Response
	 * @throws JsonProcessingException Throws exception if JSON object can´t be created.
	 */
	public Response unauthorized() throws JsonProcessingException {
		return Response.status(HTTP_FORBIDDEN).entity( this.makeJSON(null, "Unauthorized!").toString() ).build();
	}
	
	/**
	 * Make JSON Response Object. Uses default Response Structure like in {@link ApiResponseObject}
	 * 
	 * @param obj the entity to send to the client
	 * @param messages the response message to the client
	 * @return JsonObject 
	 * @throws JsonProcessingException if the object can´t be created
	 */
	private JsonObject makeJSON(Object obj, String...messages) throws JsonProcessingException {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String data = ow.writeValueAsString(obj);
		
		JsonObject res = new JsonObject();
		res.addProperty("data", data);
		res.addProperty("message", String.join(",", messages));
		
		return res;
	}
	
	/**
	 * Make Response Object {@link ApiResponseObject}
	 * 
	 * @param obj the entity to send to the client
	 * @param messages the messages to send to the client
	 * @return {@link ApiResponseObject}
	 */
	private ApiResponseObject makeResponse(Object obj, String... messages) {
		ApiResponseObject response = new ApiResponseObject();
		response.data = obj;
		response.message =  messages.length > 0 ? messages : new String[0];
		
		return response;
	}
}
