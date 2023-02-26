package com.stefanini.entrypoint.parsers;

import com.stefanini.core.entidades.Jogador;
import com.stefanini.entrypoint.dto.CriarJogadorDto;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;

@ApplicationScoped
public class CriarJogadorDtoToJogador {

    public Jogador execute(CriarJogadorDto jogadorDto) {
        return new Jogador(jogadorDto.getNickname(), jogadorDto.getSenha(),
                jogadorDto.getListaStefaMons()== null? new ArrayList<>(): jogadorDto.getListaStefaMons());
    }
}
