package com.stefanini.core.casosDeUso.viewJogador;

import com.stefanini.core.entidades.Stefamon;

import java.math.BigDecimal;
import java.util.List;

public class JogadorViewDto {

    private Long id;
    private String nickname;
    private List<Stefamon> listaStefamons;
    private BigDecimal saldo;

    public JogadorViewDto(Long id, String nickname, List<Stefamon> listaStefamons, BigDecimal saldo) {
        this.id = id;
        this.nickname = nickname;
        this.listaStefamons = listaStefamons;
        this.saldo = saldo;
    }

    public Long getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public List<Stefamon> getListaStefaMons() {
        return listaStefamons;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }
}
