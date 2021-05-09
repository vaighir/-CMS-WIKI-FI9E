package com.fi9e.rest.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fi9e.rest.dao.ArticleDao;
import com.fi9e.rest.dto.ArticleDTO;
import com.fi9e.rest.entity.Article;
import com.fi9e.rest.exceptions.ApiException;

@Path("/article")
public class ArticlesComponentHandler {

	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response store(ArticleDTO article) throws ApiException {
		
		ArticleDao dao = new ArticleDao();
		int newArticleId = dao.createArticle(article);
		ArticleDTO articleDTO = new ArticleDTO();
		
		Article newArticle = dao.getArticleById(newArticleId);
		
		if(newArticle != null) {
			//map database Object to DTO (response object)...
			articleDTO.setContent(newArticle.getContent());
			articleDTO.setCreated_at(newArticle.getCreatedAt());
			articleDTO.setId(newArticle.getId());
			articleDTO.setName(newArticle.getName());
			articleDTO.setSlug(newArticle.getSlug());
		}
		
		return Response.ok(articleDTO, MediaType.APPLICATION_JSON).build();
	}
	
	//delete endpoint
	@POST
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(ArticleDTO article) throws ApiException {
		
		//delete logic here | use dao object for data manipulation
		
		return Response.ok("deleted article").build();
	}
	
	//update
	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(ArticleDTO article) throws ApiException {
		
		//check params, means if we have all data nec. for article createion
		
		//updatedArticle here with dao

		return Response.ok("").build();
	}
	
	//show single article
	@POST
	@Path("/show/id")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response show(ArticleDTO article) throws ApiException {
		
		//just retrieve 

		return Response.ok("").build();
	}
	
	

}
