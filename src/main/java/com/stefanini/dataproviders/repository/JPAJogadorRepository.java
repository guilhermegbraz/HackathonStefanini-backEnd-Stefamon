package com.stefanini.dataproviders.repository;

import com.stefanini.core.entidades.Jogador;
import com.stefanini.dataproviders.dao.GenericDAO;

import com.stefanini.dataproviders.entity.JogadorEntity;
import com.stefanini.dataproviders.parsers.JogadorEntityToJogador;
import com.stefanini.dataproviders.parsers.JogadorToJogadorEntity;
import com.stefanini.dataproviders.parsers.StefamonEntityToStefamon;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class JPAJogadorRepository extends GenericDAO<JogadorEntity, Long> implements com.stefanini.core.repositorios.JogadorRepository {
    @Inject
    JogadorToJogadorEntity jogadorToJogadorEntity;
    @Inject
    JogadorEntityToJogador jogadorEntityToJogador;

    @Override
    public Long cadastrarJogador(Jogador jogador) {
        JogadorEntity novoJogador = this.jogadorToJogadorEntity.execute(jogador);
        this.save(novoJogador);
        return novoJogador.getId();
    }

    @Override
    public boolean nicknameJaCadastrado(String nickname) {
        TypedQuery<Long> query = this.getEntityManager().createQuery("SELECT COUNT(j) FROM Jogador j WHERE j.nickname = :nickname", Long.class);
        query.setParameter("nickname", nickname);
        Long count = query.getSingleResult();
        System.out.println(count);
        return count > 0;
    }

    @Override
    public List<Jogador> listarJogadores() {
        List<JogadorEntity> jogadoresEntity = this.listAll();

        return this.jogadorEntityToJogador.execute((jogadoresEntity));
    }

    @Override
    public Jogador pegarPorId(Long id) {
        JogadorEntity jogadorEntity = this.findById(id);
        if(jogadorEntity == null) return null;
        return this.jogadorEntityToJogador.execute(jogadorEntity);
    }
}
