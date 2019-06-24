package it.prova.web.rest.resources;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import it.prova.dao.AutomobileDAOMock;
import it.prova.model.Automobile;

@Path("/automobile")
public class AutomobileResource {

	private static final Logger LOGGER = Logger.getLogger(AutomobileResource.class.getName());

	@Context
	HttpServletRequest request;

	private AutomobileDAOMock automobileDaoMock;

	public AutomobileResource() {
		automobileDaoMock = new AutomobileDAOMock();
	}

	@GET
	@Path("{id : \\d+}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAutomobile(@PathParam("id") Long id) {
		LOGGER.info("Verbo Http.........................." + request.getMethod());
		Automobile automobileDaCaricare = automobileDaoMock.findById(id);
		return Response.status(200).entity(automobileDaCaricare).build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertiNuovaAutomobile(Automobile automobileInput) {
		LOGGER.info("Verbo Http.........................." + request.getMethod());
		automobileDaoMock.insert(automobileInput);
		return Response.status(200).entity(automobileInput).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listAll() {
		LOGGER.info("Verbo Http.........................." + request.getMethod());
		List<Automobile> result = automobileDaoMock.findAll();
		return Response.status(200).entity(result).build();
	}

	@GET
	@Path("/search")
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchAutomobile(@QueryParam("marca") String marca, @QueryParam("modello") String modello) {
		LOGGER.info("Verbo Http.........................." + request.getMethod());
		List<Automobile> result = automobileDaoMock.findByFields(marca, modello);
		return Response.status(200).entity(result).build();
	}
	
	@DELETE
	@Path("{id : \\d+}")
	public Response deleteAutomobile(@PathParam("id") Long id) {
		LOGGER.info("Verbo Http.........................." + request.getMethod());
		if(automobileDaoMock.delete(id))
			return Response.status(200).entity("Rimossa Automobile con id: "+id).build();
		
		return Response.status(Response.Status.NOT_FOUND).entity("not found").build();
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Response aggiornaAutomobile(Automobile automobileInput) {
		LOGGER.info("Verbo Http.........................." + request.getMethod());
		Automobile result = automobileDaoMock.update(automobileInput);
		return Response.status(200).entity(result).build();
	}

}
