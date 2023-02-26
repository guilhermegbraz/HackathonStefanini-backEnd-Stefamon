package com.stefanini.core.casosDeUso.parsers;

import com.stefanini.core.casosDeUso.viewJogador.JogadorViewDto;
import com.stefanini.core.entidades.Jogador;

import java.util.ArrayList;
import java.util.List;

public class JogadorToJogadorViewDto {
    public JogadorViewDto execute(Jogador jogador) {
        return new JogadorViewDto(jogador.getId(), jogador.getNickname(), jogador.getListaStefaMons(), jogador.getSaldo());
    }
    public List<JogadorViewDto> execute(List<Jogador> jogadores) {
        List<JogadorViewDto> viewJogadores = new ArrayList<>();
        jogadores.forEach(jogador -> viewJogadores.add(this.execute(jogador)));
        return viewJogadores;
    }
}
