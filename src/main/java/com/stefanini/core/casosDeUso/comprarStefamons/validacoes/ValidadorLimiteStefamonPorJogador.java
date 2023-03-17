package com.stefanini.core.casosDeUso.comprarStefamons.validacoes;

import com.stefanini.core.entidades.CompraDeStefamon;
import com.stefanini.core.exceptions.RegraDeNegocioException;
import com.stefanini.core.repositorios.JogadorRepository;

public class ValidadorLimiteStefamonPorJogador implements ValidacoesCompra{
    private final JogadorRepository jogadorRepository;

    public ValidadorLimiteStefamonPorJogador(JogadorRepository jogadorRepository) {
        this.jogadorRepository = jogadorRepository;
    }

    @Override
    public void execute(CompraDeStefamon compraDeStefamon) {
        if(this.jogadorRepository.pegarPorId(compraDeStefamon.getIdJogador()).getListaStefaMons().size() > 6)
            throw new RegraDeNegocioException("O jogador não pode possuir mais de 6 stefamons");
    }
}
