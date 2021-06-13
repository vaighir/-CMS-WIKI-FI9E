package com.fi9e.rest.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Wiktor, Chris
 *
 */
@XmlRootElement
public class UserDTO  {
	private int id = 0;
	private String email;
	private String username;
	private String password;
	private String token;
	private RoleDTO role;
	
	public UserDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	//this is the hashed password! from db
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	public RoleDTO getRole() {
		return role;
	}
	
	public void setRole(RoleDTO role) {
		this.role = role;
	}
	
}
