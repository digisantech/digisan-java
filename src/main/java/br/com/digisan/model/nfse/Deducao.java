package br.com.digisan.model.nfse;

import java.math.BigDecimal;

public class Deducao {
    private BigDecimal valor;
    private TipoDeducao tipo;

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public TipoDeducao getTipo() {
        return tipo;
    }

    public void setTipo(TipoDeducao tipo) {
        this.tipo = tipo;
    }
}
