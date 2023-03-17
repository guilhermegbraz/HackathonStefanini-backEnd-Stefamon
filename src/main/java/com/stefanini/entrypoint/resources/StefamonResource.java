package com.stefanini.entrypoint.resources;

import com.stefanini.core.casosDeUso.comprarStefamons.ComprarStefamons;
import com.stefanini.core.entidades.CompraDeStefamon;
import com.stefanini.core.exceptions.RegraDeNegocioException;
import com.stefanini.core.service.StefamonService;
import com.stefanini.entrypoint.handlers.ConstraintViolationHandler;
import com.stefanini.entrypoint.handlers.RegraDeNegocioHandler;
import org.hibernate.exception.ConstraintViolationException;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/stefamon")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StefamonResource {

    @Inject
    StefamonService service;

    @Inject
    ComprarStefamons comprarStefamons;
    @Inject
    RegraDeNegocioHandler regraDeNegocioHandler;
    @Inject
    ConstraintViolationHandler constraintViolationHandler;

    @GET
    @Path("/todos")
    public Response listarTodos() {
       var listaStefamon =service.listarTodos();

       return Response.status(Response.Status.OK).entity(listaStefamon).build();
    }

    @GET
    @Path("/{id}")
    public Response pegarPorId(@PathParam("id") Long id) {
        return Response.status(Response.Status.OK).entity(service.pegarPorId(id)).build();
    }

    @POST
    @Path("comprar_stefamon")
    public Response compraDeStefamon(CompraDeStefamon compraDeStefamon) {
        try{
            this.comprarStefamons.execute(compraDeStefamon);
            return Response.status(Response.Status.OK).entity("Compra realizada").build();
        } catch (RegraDeNegocioException exception) {
            return this.regraDeNegocioHandler.toResponse(exception);
        } catch (ConstraintViolationException exception) {
            System.out.println(exception.getConstraintName() + " " + exception.getMessage());
            return this.constraintViolationHandler.toResponse(exception);
        }
    }

}
