package com.stefanini.core.entidades;

public class Stefamon {
    private final Long id;
    private final String nome;
    private final Integer vida;
    private final Integer ataque;
    private final Integer defesa;
    private final Integer inteligencia;
    private final Integer poder;
    private final Integer velocidade;
    private final String urlFoto;

    public Stefamon(Long id, String nome, Integer vida, Integer ataque, Integer defesa, Integer inteligencia, Integer poder, Integer velocidade, String urlFoto) {
        this.id = id;
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.defesa = defesa;
        this.inteligencia = inteligencia;
        this.poder = poder;
        this.velocidade = velocidade;
        this.urlFoto = urlFoto;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Integer getVida() {
        return vida;
    }

    public Integer getAtaque() {
        return ataque;
    }

    public Integer getDefesa() {
        return defesa;
    }

    public Integer getInteligencia() {
        return inteligencia;
    }

    public Integer getPoder() {
        return poder;
    }

    public Integer getVelocidade() {
        return velocidade;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    @Override
    public String toString() {
        return "Stefamon{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", vida=" + vida +
                ", ataque=" + ataque +
                ", defesa=" + defesa +
                ", inteligencia=" + inteligencia +
                ", poder=" + poder +
                ", velocidade=" + velocidade +
                ", urlFoto='" + urlFoto + '\'' +
                '}';
    }
}
