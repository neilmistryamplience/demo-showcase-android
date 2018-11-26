package com.amplience.labs.anyafinn.content.model.accelerators;

import com.amplience.cms.content.delivery.model.ContentItem;
import com.amplience.cms.content.delivery.serialization.ContentType;

import java.net.URLEncoder;
import java.util.List;

@ContentType(pattern = "/image.json")
public class Image extends ContentItem{

    private com.amplience.cms.content.delivery.model.Image image;
    private String imageAltText;
    private String seoText;
    private List<Roundel> roundel;
    private String display;

    public com.amplience.cms.content.delivery.model.Image getImage() {
        return image;
    }

    public void setImage(com.amplience.cms.content.delivery.model.Image image) {
        this.image = image;
    }

    public String getImageAltText() {
        return imageAltText;
    }

    public void setImageAltText(String imageAltText) {
        this.imageAltText = imageAltText;
    }

    public String getSeoText() {
        return seoText;
    }

    public void setSeoText(String seoText) {
        this.seoText = seoText;
    }

    public List<Roundel> getRoundel() {
        return roundel;
    }

    public void setRoundel(List<Roundel> roundel) {
        this.roundel = roundel;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }


    public String getImageUrl() {
        String url = getImage().getUrl();
        if(getSeoText() != null) {
            url += "/" + URLEncoder.encode(getSeoText());
        }

        url += ".webp?";
        url += "w=1280&upscale=false";

//        if("Point of Interest".equals(getDisplay())) {
//            url += "&$poi$";
//        }

        return url;
    }

    public String getImageUrl(int aspectX, int aspectY) {
        return getImageUrl() + "&$poi$&sm=aspect&aspect=" + aspectX + ":" + aspectY;
    }

}
