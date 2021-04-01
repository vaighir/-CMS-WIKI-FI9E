package com.test1.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.test1.hibernate.entity.RealMessage;

public class CreateRealMessageDemo {

	public static void main(String[] args) {
		
		// create session factory
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(RealMessage.class)
				.buildSessionFactory();
		
		// create session 

		Session session = factory.getCurrentSession();
		
		try {
			// use the session object to save Java object
			
			
			// create a real message object
			System.out.println("Creating a new RealMessage object");
			RealMessage tempRealMessage = new RealMessage("hey", "user3", "test", "network"); 
			
			// start a transaction
			session.beginTransaction();
			
			// save the RealMessage object
			System.out.println("Saving the RealMessage into the database...");
			session.save(tempRealMessage);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		    // Code for UPDATE:
			
			// find out the id (primary key) of the RealMessage
			System.out.println("Saved RealMessage. Generated id: " + tempRealMessage.getId());
			
			// not get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve RealMessage based on the id: primary key
			System.out.println("\nGetting student with id: " + tempRealMessage.getId());
			
			RealMessage myRealMessage = session.get(RealMessage.class, tempRealMessage.getId());
			
			System.out.println("Get complete: " + myRealMessage);
			
			// commit the transaction
			session.getTransaction().commit();
		}
		
		finally {
			factory.close();
		}
		
	}

}
