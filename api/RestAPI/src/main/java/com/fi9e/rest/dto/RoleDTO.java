package com.fi9e.rest.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Wiktor
 *
 */
@XmlRootElement
public class RoleDTO  {
	private int id = 0;
	private String name;

	public RoleDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
