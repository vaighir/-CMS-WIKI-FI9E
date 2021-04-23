package com.fi9e.rest.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fi9e.rest.dao.ArticleDao;
import com.fi9e.rest.dto.ArticleDTO;
import com.fi9e.rest.exceptions.ApiException;

@Path("/article")
public class ArticlesComponentHandler {

	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response store(ArticleDTO article) throws ApiException {
		
		ArticleDao dao = new ArticleDao();
		dao.createArticle(article);

		return Response.ok("created article").build();
	}

}
