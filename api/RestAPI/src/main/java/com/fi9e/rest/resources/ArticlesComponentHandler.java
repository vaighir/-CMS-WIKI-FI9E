package com.fi9e.rest.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fi9e.rest.dto.ArticleDTO;
import com.fi9e.rest.exceptions.ApiException;
import com.fi9e.rest.helper.ApiResponse;
import com.fi9e.rest.managers.ArticleManager;


@Path("/article")
/**
 * API Resource class:
 *  
 *  This declares all endpoints for articles that we need
 * 
 * @author Christopher
 */
public class ArticlesComponentHandler {
	private ArticleManager mngr;
	private ApiResponse api;
	
	
	public ArticlesComponentHandler() {
		this.getApiResponse();
	}
	
	ArticleManager getManager() {
		if(this.mngr == null) {
			this.mngr = new ArticleManager();
		}
		
		return mngr;
	}
	
	ApiResponse getApiResponse() {
		if(this.api == null) {
			this.api = new ApiResponse();
		}
		
		return this.api;
	}
	
	ArticleDTO articleDTO;
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response store(ArticleDTO article) throws ApiException {
		
		if(article.getName().isEmpty()) {
			this.api.error(article, "Subject required");
		}
		
		articleDTO = this.getManager().createArticle(article);
		
		return Response.ok(articleDTO, MediaType.APPLICATION_JSON).build();
	}

	// show single article
	@GET
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response show(@PathParam("id") String id) throws ApiException {
		
		articleDTO = this.getManager().getArticleById(id);
		
		return Response.ok(articleDTO, MediaType.APPLICATION_JSON).build();
	}

	@DELETE
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("id") String id) throws ApiException {

		if(this.getManager().deleteArticleById(id)) {
			return this.api.success(null, "Article removed");
		} else {
			return this.api.error(null, "Can not remove article");
		}
	}

	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(ArticleDTO articleDTO) throws ApiException {

		articleDTO = this.getManager().updateArticle(articleDTO);

		return Response.ok(articleDTO, MediaType.APPLICATION_JSON).build();
	}

	
	@GET
	@Path("/all")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response all() throws ApiException {
		
		List<ArticleDTO> dtoList = this.getManager().getAllArticles();

		return Response.ok(dtoList, MediaType.APPLICATION_JSON).build();
	}

	@GET
	@Path("/category/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response allCategory(@PathParam("id") int id) throws ApiException {
		
		List<ArticleDTO> dtoList = this.getManager().getAllArticlesByCategoryId( id );

		return Response.ok(dtoList, MediaType.APPLICATION_JSON).build();
	}
}
