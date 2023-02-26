package com.stefanini.dataproviders.parsers;

import com.stefanini.core.entidades.Jogador;
import com.stefanini.dataproviders.entity.JogadorEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class JogadorEntityToJogador {
    @Inject
    StefamonEntityToStefamon stefamonEntityToStefamon;

    public Jogador execute(JogadorEntity jogador) {
        return new Jogador(jogador.getId(), jogador.getNickname(), jogador.getPassword(),
                stefamonEntityToStefamon.execute(jogador.getStefamons()),jogador.getSaldo());
    }
    public List<Jogador> execute(List<JogadorEntity> jogadoresEntity) {
        List<Jogador> jogadores = new ArrayList<>();
        jogadoresEntity.forEach(jogador -> jogadores.add(this.execute(jogador)));
        return jogadores;
    }

}
