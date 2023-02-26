package com.stefanini.core.casosDeUso.deletarJogador;

import com.stefanini.core.exceptions.RegraDeNegocioException;
import com.stefanini.core.repositorios.JogadorRepository;

public class DeletarJogador {
    public DeletarJogador(JogadorRepository jogadorRepository) {
        this.jogadorRepository = jogadorRepository;
    }

    private final JogadorRepository jogadorRepository;

    public void execute(Long id) {
        try{
            this.jogadorRepository.deletar(id);
        } catch (Exception exception) {
            throw new RegraDeNegocioException("Jogador Não encontrado");
        }
    }
}
