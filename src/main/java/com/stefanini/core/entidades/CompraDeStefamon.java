package com.stefanini.core.entidades;

public class CompraDeStefamon {
    private Long idJogador;
    private Long idStefamon;

    public CompraDeStefamon(Long idJogador, Long idStefamon) {
        this.idJogador = idJogador;
        this.idStefamon = idStefamon;
    }

    public Long getIdJogador() {
        return idJogador;
    }

    public Long getIdStefamon() {
        return idStefamon;
    }
}
