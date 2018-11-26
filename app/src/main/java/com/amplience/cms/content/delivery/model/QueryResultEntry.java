package com.amplience.cms.content.delivery.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class QueryResultEntry implements Serializable {

    @SerializedName("@id")
    private String id;

    public String getId() {
        return id;
    }

}
