package com.fi9e.rest.exceptions;

import java.io.Serializable;

/**
 * Custom Exception mapper.
 * 
 * Has to be implemented by Every Resource, so exceptions get mapped
 * to JSON and responsen to API calls are always JSONP responses
 * 
 * @author Christopher
 *
 */
public class ApiException extends Exception implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public ApiException() {
		super();
	}
	
	public ApiException(String msg) {
		super(msg);
	}
	
	public ApiException(String msg, Exception e) {
		super(msg, e);
	}
}
