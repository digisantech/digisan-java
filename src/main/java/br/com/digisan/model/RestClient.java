package br.com.digisan.model;

import br.com.digisan.util.JSONUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonSyntaxException;

import javax.net.ssl.HttpsURLConnection;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.HttpMethod;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class RestClient {
    public final static String API_KEY = "api_key";

    private HttpsURLConnection httpClient;

    private String method;

    private String url;

    private Map<String, Object> parameters;

    private int count;

    private boolean live;

    private InputStream is;

    public RestClient(final String method, final String url) throws DigisanException {
        this(method, url, null, null);
    }

    public RestClient(final String method, final String url, Map<String, Object> parameters) throws DigisanException {
        this(method, url, parameters, null);
    }

    @SuppressWarnings("unchecked")
    public RestClient(final String method, final String url, Map<String, Object> parameters,
                      Map<String, String> headers) throws DigisanException {
        System.setProperty("https.protocols", "TLSv1.2");

        this.method = method;
        this.url = url;
        this.parameters = parameters;

        if (null == headers) {
            headers = new HashMap<>();
        }

        if (null == this.parameters) {
            this.parameters = new HashMap<String, Object>();
        }

        String sdkVersion = String.format("Digisan-Java/%s", Digisan.VERSION);

        headers.put("User-Agent", sdkVersion);
        headers.put("X-Digisan-User-Agent", sdkVersion);
        headers.put("Accept", "application/json");
        headers.put(API_KEY, Digisan.getApiKey());

        if (url == null || "".equals(url)) {
            throw new DigisanException("You must set the URL to make a request.");
        }

        if (method != null && !method.equals("")) {

            try {
                final UriBuilder builder = UriBuilder.fromPath(this.url);
                if (method.equalsIgnoreCase(HttpMethod.GET)) {
                    for (Map.Entry<String, Object> entry : this.parameters.entrySet()) {
                        builder.queryParam(entry.getKey(), entry.getValue());
                    }
                }

                httpClient = (HttpsURLConnection) builder
                        .build(this)
                        .toURL()
                        .openConnection();
                httpClient.setRequestMethod(this.method.toUpperCase());
                httpClient.setDoInput(true);
                httpClient.setDoOutput(false);

                if (headers.size() > 0) {
                    for (Map.Entry<String, String> entry : headers.entrySet()) {
                        httpClient.addRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
            } catch (Exception e) {
                throw DigisanException.buildWithError(e);
            }
        }
    }

    public DigisanResponse execute() throws DigisanException {
        final StringBuilder builder = new StringBuilder();
        int responseCode = -1;

        try {
            if (method.equalsIgnoreCase(HttpMethod.POST)
                    || method.equalsIgnoreCase(HttpMethod.PUT)
                    || method.equalsIgnoreCase(HttpMethod.DELETE)) {
                httpClient.setDoOutput(true);

                if (parameters.size() > 0) {
                    final byte[] payload = JSONUtils.getInterpreter().toJson(parameters).getBytes();
                    httpClient.addRequestProperty("Content-Type", "application/json");
                    httpClient.addRequestProperty("Content-Length", String.valueOf(payload.length));

                    final OutputStream os = httpClient.getOutputStream();
                    os.write(payload);
                    os.flush();
                }

            }

            try {
                is = httpClient.getInputStream();
                responseCode = httpClient.getResponseCode();
            } catch (IOException e) {
                is = httpClient.getErrorStream();
                responseCode = httpClient.getResponseCode();
            }

            final BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));

            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
                builder.append('\r');
            }

            reader.close();
            httpClient.disconnect();

            return new DigisanResponse(responseCode,
                    JSONUtils.getInterpreter().fromJson(builder.toString(), JsonElement.class));
        } catch (Exception e) {

            if (e instanceof JsonSyntaxException) {
                throw new DigisanException(responseCode, url, method, builder.toString());
            }

            throw DigisanException.buildWithError(e);
        }

    }
}
