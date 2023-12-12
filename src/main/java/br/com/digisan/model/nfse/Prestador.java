package br.com.digisan.model.nfse;

import com.google.gson.annotations.Expose;

public class Prestador {
    @Expose
    public String cnpj;

    public Prestador(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }
}
