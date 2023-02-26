package com.stefanini.core.casosDeUso.criarJogador.validacoes;

import com.stefanini.core.entidades.Jogador;
import com.stefanini.core.exceptions.RegraDeNegocioException;

public class ValidadorNicknameObrigatorio implements  ValidacoesCriacao{
    @Override
    public void validar(Jogador jogador) {
        if(jogador.getNickname() == null || jogador.getNickname().trim().length() == 0)
            throw new RegraDeNegocioException("O atributo Nickname é obrigatório");
    }
}
