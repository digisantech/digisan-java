package br.com.digisan.model;

import com.google.gson.annotations.SerializedName;

public enum IndicadorExigibilidade {
    @SerializedName("1")
    EXIGIVEL("1", "Exigível"),
    @SerializedName("2")
    NAO_INCIDENCIA("2", "Não incidência"),
    @SerializedName("3")
    ISENCAO("3", "Isenção"),
    @SerializedName("4")
    EXPORTACAO("4", "Exportação"),
    @SerializedName("5")
    IMUNIDADE("5", "Imunidade"),
    @SerializedName("6")
    EXIGIBILIDADE_SUSPENSA_POR_DECISAO_JUDICIAL("6", "Exigibilidade Suspensa por Decisão Judicial"),
    @SerializedName("7")
    EXIGIBILIDADE_SUSPENSA_POR_PROCESSO_ADMINISTRATIVO("7", "Exigibilidade Suspensa por Processo Administrativo");

    private String codigo;
    private String descricao;

    private IndicadorExigibilidade(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String serialize() {
        return codigo;
    }
}
