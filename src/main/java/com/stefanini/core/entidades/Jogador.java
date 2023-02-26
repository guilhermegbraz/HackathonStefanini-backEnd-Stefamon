package com.stefanini.core.entidades;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class Jogador {

    private Long id;
    private String nickname;

    private String senha;

    private List<StefaMon> listaStefaMons;

    private BigDecimal saldo;

    public Jogador(String nickname, String senha, List<StefaMon> stefaMons) {
        this.nickname = nickname;
        this.senha = senha;
        this.saldo = BigDecimal.valueOf(2300);
        this.listaStefaMons = stefaMons;
    }

    public Jogador(Long id, String nickname, String senha, List<StefaMon> listaStefaMons, BigDecimal saldo) {
        this.id = id;
        this.nickname = nickname;
        this.senha = senha;
        this.saldo = saldo;
        this.listaStefaMons = listaStefaMons;
    }



    public String getNickname() {
        return nickname;
    }

    public String getSenha() {
        return senha;
    }

    public List<StefaMon> getListaStefaMons() {
        return Collections.unmodifiableList(listaStefaMons);
    }

    public void addStefamon(StefaMon stefamon) {
        this.listaStefaMons.add(stefamon);
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
}
