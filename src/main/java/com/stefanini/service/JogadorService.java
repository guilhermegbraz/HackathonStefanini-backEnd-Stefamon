package com.stefanini.service;

import com.stefanini.dataproviders.entity.JogadorEntity;
import com.stefanini.core.exceptions.RegraDeNegocioException;
import com.stefanini.dataproviders.repository.JogadorRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Objects;

@ApplicationScoped
public class JogadorService {

    @Inject
    JogadorRepository jogadorRepository;

    public void salvar(JogadorEntity jogador) {
        jogadorRepository.save(jogador);
    }

    public JogadorEntity pegarPorId(Long id) {
        var jogador = jogadorRepository.findById(id);
        if(Objects.isNull(jogador)) {
            throw new RegraDeNegocioException("Ocorreu um erro ao buscar o Jogador de id " + id, Response.Status.NOT_FOUND);
        }
        return jogador;
    }

    public void alterar(JogadorEntity jogador) {
        jogadorRepository.update(jogador);
    }

    public void deletar(Long id) {
        jogadorRepository.delete(id);
    }

    public List<JogadorEntity> listarTodos() {
        return jogadorRepository.listAll();
    }
}
