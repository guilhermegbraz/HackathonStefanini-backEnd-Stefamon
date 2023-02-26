package com.stefanini.dataproviders.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Stefamon")
@Table(name = "tb_stefamon")
public class StefamonEntity {


    @Id
    @Column(name = "id")
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Integer vida;

    @Column(nullable = false)
    private Integer ataque;

    @Column(nullable = false)
    private Integer defesa;

    @Column(nullable = false)
    private Integer inteligencia;

    @Column(nullable = false)
    private Integer poder;

    @Column(nullable = false)
    private Integer velocidade;

    @Column(nullable = false)
    private String urlFoto;

    public StefamonEntity() {}

    public StefamonEntity(Long id, String nome, Integer vida, Integer ataque, Integer defesa, Integer inteligencia,
                          Integer poder, Integer velocidade, String urlFoto) {
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
        return "StefamonEntity{" +
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
