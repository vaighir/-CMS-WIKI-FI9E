package com.fi9e.rest.resources;

public class User {
	private int id;
    private String name;
    private String email;

    User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User { id: " + id
                + ", name: "+ name
                + ", email: " + email + " }";
    }
    
    
}
