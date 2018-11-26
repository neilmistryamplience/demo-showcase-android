package com.amplience.cms.content.delivery.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import java.net.URLEncoder;

public class Image extends Media {

    public String getUrl() {
        return "http://" + getDefaultHost() + "/i/" + getEndpoint() + "/" + getName().replace(" ", "%20");
    }

}
