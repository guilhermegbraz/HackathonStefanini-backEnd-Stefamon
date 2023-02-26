package com.stefanini.core.casosDeUso.criarJogador.validacoes;

import com.stefanini.core.entidades.Jogador;
import com.stefanini.core.exceptions.RegraDeNegocioException;
import com.stefanini.core.repositorios.JogadorRepository;

public class ValidadorNicknameUnico implements ValidacoesCriacao{
    private final JogadorRepository jogadorRepository;

    public ValidadorNicknameUnico(JogadorRepository jogadorRepository) {
        this.jogadorRepository = jogadorRepository;
    }

    @Override
    public void validar(Jogador jogador) {
        if(this.jogadorRepository.nicknameJaCadastrado(jogador.getNickname()))
            throw new RegraDeNegocioException("Nickname ja cadastrado");
    }
}
