package com.stefanini.core.casosDeUso.calcularPrecoStefamon;

import com.stefanini.core.entidades.Stefamon;

import java.math.BigDecimal;

public class CalculaPrecoStefamon {

    public BigDecimal execute(Stefamon stefamon) {
        BigDecimal preco = new BigDecimal((stefamon.getAtaque() + stefamon.getDefesa() + stefamon.getInteligencia() +
                stefamon.getVelocidade() + stefamon.getVida() + stefamon.getPoder())/6);

        return preco;
    }
}
