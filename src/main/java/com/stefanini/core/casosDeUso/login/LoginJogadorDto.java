package com.stefanini.core.casosDeUso.login;

public class LoginJogadorDto {
    private String nickname;
    private String senha;

    public String getNickname() {
        return nickname;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
