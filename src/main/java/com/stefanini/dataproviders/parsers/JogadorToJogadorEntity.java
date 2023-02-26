package com.stefanini.dataproviders.parsers;

import com.stefanini.core.entidades.Jogador;
import com.stefanini.dataproviders.entity.JogadorEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class JogadorToJogadorEntity {
    @Inject
    private StefamonToStefamonEntity stefamonToStefamonEntity;

    public JogadorEntity execute(Jogador jogador) {
        return new JogadorEntity(jogador.getNickname(), jogador.getSenha(), jogador.getSaldo(),
                this.stefamonToStefamonEntity.execute(jogador.getListaStefaMons()));
    }
}
