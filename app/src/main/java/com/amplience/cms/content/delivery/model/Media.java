package com.amplience.cms.content.delivery.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

public class Media extends ContentItem {

    private String endpoint;
    private String defaultHost;
    private String name;

    @Bindable
    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    @Bindable
    public String getDefaultHost() {
        return defaultHost;
    }

    public void setDefaultHost(String defaultHost) {
        this.defaultHost = defaultHost;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
