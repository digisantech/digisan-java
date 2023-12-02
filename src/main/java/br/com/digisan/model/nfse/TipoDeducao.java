package br.com.digisan.model.nfse;

public enum TipoDeducao {
    SEM_DEDUCOES(0, "Sem deduções"),
    MATERIAIS(1, "Materiais"),
    SUBEMPREITADA_DE_MAO_DE_OBRA(2, "Subempreitada de Mão de Obra"),
    SERVICOS(3, "Serviços"),
    PRODUCAO_EXTERNA(4, "Produção Externa"),
    ALIMENTACAO_E_BEBIDAS(5, "Alimentação e Bebidas"),
    REEMBOLSO_DE_DESPESAS(6, "Reembolso de Despesas"),
    REPASSE_CONSORCIADO(7, "Repasse Consorciado"),
    REPASSE_PLANO_DE_SAUDE(8, "Repasse Plano de Saúde"),
    OUTRAS_DEDUCOES(99, "Outras deduções");

    private int codigo;

    private String descricao;

    private TipoDeducao(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }
}
