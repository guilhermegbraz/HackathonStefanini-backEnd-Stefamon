package com.stefanini.dataproviders.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Jogador")
@Table(schema = "tb_jogador")
public class JogadorEntity {

    @Id
    @Column(name = "id_jogador")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nickname;

    @Column
    private String password;

    @Column
    private BigDecimal saldo;


    @ManyToMany
    @JoinTable(name = "Jogador_Stefamon",
            joinColumns = {@JoinColumn(name = "IdJogador")},
            inverseJoinColumns = {@JoinColumn(name = "IdStefamon")})
    private List<StefamonEntity> stefamons = new ArrayList<>();

    public JogadorEntity() {
    }

    public JogadorEntity(String nickname, String password, BigDecimal saldo, List<StefamonEntity> stefamons) {
        this.nickname = nickname;
        this.password = password;
        this.saldo = saldo;
        this.stefamons = stefamons;
    }

    public Long getId() {
        return this.id;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public List<StefamonEntity> getStefamons() {
        return stefamons;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
}
