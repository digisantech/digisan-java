package br.com.digisan.model.nfse;

import com.google.gson.annotations.SerializedName;

public enum CodigoCancelamento {

    ERRO_NA_EMISSAO(1),
    SERVICO_NAO_PRESTADO(2),
    ERRO_DE_ASSINATURA(3),
    DUPLICIDADE_DA_NOTA(4),
    ERRO_DE_PROCESSAMENTO(5);

    private Integer codigo;

    CodigoCancelamento(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }
}
