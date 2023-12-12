package br.com.digisan.model;

import com.google.gson.annotations.Expose;

public class Municipio {
    @Expose
    private String codigoIbge;
    @Expose
    private String nome;

    public String getCodigoIbge() {
        return codigoIbge;
    }

    public void setCodigoIbge(String codigoIbge) {
        this.codigoIbge = codigoIbge;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
