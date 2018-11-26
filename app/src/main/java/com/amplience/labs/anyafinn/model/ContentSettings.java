package com.amplience.labs.anyafinn.model;

import android.content.Intent;
import android.os.Bundle;

public class ContentSettings {

    private String contentDeliveryUrl = "http://c1.adis.ws";
    private String contentDeliveryAccount = "willow";
    private String locale = "en-US";
    private ContentVisualization visualization;

    public void parse(final Intent intent) {
        Bundle extras = intent.getExtras();
//
//        extras = new Bundle();
//        extras.putString("contentId", "2f4d7b34-2710-4a75-bcad-79adcdadbe31");
//        extras.putString("cms", "8d0nfe8p86q314k885enoody0.staging.bigcontent.io");

        if(extras != null) {
            if (extras.containsKey("cms")) {
                String cmsUrl = extras.getString("cms");
                if(cmsUrl.indexOf("://") == -1) {
                    cmsUrl = "https://" + cmsUrl;
                }
                contentDeliveryUrl = cmsUrl;
            }
            if (extras.containsKey("cmsAccount")) {
                contentDeliveryAccount = extras.getString("cmsAccount");
            }
            if (extras.containsKey("contentId")) {
                getOrCreateVisualization().setContentId(extras.getString("contentId"));
            }
            if(extras.containsKey("locale")) {
                locale = extras.getString("locale");
            }
        }
    }

    public ContentVisualization getVisualization() {
        return visualization;
    }

    public boolean hasVisualization() {
        return getVisualization() != null;
    }

    private ContentVisualization getOrCreateVisualization() {
        if(visualization == null) {
            visualization = new ContentVisualization();
        }
        return visualization;
    }

    public String getContentDeliveryUrl() {
        return contentDeliveryUrl;
    }

    public String getContentDeliveryAccount() {
        return contentDeliveryAccount;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }
}
