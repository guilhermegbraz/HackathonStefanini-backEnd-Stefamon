package com.stefanini.core.casosDeUso.login;

import com.stefanini.core.casosDeUso.criptografarSenha.Criptografador;
import com.stefanini.core.casosDeUso.parsers.JogadorToJogadorViewDto;
import com.stefanini.core.casosDeUso.viewJogador.JogadorViewDto;
import com.stefanini.core.entidades.Jogador;
import com.stefanini.core.exceptions.RegraDeNegocioException;
import com.stefanini.core.repositorios.JogadorRepository;

public class LoginJogador {
    private final JogadorRepository jogadorRepository;
    private final Criptografador criptografador;
    private final JogadorToJogadorViewDto jogadorToJogadorViewDto;

    public LoginJogador(JogadorRepository jogadorRepository, Criptografador criptografador, JogadorToJogadorViewDto jogadorToJogadorViewDto) {
        this.jogadorRepository = jogadorRepository;
        this.criptografador = criptografador;
        this.jogadorToJogadorViewDto = jogadorToJogadorViewDto;
    }

    public JogadorViewDto usuarioCadastrado(LoginJogadorDto loginJogadorDto) {
        if (loginJogadorDto == null) throw new RegraDeNegocioException("Insira um nickname e senha");
        loginJogadorDto.setSenha(this.criptografador.execute(loginJogadorDto.getSenha()));
        try {
            Jogador jogador = this.jogadorRepository.jogadorCadastrado(loginJogadorDto);
            return this.jogadorToJogadorViewDto.execute(jogador);
        }catch (Exception exception) {
            throw new RegraDeNegocioException("Jogador Não Cadastrado");
        }
    }
}
