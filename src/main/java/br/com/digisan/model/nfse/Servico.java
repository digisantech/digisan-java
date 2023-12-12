package br.com.digisan.model.nfse;

import br.com.digisan.model.IndicadorExigibilidade;
import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class Servico {
    @Expose
    private String descricao;

    @Expose
    private String cnae;

    @Expose
    private String codigoMunicipio;

    @Expose
    private String codigoMunicipioIncidencia;

    @Expose
    private String itemListaServicoLC116;

    @Expose
    private String codigoTributacaoMunicipio;

    @Expose
    private IndicadorExigibilidade indicadorExigibilidade;

    @Expose
    private boolean issRetido;

    @Expose
    private BigDecimal valorServicos;

    @Expose
    private BigDecimal descontoCondicionado;

    @Expose
    private BigDecimal descontoIncondicionado;

    @Expose
    private BigDecimal aliquotaIss;

    @Expose
    private BigDecimal valorIss;

    @Expose
    private BigDecimal valorCofins;

    @Expose
    private BigDecimal valorCsll;

    @Expose
    private BigDecimal valorIr;

    @Expose
    private BigDecimal valorPis;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCnae() {
        return cnae;
    }

    public void setCnae(String cnae) {
        this.cnae = cnae;
    }

    public String getCodigoMunicipio() {
        return codigoMunicipio;
    }

    public void setCodigoMunicipio(String codigoMunicipio) {
        this.codigoMunicipio = codigoMunicipio;
    }

    public String getCodigoMunicipioIncidencia() {
        return codigoMunicipioIncidencia;
    }

    public void setCodigoMunicipioIncidencia(String codigoMunicipioIncidencia) {
        this.codigoMunicipioIncidencia = codigoMunicipioIncidencia;
    }

    public String getItemListaServicoLC116() {
        return itemListaServicoLC116;
    }

    public void setItemListaServicoLC116(String itemListaServicoLC116) {
        this.itemListaServicoLC116 = itemListaServicoLC116;
    }

    public String getCodigoTributacaoMunicipio() {
        return codigoTributacaoMunicipio;
    }

    public void setCodigoTributacaoMunicipio(String codigoTributacaoMunicipio) {
        this.codigoTributacaoMunicipio = codigoTributacaoMunicipio;
    }

    public IndicadorExigibilidade getIndicadorExigibilidade() {
        return indicadorExigibilidade;
    }

    public void setIndicadorExigibilidade(IndicadorExigibilidade indicadorExigibilidade) {
        this.indicadorExigibilidade = indicadorExigibilidade;
    }

    public boolean isIssRetido() {
        return issRetido;
    }

    public void setIssRetido(boolean issRetido) {
        this.issRetido = issRetido;
    }

    public BigDecimal getValorServicos() {
        return valorServicos;
    }

    public void setValorServicos(BigDecimal valorServicos) {
        this.valorServicos = valorServicos;
    }

    public BigDecimal getDescontoCondicionado() {
        return descontoCondicionado;
    }

    public void setDescontoCondicionado(BigDecimal descontoCondicionado) {
        this.descontoCondicionado = descontoCondicionado;
    }

    public BigDecimal getDescontoIncondicionado() {
        return descontoIncondicionado;
    }

    public void setDescontoIncondicionado(BigDecimal descontoIncondicionado) {
        this.descontoIncondicionado = descontoIncondicionado;
    }

    public BigDecimal getAliquotaIss() {
        return aliquotaIss;
    }

    public void setAliquotaIss(BigDecimal aliquotaIss) {
        this.aliquotaIss = aliquotaIss;
    }

    public BigDecimal getValorIss() {
        return valorIss;
    }

    public void setValorIss(BigDecimal valorIss) {
        this.valorIss = valorIss;
    }

    public BigDecimal getValorCofins() {
        return valorCofins;
    }

    public void setValorCofins(BigDecimal valorCofins) {
        this.valorCofins = valorCofins;
    }

    public BigDecimal getValorCsll() {
        return valorCsll;
    }

    public void setValorCsll(BigDecimal valorCsll) {
        this.valorCsll = valorCsll;
    }

    public BigDecimal getValorIr() {
        return valorIr;
    }

    public void setValorIr(BigDecimal valorIr) {
        this.valorIr = valorIr;
    }

    public BigDecimal getValorPis() {
        return valorPis;
    }

    public void setValorPis(BigDecimal valorPis) {
        this.valorPis = valorPis;
    }
}
