package com.stefanini.core.casosDeUso.criarJogador.validacoes;

import com.stefanini.core.entidades.Jogador;
import com.stefanini.core.exceptions.RegraDeNegocioException;

public class ValidadorSenhaObrigatoria implements ValidacoesCriacao{
    @Override
    public void validar(Jogador jogador) {
        if(jogador.getSenha() == null || jogador.getSenha().trim().length() == 0)
            throw new RegraDeNegocioException("O atributo senha é obrigatório");
    }
}
