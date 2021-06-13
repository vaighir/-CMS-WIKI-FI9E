package com.fi9e.rest.helper;

import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * 
 * @author Christopher
 *
 */
public interface ApiResponseInterface {
	public Response success(Object obj, String... messages);
	public Response error(Object obj, String... messages);
	public Response unauthorized() throws JsonProcessingException;
}
