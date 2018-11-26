package com.amplience.cms.content.delivery.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class QueryResult extends QueryResultEntry {

    @SerializedName("result")
    private List<QueryResultEntry> results;

    @SerializedName("@graph")
    private ContentGraph graph;


    public List<QueryResultEntry> getResults() {
        return results;
    }

    public ContentGraph getGraph() {
        return graph;
    }

}
