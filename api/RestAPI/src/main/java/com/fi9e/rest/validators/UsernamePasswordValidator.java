package com.fi9e.rest.validators;


import javax.enterprise.context.ApplicationScoped;

import com.fi9e.rest.entity.User;

/**
 * Validator class: validates some user input.
 * 
 * NOTE: REFACTOR NOTICE. ALL CLASSES could be easily refactored by using javas Jersey Dep. Injection tools.
 * This way we would not need to write extra code for object creation etc. 
 * 
 * @author Christopher
 */

@ApplicationScoped
public class UsernamePasswordValidator {

	public User validateCredentials(String email, String password) {
		//User user = 
		
		
		
		return null;
	}
	
}
