package br.com.digisan.model.nfse;

import br.com.digisan.model.DigisanException;
import br.com.digisan.model.DigisanRequest;
import br.com.digisan.model.Model;
import br.com.digisan.util.JSONUtils;
import com.google.gson.JsonObject;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.HttpMethod;

public class Nfse extends Model<String> {

    private String idExterno;
    private LocalDate competencia;
    private Prestador prestador;
    private Tomador tomador;
    private Servico servico;
    private String informacoesAdicionais;
    private Map<String, String> metadados = new HashMap<>();

    public String enviar() throws DigisanException {
        final DigisanRequest request = new DigisanRequest(HttpMethod.GET, "/nfse");
        final JsonObject response = JSONUtils.getAsObject((JsonObject) request.execute(), JsonObject.class);
        return response.get("id").getAsString();
    }

    public String getIdExterno() {
        return idExterno;
    }

    public void setIdExterno(String idExterno) {
        this.idExterno = idExterno;
    }

    public LocalDate getCompetencia() {
        return competencia;
    }

    public void setCompetencia(LocalDate competencia) {
        this.competencia = competencia;
    }

    public Prestador getPrestador() {
        return prestador;
    }

    public void setPrestador(Prestador prestador) {
        this.prestador = prestador;
    }

    public Tomador getTomador() {
        return tomador;
    }

    public void setTomador(Tomador tomador) {
        this.tomador = tomador;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public String getInformacoesAdicionais() {
        return informacoesAdicionais;
    }

    public void setInformacoesAdicionais(String informacoesAdicionais) {
        this.informacoesAdicionais = informacoesAdicionais;
    }

    public Map<String, String> getMetadados() {
        return metadados;
    }

    public void setMetadados(Map<String, String> metadados) {
        this.metadados = metadados;
    }
}
