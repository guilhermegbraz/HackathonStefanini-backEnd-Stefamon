package com.stefanini.entrypoint.resources;

import com.stefanini.core.casosDeUso.criarJogador.CriarJogador;
import com.stefanini.core.casosDeUso.deletarJogador.DeletarJogador;
import com.stefanini.core.casosDeUso.detalharUmJogador.DetalharUmJogador;
import com.stefanini.core.casosDeUso.listarJogadores.ListarJogadores;
import com.stefanini.core.casosDeUso.viewJogador.JogadorViewDto;
import com.stefanini.core.exceptions.RegraDeNegocioException;
import com.stefanini.dataproviders.entity.JogadorEntity;
import com.stefanini.dataproviders.repository.JPAJogadorRepository;
import com.stefanini.entrypoint.dto.CriarJogadorDto;
import com.stefanini.entrypoint.handlers.ConstraintViolationHandler;
import com.stefanini.entrypoint.handlers.RegraDeNegocioHandler;
import com.stefanini.entrypoint.parsers.CriarJogadorDtoToJogador;
import com.stefanini.service.JogadorService;

import javax.inject.Inject;
import javax.persistence.PersistenceException;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;

@Path("/jogador")
public class JogadorResource {
    @Inject
    CriarJogadorDtoToJogador criarJogadorDtoToJogador;
    @Inject
    JPAJogadorRepository jogadorRepository;
    @Inject
    RegraDeNegocioHandler regraDeNegocioHandler;
    @Inject
    ConstraintViolationHandler constraintViolationHandler;
// casos de uso:
    @Inject
    CriarJogador criarJogador;
    @Inject
    ListarJogadores listarJogadores;
    @Inject
    DetalharUmJogador detalharUmJogador;
    @Inject
    DeletarJogador deletarJogador;


    @POST
    public Response salvar( CriarJogadorDto jogador) {
        try{
            Long id = this.criarJogador.execute(this.criarJogadorDtoToJogador.execute(jogador));
            URI uri = UriBuilder.fromPath("/{id}").resolveTemplate("id", id).build();
            return Response.created(uri).status(Response.Status.CREATED).build();
        } catch (RegraDeNegocioException exception) {
            return this.regraDeNegocioHandler.toResponse(exception);
        } catch (PersistenceException exception) {
            return this.constraintViolationHandler.toResponse(exception);
        }
    }

    @GET
    @Path("/{id}")
    public Response pegarPorId(@PathParam("id") Long id){
        try{
            JogadorViewDto jogador = this.detalharUmJogador.execute(id);
            return Response.status(Response.Status.OK).entity(jogador).build();
        } catch (RegraDeNegocioException exception) {
            return this.regraDeNegocioHandler.toResponse(exception);
        }

    }

    @GET
    @Path("/todos")
    public Response listarTodos(){
        return Response.status(Response.Status.OK).entity(this.listarJogadores.execute()).build();
    }



    @PUT
    public Response alterar(@Valid JogadorEntity jogador) {
        jogadorRepository.update(jogador);
        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        try {
            this.deletarJogador.execute(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        }catch (RegraDeNegocioException exception) {
            return this.regraDeNegocioHandler.toResponse(exception);
        }
    }



}
