package com.stefanini.core.entidades;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class Jogador {

    private Long id;
    private String nickname;

    private String senha;

    private List<Stefamon> listaStefamons;

    private BigDecimal saldo;

    public Jogador(String nickname, String senha, List<Stefamon> stefamons) {
        this.nickname = nickname;
        this.senha = senha;
        this.saldo = BigDecimal.valueOf(2300);
        this.listaStefamons = stefamons;
    }

    public Jogador(Long id, String nickname, String senha, List<Stefamon> listaStefamons, BigDecimal saldo) {
        this.id = id;
        this.nickname = nickname;
        this.senha = senha;
        this.saldo = saldo;
        this.listaStefamons = listaStefamons;
    }



    public String getNickname() {
        return nickname;
    }

    public String getSenha() {
        return senha;
    }

    public List<Stefamon> getListaStefaMons() {
        return Collections.unmodifiableList(listaStefamons);
    }

    public void addStefamon(Stefamon stefamon) {
        this.listaStefamons.add(stefamon);
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Long getId() {
        return this.id;
    }

    public void decrementarSaldo(BigDecimal decremento) {
        this.saldo = saldo.subtract(decremento);
    }
}
