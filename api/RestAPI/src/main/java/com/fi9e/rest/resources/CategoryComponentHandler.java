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

import com.fi9e.rest.dto.CategoryDTO;
import com.fi9e.rest.exceptions.ApiException;
import com.fi9e.rest.filters.Authorized;
import com.fi9e.rest.managers.CategoryManager;

/**
 * ENDPOINT: API: CATEGORIES
 * 
 * @author Christopher
 *
 */
@Path("/category")
public class CategoryComponentHandler {
	private CategoryManager mngr;
	
	
	CategoryManager getManager() {
		if(this.mngr == null) {
			this.mngr = new CategoryManager();
		}
		
		return mngr;
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Authorized
	public Response store(CategoryDTO category) throws ApiException {
		
		CategoryDTO categoryDTO = this.getManager().createCategory(category);
		
		return Response.ok(categoryDTO, MediaType.APPLICATION_JSON).build();
	}

	@GET
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response show(@PathParam("id") String id) throws ApiException {
		
		CategoryDTO dto = this.getManager().getCategoryById(id);
		
		return Response.ok(dto, MediaType.APPLICATION_JSON).build();
	}

	@DELETE
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Authorized
	public Response delete(CategoryDTO category) throws ApiException {

		// delete logic here | use dao object for data manipulation

		return Response.ok("deleted category").build();
	}

	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Authorized
	public Response update(CategoryDTO categoryDTO) throws ApiException {

		CategoryDTO dto = this.getManager().updateCategory(categoryDTO);

		return Response.ok(dto, MediaType.APPLICATION_JSON).build();
	}

	
	@GET
	@Path("/all")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response all() throws ApiException {
		
		List<CategoryDTO> dtoList = this.getManager().getAllCategories();

		return Response.ok(dtoList, MediaType.APPLICATION_JSON).build();
	}
}
