package com.amplience.cms.content.delivery.model;

import com.amplience.cms.content.delivery.utils.JsonTreeWalker;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import javax.annotation.Nullable;

public class ContentGraph extends ArrayList<JsonObject> {

    public Optional<JsonObject> getContentItem(String id) {
        for(JsonObject entry : this) {
            JsonElement entryId = entry.get("@id");
            if(entryId.isJsonPrimitive() && id.equals(entryId.getAsString())) {
                return Optional.of(entry);
            }
        }
        return Optional.absent();
    }

    public Optional<JsonObject> getContentTree(String id) {
        Optional<JsonObject> root = getContentItem(id);
        if(root.isPresent()) {

            JsonElement result = JsonTreeWalker.walkAndReplace(root.get(), new Function<JsonElement, JsonElement>() {
                @Nullable
                @Override
                public JsonElement apply(@Nullable JsonElement value) {
                    if(isGraphLink(value)) {
                        return processGraphLink((JsonObject)value);
                    }
                    return value;
                }
            });

            return Optional.of((JsonObject)result);

        }else{
            return Optional.absent();
        }
    }

    private JsonElement processGraphLink(JsonObject link) {
        Optional<JsonObject> child =
                getContentItem(link.get("@id").getAsString());

        if(child.isPresent()) {
            return child.get();
        }else{
            return link;
        }
    }

    private boolean isGraphLink(JsonElement value) {
        return value.isJsonObject() &&
                ((JsonObject)value).has("@id");
    }

}
