package com.stefanini.core.casosDeUso.criarJogador;

import com.stefanini.core.casosDeUso.criarJogador.validacoes.ValidacoesCriacao;
import com.stefanini.core.casosDeUso.criptografarSenha.Criptografador;
import com.stefanini.core.casosDeUso.criptografarSenha.CriptografarSenhaBase64;
import com.stefanini.core.entidades.Jogador;
import com.stefanini.core.repositorios.JogadorRepository;

import java.util.List;

public class CriarJogador {

    private final JogadorRepository jogadorRepository;
    private final List<ValidacoesCriacao> listaValidacoes;
    private final Criptografador criptografador;

    public CriarJogador(JogadorRepository jogadorRepository, List<ValidacoesCriacao> listaValidacoes, Criptografador criptografador) {
        this.jogadorRepository = jogadorRepository;
        this.listaValidacoes = listaValidacoes;
        this.criptografador = criptografador;
    }

    public Long execute(Jogador jogador) {
        this.listaValidacoes.forEach(validacao -> validacao.validar(jogador));
        jogador.setSenha(this.criptografador.execute(jogador.getSenha()));
        var id = this.jogadorRepository.cadastrarJogador(jogador);
        return id;
    }
}
