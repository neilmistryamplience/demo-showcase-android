package com.amplience.cms.content.delivery.utils;

import com.google.common.base.Function;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Map;

public class JsonTreeWalker {

    public static JsonElement walkAndReplace(JsonElement value, Function<JsonElement, JsonElement> visitor) {
        if (value == null) {
            return null;
        } else if (value.isJsonObject()) {
            JsonObject objectValue = (JsonObject) value;
            JsonObject newValue = new JsonObject();

            for (Map.Entry entry : objectValue.entrySet()) {
                String entryKey = (String) entry.getKey();
                JsonElement entryValue = (JsonElement) entry.getValue();

                entryValue = visitor.apply(entryValue);
                entryValue = walkAndReplace(entryValue, visitor);

                newValue.add(entryKey, entryValue);
            }
            return newValue;
        } else if (value.isJsonArray()) {
            JsonArray arrayValue = (JsonArray) value;
            JsonArray newValue = new JsonArray();

            for (JsonElement entryValue : arrayValue) {
                entryValue = visitor.apply(entryValue);
                entryValue = walkAndReplace(entryValue, visitor);
                newValue.add(entryValue);
            }
            return newValue;
        } else {
            return visitor.apply(value);
        }
    }

}
