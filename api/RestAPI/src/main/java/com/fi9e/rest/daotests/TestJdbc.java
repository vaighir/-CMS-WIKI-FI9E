package com.fi9e.rest.daotests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.fi9e.rest.dao.ArticleDao;
import com.fi9e.rest.dto.ArticleDTO;

public class TestJdbc {

	public static void main(String[] args) {
		try {
			ArticleDao dao = new ArticleDao();
			ArticleDTO dto = new ArticleDTO();
			dto.setContent("wadwd");
			dto.setName("wadwdwadwd wadw");
			
			dao.createArticle(dto);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void testDbConnection(String uri, String username, String pw) throws SQLException {
		System.out.println("Connecting to database :" + uri);
		Connection myConn = DriverManager.getConnection(uri, username, pw);

		System.out.println("Connection Successful...!");
	}

}