package br.com.digisan.model.nfse;

import com.google.gson.annotations.Expose;

public class EnviarNfseResponse {

    @Expose
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
