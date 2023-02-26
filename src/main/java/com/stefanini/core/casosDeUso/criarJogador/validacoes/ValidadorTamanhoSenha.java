package com.stefanini.core.casosDeUso.criarJogador.validacoes;

import com.stefanini.core.entidades.Jogador;
import com.stefanini.core.exceptions.RegraDeNegocioException;

public class ValidadorTamanhoSenha implements ValidacoesCriacao{
    @Override
    public void validar(Jogador jogador) {
        if (jogador.getSenha().length() < 4 || jogador.getSenha().length() > 10)
            throw new RegraDeNegocioException("O atributo senha deve possuir entre 4 e 10 caracteres");
    }
}
