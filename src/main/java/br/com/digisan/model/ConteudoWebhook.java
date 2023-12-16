package br.com.digisan.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

public class ConteudoWebhook {
    private String documento;
    private String id;
    private String idExterno;
    private LocalDateTime emissao;
    private LocalDateTime cancelamento;
    private String status;
    private String prestador;
    private String tomador;
    private BigDecimal valorLiquido;
    private String numero;
    private String serie;
    private String lote;
    private String codigoVerificacao;
    private String mensagem;
    private String pdf;
    private String xml;
    private Map<String, String> metadados;

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdExterno() {
        return idExterno;
    }

    public void setIdExterno(String idExterno) {
        this.idExterno = idExterno;
    }

    public LocalDateTime getEmissao() {
        return emissao;
    }

    public void setEmissao(LocalDateTime emissao) {
        this.emissao = emissao;
    }

    public LocalDateTime getCancelamento() {
        return cancelamento;
    }

    public void setCancelamento(LocalDateTime cancelamento) {
        this.cancelamento = cancelamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPrestador() {
        return prestador;
    }

    public void setPrestador(String prestador) {
        this.prestador = prestador;
    }

    public String getTomador() {
        return tomador;
    }

    public void setTomador(String tomador) {
        this.tomador = tomador;
    }

    public BigDecimal getValorLiquido() {
        return valorLiquido;
    }

    public void setValorLiquido(BigDecimal valorLiquido) {
        this.valorLiquido = valorLiquido;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getCodigoVerificacao() {
        return codigoVerificacao;
    }

    public void setCodigoVerificacao(String codigoVerificacao) {
        this.codigoVerificacao = codigoVerificacao;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getPdf() {
        return pdf;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }

    public String getXml() {
        return xml;
    }

    public void setXml(String xml) {
        this.xml = xml;
    }

    public Map<String, String> getMetadados() {
        return metadados;
    }

    public void setMetadados(Map<String, String> metadados) {
        this.metadados = metadados;
    }

    @Override
    public String toString() {
        return "ConteudoWebhook{" +
                "documento='" + documento + '\'' +
                ", id='" + id + '\'' +
                ", idExterno='" + idExterno + '\'' +
                ", emissao=" + emissao +
                ", cancelamento=" + cancelamento +
                ", status='" + status + '\'' +
                ", prestador='" + prestador + '\'' +
                ", tomador='" + tomador + '\'' +
                ", valorLiquido=" + valorLiquido +
                ", numero='" + numero + '\'' +
                ", serie='" + serie + '\'' +
                ", lote='" + lote + '\'' +
                ", codigoVerificacao='" + codigoVerificacao + '\'' +
                ", mensagem='" + mensagem + '\'' +
                ", pdf='" + pdf + '\'' +
                ", xml='" + xml + '\'' +
                ", metadados=" + metadados +
                '}';
    }
}
