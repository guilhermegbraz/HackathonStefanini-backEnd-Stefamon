package com.stefanini.entrypoint.dto;

import com.stefanini.core.entidades.StefaMon;

import java.util.List;

public class CriarJogadorDto {
    private String nickname;
    private String senha;
    private List<StefaMon> listaStefaMons;

    public String getNickname() {
        return nickname;
    }

    public String getSenha() {
        return senha;
    }

    public List<StefaMon> getListaStefaMons() {
        return listaStefaMons;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setListaStefaMons(List<StefaMon> listaStefaMons) {
        this.listaStefaMons = listaStefaMons;
    }
}
