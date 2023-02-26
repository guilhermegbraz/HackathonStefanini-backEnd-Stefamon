package com.stefanini.core.casosDeUso.listarJogadores;

import com.stefanini.core.casosDeUso.parsers.JogadorToJogadorViewDto;
import com.stefanini.core.casosDeUso.viewJogador.JogadorViewDto;
import com.stefanini.core.repositorios.JogadorRepository;

import java.util.List;

public class ListarJogadores {
    private final JogadorRepository jogadorRepository;
    private final JogadorToJogadorViewDto jogadorToJogadorViewDto;

    public ListarJogadores(JogadorRepository jogadorRepository, JogadorToJogadorViewDto jogadorToJogadorViewDto) {
        this.jogadorRepository = jogadorRepository;
        this.jogadorToJogadorViewDto = jogadorToJogadorViewDto;
    }

    public List<JogadorViewDto> execute() {

        return this.jogadorToJogadorViewDto.execute(this.jogadorRepository.listarJogadores()) ;
    }
}
