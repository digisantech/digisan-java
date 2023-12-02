package br.com.digisan.model;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class DigisanError {
    private String parameterName;

    private String type;

    private String message;

    private static String safeValue(JsonElement value) {
        return (null == value || value.isJsonNull() ? null : value.getAsString());
    }

    public DigisanError(JsonObject error) {
        this.parameterName = safeValue(error.get("field"));
        this.type = safeValue(error.get("type"));
        this.message = safeValue(error.get("message"));
    }

    public String getParameterName() {
        return parameterName;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }
}
