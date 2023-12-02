package br.com.digisan.model;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class DigisanResponse {
    private int code = -1;

    private final JsonElement body;

    public DigisanResponse(final JsonElement body) {
        this.body = body;
    }

    public DigisanResponse(final int code, final JsonElement body) {
        this.code = code;
        this.body = body;
    }

    public DigisanResponse(final JsonObject object) {
        this.code = object.get("code").getAsInt();
        this.body = object.get("body");
    }

    public int getCode() {
        return code;
    }

    public JsonElement getBody() {
        return body;
    }
}
