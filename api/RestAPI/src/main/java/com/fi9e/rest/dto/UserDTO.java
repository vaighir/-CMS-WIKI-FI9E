package com.fi9e.rest.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Wiktor
 *
 */
@XmlRootElement
public class UserDTO  {
	private int id = 0;
	private String email;
	private String name;
	private String password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public RoleDTO getRole() {
		return role;
	}

	public void setRole(RoleDTO role) {
		this.role = role;
	}
	
}
