package com.fi9e.rest.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author 
 *
 */
@XmlRootElement
public class CategoryDTO  {
	private int id = 0;
	private String name;
	private String description;

	public CategoryDTO() {
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
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
