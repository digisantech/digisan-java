package br.com.digisan.util;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import com.google.gson.reflect.TypeToken;

public class JSONUtils {
    public static final Gson getInterpreter() {
        return getNewDefaultGsonBuilder().create();
    }

    public static <T> T getAsObject(JsonObject json, Class<T> clazz) {
        return getNewDefaultGsonBuilder().create().fromJson(json, clazz);
    }

    public static <T> Collection<T> getAsList(JsonArray json, Type listType) {
        return getNewDefaultGsonBuilder().create().fromJson(json, listType);
    }

    public static String getAsJson(Object object) {
        return getNewDefaultGsonBuilder().create().toJson(object);
    }

    public static Map<String, Object> objectToMap(Object object) {
        GsonBuilder builder = getNewDefaultGsonBuilder();
        final String json = builder.create().toJson(object);
        return builder.create().fromJson(json, new TypeToken<HashMap<String, Object>>() {
        }.getType());
    }

    private static GsonBuilder getNewDefaultGsonBuilder(){
        return new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setExclusionStrategies(new ExclusionStrategy(){

                    public boolean shouldSkipClass(Class<?> clazz) {
                        return false;
                    }

                    public boolean shouldSkipField(FieldAttributes fieldAttrs) {
                        return fieldAttrs.equals(null);
                    }

                });
    }
}
