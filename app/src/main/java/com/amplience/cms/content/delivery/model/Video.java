package com.amplience.cms.content.delivery.model;

import java.net.URLEncoder;

/**
 * Created by darren on 21/08/2018.
 */

public class Video extends Media {

    public String getVideoUrl(String codec) {
        return "http://" + getDefaultHost() + "/v/" + getEndpoint() + "/" + URLEncoder.encode(getName()) + "/" + codec;
    }

}
