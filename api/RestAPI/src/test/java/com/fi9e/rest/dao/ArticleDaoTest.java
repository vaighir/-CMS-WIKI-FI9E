package com.fi9e.rest.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fi9e.rest.entity.Article;

import static org.junit.Assert.*;
import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.*;

class ArticleDaoTest {

//	private static SessionFactory sessionFactory;
//	private Session session;
//	
//	@BeforeAll
//	public static void setup() {
//		sessionFactory = new Configuration().configure().buildSessionFactory();
//		System.out.println("SessionFactory created");
//	}
//
//	@AfterAll
//	public static void tearDown() {
//		if (sessionFactory != null) sessionFactory.close();
//		System.out.println("SessionFactory destroyed");
//	}
//
//	@BeforeEach
//	public void openSession() {
//		session = sessionFactory.openSession();
//		System.out.println("Session created");
//	}
//	
//	@AfterEach
//	public void closeSession() {
//		if (session != null) session.close();
//		System.out.println("Session closed\n");
//	}			

/*		@Test
		public void testGetArticleById() {
			fail("Not yet implemented");
		}*/

		@Test
		public void testCreateArticleStringStringStringInt() {
			System.out.println("Running testCreateArticleStringStringStringInt...");
			
			//session.beginTransaction();
			
			ArticleDao articleDao = new ArticleDao();
			
			System.out.println("article Dao created");
			
			Integer id = 0;
			
			id = articleDao.createArticle("titleż", "sluggyö", "lots of content", 2);
			
			System.out.println("id = " + id);
			
			Assertions.assertTrue(id != 0);
		}

/*		@Test
		public void testCreateArticleArticleDTO() {
			fail("Not yet implemented");
		}

		@Test
		public void testUpdateArticle() {
			fail("Not yet implemented");
		}

		@Test
		public void testDeleteArticleById() {
			fail("Not yet implemented");
		}

		@Test
		public void testGetAllArticles() {
			fail("Not yet implemented");
		}

		@Test
		public void testGetAllArticlesByCategoryId() {
			fail("Not yet implemented");
		}*/

	}

	
	


