package br.com.digisan.model.nfse;

import br.com.digisan.TipoPessoa;
import br.com.digisan.model.Endereco;
import com.google.gson.annotations.Expose;

public class Tomador {
    @Expose
    private String nome;

    @Expose
    private String cpfCnpj;

    @Expose
    private String codigoEstrangeiro;

    @Expose
    private String inscricaoEstadual;

    @Expose
    private String inscricaoMunicipal;

    @Expose
    private String telefone;

    @Expose
    private String email;

    @Expose
    private TipoPessoa tipoPessoa;

    @Expose
    private Endereco endereco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getCodigoEstrangeiro() {
        return codigoEstrangeiro;
    }

    public void setCodigoEstrangeiro(String codigoEstrangeiro) {
        this.codigoEstrangeiro = codigoEstrangeiro;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }

    public void setInscricaoMunicipal(String inscricaoMunicipal) {
        this.inscricaoMunicipal = inscricaoMunicipal;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

}
