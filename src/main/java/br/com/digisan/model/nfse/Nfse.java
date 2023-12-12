package br.com.digisan.model.nfse;

import br.com.digisan.model.DigisanException;
import br.com.digisan.model.DigisanRequest;
import br.com.digisan.model.Model;
import br.com.digisan.util.JSONUtils;
import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.HttpMethod;

public class Nfse extends Model<String> {

    @Expose
    private String idExterno;

    @Expose
    private LocalDate competencia;

    @Expose
    private Prestador prestador;

    @Expose
    private Tomador tomador;

    @Expose
    private Servico servico;

    @Expose
    private String informacoesAdicionais;

    @Expose
    private Map<String, String> metadados;

    public void solicitarCancelamento(final String id, CodigoCancelamento codigoCancelamento, String motivo) throws DigisanException {
        final DigisanRequest request = new DigisanRequest(HttpMethod.POST, "/nfse/cancelar/" + id);
        Map parameters = new HashMap<>();
        parameters.put("codigo", codigoCancelamento.getCodigo());
        parameters.put("motivo", motivo);
        request.setParameters(parameters);
        request.execute();
    }

    public EnviarNfseResponse enviar() throws DigisanException {
        final DigisanRequest request = new DigisanRequest(HttpMethod.POST, "/nfse");
        request.setParameters(JSONUtils.objectToMap(this));
        JsonObject executed = (JsonObject) request.execute();
        return JSONUtils.getAsObject(executed, EnviarNfseResponse.class);
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
