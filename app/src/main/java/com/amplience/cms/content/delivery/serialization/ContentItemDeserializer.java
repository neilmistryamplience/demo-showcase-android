package com.amplience.cms.content.delivery.serialization;

import com.amplience.cms.content.delivery.model.ContentItem;
import com.amplience.cms.content.delivery.model.Image;
import com.amplience.cms.content.delivery.model.Video;
import com.google.common.collect.Maps;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.Map;
import java.util.regex.Pattern;

public class ContentItemDeserializer implements JsonDeserializer<ContentItem> {

    private final Map<String, Class<? extends ContentItem>> mapping;

    public ContentItemDeserializer() {
        mapping = Maps.newHashMap();
        mapping.put("http://bigcontent.io/cms/schema/v1/core#/definitions/video-link", Video.class);
        mapping.put("http://bigcontent.io/cms/schema/v1/core#/definitions/image-link", Image.class);
    }

    public void addContentType(String suffix, Class<? extends ContentItem> model) {
        mapping.put(suffix, model);
    }

    public void addContentType(Class<? extends ContentItem> model) {
        String[] patterns = model.getAnnotation(ContentType.class).pattern();
        for(String pattern : patterns) {
            addContentType(pattern, model);
        }
    }

    public ContentItemDeserializer withContentType(Class<? extends ContentItem> model) {
        this.addContentType(model);
        return this;
    }

    @Override
    public ContentItem deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        if(isContentItem(json)) {
            String type = ((JsonObject)json).get("@type").getAsString();

            for(Map.Entry<String, Class<? extends ContentItem>> entry : mapping.entrySet()) {
                if(type.endsWith(entry.getKey())) {
                    return context.deserialize(json, entry.getValue());
                }

//                if(entry.getKey().matcher(type).matches()) {
//                    return context.deserialize(json, entry.getValue());
//                }
            }

            return null;
        }
        return context.deserialize(json, typeOfT);
    }

    private boolean isContentItem(JsonElement element) {
        return element.isJsonObject() &&
                ((JsonObject)element).has("@type");
    }

}
