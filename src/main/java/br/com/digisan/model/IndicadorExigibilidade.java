package br.com.digisan.model;

public enum IndicadorExigibilidade {
    EXIGIVEL("1", "Exigível"),
    NAO_INCIDENCIA("2", "Não incidência"),
    ISENCAO("3", "Isenção"),
    EXPORTACAO("4", "Exportação"),
    IMUNIDADE("5", "Imunidade"),
    EXIGIBILIDADE_SUSPENSA_POR_DECISAO_JUDICIAL("6", "Exigibilidade Suspensa por Decisão Judicial"),
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
}
