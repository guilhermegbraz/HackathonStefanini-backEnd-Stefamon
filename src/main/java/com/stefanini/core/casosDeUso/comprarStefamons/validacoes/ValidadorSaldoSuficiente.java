package com.stefanini.core.casosDeUso.comprarStefamons.validacoes;

import com.stefanini.core.casosDeUso.calcularPrecoStefamon.CalculaPrecoStefamon;
import com.stefanini.core.entidades.CompraDeStefamon;
import com.stefanini.core.entidades.Jogador;
import com.stefanini.core.entidades.Stefamon;
import com.stefanini.core.exceptions.RegraDeNegocioException;
import com.stefanini.core.repositorios.JogadorRepository;
import com.stefanini.core.repositorios.StefamonRepository;

public class ValidadorSaldoSuficiente implements ValidacoesCompra{

    private final CalculaPrecoStefamon calculaPrecoStefamon;
    private final JogadorRepository jogadorRepository;
    private final StefamonRepository stefamonRepository;

    public ValidadorSaldoSuficiente(CalculaPrecoStefamon calculaPrecoStefamon, JogadorRepository jogadorRepository, StefamonRepository stefamonRepository) {
        this.calculaPrecoStefamon = calculaPrecoStefamon;
        this.jogadorRepository = jogadorRepository;
        this.stefamonRepository = stefamonRepository;
    }

    @Override
    public void execute(CompraDeStefamon compraDeStefamon) {
        Jogador jogador = this.jogadorRepository.pegarPorId(compraDeStefamon.getIdJogador());
        Stefamon stefamon = this.stefamonRepository.pegarStefamonPorId(compraDeStefamon.getIdStefamon());
        if(jogador.getSaldo().compareTo(this.calculaPrecoStefamon.execute(stefamon)) < 0)
            throw new RegraDeNegocioException("O jogador não tem saldo suficiente para realizar a compra");
    }
}
