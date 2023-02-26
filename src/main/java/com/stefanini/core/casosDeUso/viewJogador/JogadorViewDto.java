package com.stefanini.core.casosDeUso.viewJogador;

import com.stefanini.core.entidades.StefaMon;

import java.math.BigDecimal;
import java.util.List;

public class JogadorViewDto {

    private Long id;
    private String nickname;
    private List<StefaMon> listaStefaMons;
    private BigDecimal saldo;

    public JogadorViewDto(Long id, String nickname, List<StefaMon> listaStefaMons, BigDecimal saldo) {
        this.id = id;
        this.nickname = nickname;
        this.listaStefaMons = listaStefaMons;
        this.saldo = saldo;
    }

    public Long getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public List<StefaMon> getListaStefaMons() {
        return listaStefaMons;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }
}
