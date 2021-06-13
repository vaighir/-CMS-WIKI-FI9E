package com.fi9e.rest.entity;

import org.mindrot.jbcrypt.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "user")
/**
 * 
 * @author 
 *
 */
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	@Column(name = "role_id")
	private int roleId;

	@Column(name = "password")
	private String password;
	
	@Column(name = "token")
	private String token;

	public User() {
		
	}

	public User(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = BCrypt.hashpw(password, BCrypt.gensalt());
		this.setRoleId(2);//set default role id to 2 | which is creator
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = BCrypt.hashpw(password, BCrypt.gensalt());
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "User { id: " + id + "," + "name: " + name + "," + "email: " + email + "}";
	}

}
