package com.fi9e.rest.daotests;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 
 * @author 
 *
 */
public class RestJdbc {

	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/test_db";
		String user = "sample_user";
		String pass = "sample_password";
		
		try {
			System.out.println("Connecting to database: " + jdbcUrl);
			
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("Connection successful!");
		}
		catch (Exception exc) {
		    exc.printStackTrace();
		}
		
	}

}
