package com.amplience.cms.content.delivery.model;

import java.util.Date;

public class ContentMetaData {
    private String name;
    private Edition edition;
    private ContentLifecycle lifecycle;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Edition getEdition() {
        return edition;
    }

    public void setEdition(Edition edition) {
        this.edition = edition;
    }

    public ContentLifecycle getLifecycle() {
        return lifecycle;
    }

    public void setLifecycle(ContentLifecycle lifecycle) {
        this.lifecycle = lifecycle;
    }

    public boolean isExpired() {
        return getLifecycle() != null &&
                getLifecycle().getExpiryTime() != null &&
                getLifecycle().getExpiryTime().getTime() < new Date().getTime();
    }
}
