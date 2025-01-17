package com.stefanini.core.casosDeUso.comprarStefamons;

import com.stefanini.core.casosDeUso.calcularPrecoStefamon.CalculaPrecoStefamon;
import com.stefanini.core.casosDeUso.comprarStefamons.validacoes.ValidacoesCompra;
import com.stefanini.core.entidades.CompraDeStefamon;
import com.stefanini.core.entidades.Jogador;
import com.stefanini.core.entidades.Stefamon;
import com.stefanini.core.exceptions.RegraDeNegocioException;
import com.stefanini.core.repositorios.JogadorRepository;
import com.stefanini.core.repositorios.StefamonRepository;

import java.util.List;

public class ComprarStefamons {

    private final JogadorRepository jogadorRepository;
    private final StefamonRepository stefamonRepository;
    private final List<ValidacoesCompra> validacoesCompra;
    private final CalculaPrecoStefamon calculaPrecoStefamon;

    public ComprarStefamons(JogadorRepository jogadorRepository, StefamonRepository stefamonRepository, List<ValidacoesCompra> validacoesCompra, CalculaPrecoStefamon calculaPrecoStefamon) {
        this.jogadorRepository = jogadorRepository;
        this.stefamonRepository = stefamonRepository;
        this.validacoesCompra = validacoesCompra;
        this.calculaPrecoStefamon = calculaPrecoStefamon;
    }

    public void execute(CompraDeStefamon compraDeStefamon) {
        Jogador jogador = this.jogadorRepository.pegarPorId(compraDeStefamon.getIdJogador());
        Stefamon stefamon = this.stefamonRepository.pegarStefamonPorId(compraDeStefamon.getIdStefamon());
        if(jogador == null) throw new RegraDeNegocioException("Jogador não encontrado");
        if(stefamon == null) throw new RegraDeNegocioException("Stefamon não encontrado");

        this.validacoesCompra.forEach(validacao -> validacao.execute(compraDeStefamon));
        jogador.decrementarSaldo(this.calculaPrecoStefamon.execute(stefamon));
        jogador.addStefamon(stefamon);
        this.jogadorRepository.comprarStefamon(jogador, stefamon);
    }
}
