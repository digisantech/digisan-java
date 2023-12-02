package br.com.digisan.model;

import br.com.digisan.util.JSONUtils;
import com.google.gson.JsonElement;

import java.util.HashMap;
import java.util.Map;

public class DigisanRequest extends Digisan {
    private final String path;

    private final String method;

    private final boolean live;

    private Map<String, Object> parameters;

    private Map<String, String> headers;

    public DigisanRequest(String method, String path) {
        this(method, path, true);
    }

    public DigisanRequest(String method, String path, boolean live) {
        this.path = path;
        this.method = method;
        this.live = live;
        this.parameters = new HashMap<>();
    }

    @SuppressWarnings("unchecked")
    public <T> T execute() throws DigisanException {
        if (getApiKey() == null || getApiKey().isEmpty()) {
            throw new DigisanException("Você precisa informar a API key.");
        }

        final RestClient client = new RestClient(method, fullApiUrl(path), parameters, headers);
        final DigisanResponse response = client.execute();

        final JsonElement decoded = JSONUtils.getInterpreter().fromJson(response.getBody(), JsonElement.class);

        if (response.getCode() == 200) {
            return (T) decoded;
        } else {
            throw DigisanException.buildWithError(response);
        }

    }

    public Map<String, Object> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
    }
}
