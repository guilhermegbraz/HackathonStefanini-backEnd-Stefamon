package com.stefanini.service;

import com.stefanini.dataproviders.entity.JogadorEntity;
import com.stefanini.core.exceptions.RegraDeNegocioException;
import com.stefanini.dataproviders.repository.JPAJogadorRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Objects;

@ApplicationScoped
public class JogadorService {

    @Inject
    JPAJogadorRepository JPAJogadorRepository;

    public void salvar(JogadorEntity jogador) {
        JPAJogadorRepository.save(jogador);
    }

    public JogadorEntity pegarPorId(Long id) {
        var jogador = JPAJogadorRepository.findById(id);
        if(Objects.isNull(jogador)) {
            throw new RegraDeNegocioException("Ocorreu um erro ao buscar o Jogador de id " + id, Response.Status.NOT_FOUND);
        }
        return jogador;
    }

    public void alterar(JogadorEntity jogador) {
        JPAJogadorRepository.update(jogador);
    }

    public void deletar(Long id) {
        JPAJogadorRepository.delete(id);
    }

    public List<JogadorEntity> listarTodos() {
        return JPAJogadorRepository.listAll();
    }
}
