package com.stefanini.entrypoint.resources;

import com.stefanini.core.casosDeUso.login.LoginJogador;
import com.stefanini.core.casosDeUso.login.LoginJogadorDto;
import com.stefanini.core.exceptions.RegraDeNegocioException;
import com.stefanini.entrypoint.handlers.RegraDeNegocioHandler;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/login")
public class LoginResource {

    @Inject
    LoginJogador loginJogador;
    @Inject
    RegraDeNegocioHandler regraDeNegocioHandler;

    @POST
    @Path("/login")
    public Response login(LoginJogadorDto loginJogadorDto, HttpServletRequest request) {
        try{
            var jogador = this.loginJogador.usuarioCadastrado(loginJogadorDto);
            request.getSession().setAttribute("USER", jogador);

            return Response.ok(jogador).header("JSESSIONID", request.getSession().getId()).build();
        } catch (RegraDeNegocioException exception) {

            return this.regraDeNegocioHandler.toResponse(exception);
        }
    }
}
