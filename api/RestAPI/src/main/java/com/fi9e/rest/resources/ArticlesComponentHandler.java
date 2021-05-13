package com.fi9e.rest.resources;

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
import com.fi9e.rest.managers.ArticleManager;

@Path("/article")
public class ArticlesComponentHandler {
	private ArticleManager mngr;
	
	
	ArticleManager getManager() {
		if(this.mngr == null) {
			this.mngr = new ArticleManager();
		}
		
		return mngr;
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response store(ArticleDTO article) throws ApiException {
		
		ArticleDTO articleDTO = this.getManager().createArticle(article);
		
		return Response.ok(articleDTO, MediaType.APPLICATION_JSON).build();
	}

	// show single article
	@GET
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response show(@PathParam("id") String id) throws ApiException {
		
		ArticleDTO dto = this.getManager().getArticleById(id);
		
		return Response.ok(dto, MediaType.APPLICATION_JSON).build();
	}

	// delete endpoint
	@DELETE
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(ArticleDTO article) throws ApiException {

		// delete logic here | use dao object for data manipulation

		return Response.ok("deleted article").build();
	}

	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(ArticleDTO articleDTO) throws ApiException {

		ArticleDTO dto = this.getManager().updateArticle(articleDTO);

		return Response.ok(dto, MediaType.APPLICATION_JSON).build();
	}

}
