package com.stefanini.configurations;

import com.stefanini.core.casosDeUso.calcularPrecoStefamon.CalculaPrecoStefamon;
import com.stefanini.core.casosDeUso.comprarStefamons.ComprarStefamons;
import com.stefanini.core.casosDeUso.comprarStefamons.validacoes.ValidacoesCompra;
import com.stefanini.core.casosDeUso.comprarStefamons.validacoes.ValidadorLimiteStefamonPorJogador;
import com.stefanini.core.casosDeUso.comprarStefamons.validacoes.ValidadorSaldoSuficiente;
import com.stefanini.core.casosDeUso.criarJogador.CriarJogador;
import com.stefanini.core.casosDeUso.criarJogador.validacoes.*;
import com.stefanini.core.casosDeUso.criptografarSenha.Criptografador;
import com.stefanini.core.casosDeUso.criptografarSenha.CriptografarSenhaBase64;
import com.stefanini.core.casosDeUso.deletarJogador.DeletarJogador;
import com.stefanini.core.casosDeUso.detalharUmJogador.DetalharUmJogador;
import com.stefanini.core.casosDeUso.listarJogadores.ListarJogadores;
import com.stefanini.core.casosDeUso.login.LoginJogador;
import com.stefanini.core.casosDeUso.parsers.JogadorToJogadorViewDto;
import com.stefanini.core.repositorios.JogadorRepository;
import com.stefanini.core.repositorios.StefamonRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Produces;
import java.util.List;

public class ConfiguracaoCasosDeUso {

    @Produces
    @ApplicationScoped
    public CriarJogador criarJogador(JogadorRepository jogadorRepository, List<ValidacoesCriacao> validacoes,
                                     Criptografador criptografador) {
        return new CriarJogador(jogadorRepository, validacoes, criptografador);
    }

    @Produces
    @ApplicationScoped
    public Criptografador criptografador() {
        return new CriptografarSenhaBase64();
    }

    @Produces
    @ApplicationScoped
    public List<ValidacoesCriacao> validacoesCriacao(JogadorRepository jogadorRepository) {
        return List.of(new ValidadorNicknameObrigatorio(), new ValidadorNicknameUnico(jogadorRepository),
                new ValidadorSenhaObrigatoria(), new ValidadorTamanhoSenha());
    }

    @Produces
    @ApplicationScoped
    public ListarJogadores listarJogadores(JogadorRepository jogadorRepository) {
        return new ListarJogadores(jogadorRepository,new JogadorToJogadorViewDto());
    }

    @Produces
    @ApplicationScoped
    public DetalharUmJogador detalharUmJogador(JogadorRepository jogadorRepository) {
        return new DetalharUmJogador(jogadorRepository, new JogadorToJogadorViewDto());
    }

    @Produces
    @ApplicationScoped
    public DeletarJogador deletarJogador(JogadorRepository jogadorRepository) {
        return new DeletarJogador(jogadorRepository);
    }

    @Produces
    @ApplicationScoped
    public LoginJogador loginJogador(JogadorRepository jogadorRepository, Criptografador criptografador) {
        return new LoginJogador(jogadorRepository, criptografador, new JogadorToJogadorViewDto());
    }

    @Produces
    @ApplicationScoped
    public List<ValidacoesCompra> validacoesCompras(JogadorRepository jogadorRepository,
                                StefamonRepository stefamonRepository, CalculaPrecoStefamon calculaPrecoStefamon) {

        return List.of(new ValidadorSaldoSuficiente(calculaPrecoStefamon, jogadorRepository, stefamonRepository),
                new ValidadorLimiteStefamonPorJogador(jogadorRepository));
    }

    @Produces
    @ApplicationScoped
    public CalculaPrecoStefamon calculaPrecoStefamon() {
        return new CalculaPrecoStefamon();
    }

    @Produces
    @ApplicationScoped
    public ComprarStefamons comprarStefamons(JogadorRepository jogadorRepository,
                                             CalculaPrecoStefamon calculaPrecoStefamon,
                                             List<ValidacoesCompra> validacoesCompras,
                                             StefamonRepository stefamonRepository) {

        return new ComprarStefamons(jogadorRepository, stefamonRepository, validacoesCompras, calculaPrecoStefamon);
    }
}
