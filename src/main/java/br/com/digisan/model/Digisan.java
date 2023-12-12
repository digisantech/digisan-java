package br.com.digisan.model;

public abstract class Digisan {

    public static final String ENDPOINT = "https://api.digisan.com.br/diginfe";
//    public static final String ENDPOINT = "http://localhost:8080/diginfe";
    public static final String VERSION = "1.0.0";
    private static String apiKey;
    public static void init(String apiKey) {
        Digisan.apiKey = apiKey;
    }

    public static String fullApiUrl(final String path) {
        return ENDPOINT.concat("/api/v1")
                .concat(path);
    }

    public static String getApiKey() {
        return apiKey;
    }
}
