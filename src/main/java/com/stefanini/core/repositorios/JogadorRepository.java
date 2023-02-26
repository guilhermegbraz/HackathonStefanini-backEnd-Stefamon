package com.stefanini.core.repositorios;

import com.stefanini.core.entidades.Jogador;

import java.util.List;

public interface JogadorRepository {
    Long cadastrarJogador(Jogador jogador);
    boolean nicknameJaCadastrado(String nickname);
    List<Jogador> listarJogadores();
    Jogador pegarPorId(Long id);

    void deletar(Long id);
}
