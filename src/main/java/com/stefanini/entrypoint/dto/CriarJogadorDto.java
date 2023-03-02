package com.stefanini.entrypoint.dto;

import com.stefanini.core.entidades.Stefamon;

import java.util.List;

public class CriarJogadorDto {
    private String nickname;
    private String senha;
    private List<Stefamon> listaStefamons;

    public String getNickname() {
        return nickname;
    }

    public String getSenha() {
        return senha;
    }

    public List<Stefamon> getListaStefaMons() {
        return listaStefamons;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setListaStefaMons(List<Stefamon> listaStefamons) {
        this.listaStefamons = listaStefamons;
    }
}
