package br.com.digisan.model;

import br.com.digisan.util.JSONUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.Collection;

public class DigisanException extends Exception {
    private int returnCode;

    private String url;

    private String method;

    Collection<DigisanError> errors = new ArrayList<>();

    public static DigisanException buildWithError(final Exception error) {
        return new DigisanException(error.getMessage(), null);
    }

    public static DigisanException buildWithError(final DigisanResponse response) {

        if (null == response) {
            return null;
        }

        final JsonObject responseError = JSONUtils.getInterpreter().fromJson(response.getBody(), JsonObject.class);

        if (responseError.has("message")) {
            final DigisanException exception = new DigisanException(responseError.get("message").getAsString(), responseError);
            exception.returnCode = response.getCode();

            return exception;
        }

        final JsonArray errors = responseError.getAsJsonArray("mensagens");

        final StringBuilder joinedMessages = new StringBuilder();

        int i;
        for (i = 0; i < errors.size(); i++) {
            final JsonObject error = errors.get(i).getAsJsonObject();
            if (error.has("field") && error.get("field") != null) {
                try {
                    joinedMessages
                            .append(error.get("field").getAsString())
                            .append(" - ");
                } catch (Exception e) {}
            }
            joinedMessages
                    .append(error.get("message").getAsString())
                    .append("\n");
        }

        final DigisanException exception = new DigisanException(joinedMessages.toString(), responseError);
        exception.returnCode = response.getCode();

        return exception;
    }

    public DigisanException(int returnCode, String url, String method, String message) {
        super(message);
        this.returnCode = returnCode;
        this.url = url;
        this.method = method;
    }

    public DigisanException(final String message) {
        this(message, null);
    }

    public DigisanException(final String message, final JsonObject responseError) {
        super(message);

        if (null != responseError) {
            if (responseError.has("mensagens")) {
                final JsonArray errors = responseError.get("mensagens").getAsJsonArray();

                int i;
                for (i = 0; i < errors.size(); i++) {
                    final JsonObject error = errors.get(i).getAsJsonObject();
                    this.errors.add(new DigisanError(error));
                }

            }

        }

    }

    public Collection<DigisanError> getErrors() {
        return errors;
    }

    public String getUrl() {
        return url;
    }

    public String getMethod() {
        return method;
    }

    public int getReturnCode() {
        return returnCode;
    }
}
