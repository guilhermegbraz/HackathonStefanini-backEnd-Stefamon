package com.stefanini.core.casosDeUso.detalharUmJogador;

import com.stefanini.core.casosDeUso.parsers.JogadorToJogadorViewDto;
import com.stefanini.core.casosDeUso.viewJogador.JogadorViewDto;
import com.stefanini.core.entidades.Jogador;
import com.stefanini.core.exceptions.RegraDeNegocioException;
import com.stefanini.core.repositorios.JogadorRepository;

public class DetalharUmJogador {
    private final JogadorRepository jogadorRepository;
    private final JogadorToJogadorViewDto jogadorToJogadorViewDto;

    public DetalharUmJogador(JogadorRepository jogadorRepository, JogadorToJogadorViewDto jogadorToJogadorViewDto) {
        this.jogadorRepository = jogadorRepository;
        this.jogadorToJogadorViewDto = jogadorToJogadorViewDto;
    }

    public JogadorViewDto execute(Long id) {
        Jogador jogador = this.jogadorRepository.pegarPorId(id);
        if(jogador == null) throw new RegraDeNegocioException("Jogador não encontrado");
        return this.jogadorToJogadorViewDto.execute(jogador);
    }
}
