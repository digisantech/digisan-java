package br.com.digisan.model;

import java.io.Serializable;

public abstract class Model<ID extends Serializable> {
    private ID id;

    protected void validateId() {
        if (getId() == null) {
            throw new IllegalArgumentException("O ID do objeto deve ser informado.");
        }
    }

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }
}
