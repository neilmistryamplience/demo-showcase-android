package com.amplience.labs.anyafinn.content.model.accelerators;

import com.amplience.cms.content.delivery.model.ContentItem;
import com.amplience.cms.content.delivery.serialization.ContentType;
import com.amplience.cms.content.rendering.android.ContentTypeFragment;
import com.amplience.labs.anyafinn.content.view.accelerators.BannerFragment;

@ContentType(pattern = "/banner.json")
@ContentTypeFragment(fragment = BannerFragment.class)
public class Banner extends ContentItem {

    private Image img;
    private Image contentImg;
    private String header;
    private String subheader;
    private String description;
    private Link button;
    private String alignment;
    private double percH;
    private double percV;
    private String style;
    private boolean hideBG;
    private boolean stackMobileLayout;

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public Image getContentImg() {
        return contentImg;
    }

    public void setContentImg(Image contentImg) {
        this.contentImg = contentImg;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getSubheader() {
        return subheader;
    }

    public void setSubheader(String subheader) {
        this.subheader = subheader;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Link getButton() {
        return button;
    }

    public void setButton(Link button) {
        this.button = button;
    }

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    public double getPercH() {
        return percH;
    }

    public void setPercH(double percH) {
        this.percH = percH;
    }

    public double getPercV() {
        return percV;
    }

    public void setPercV(double percV) {
        this.percV = percV;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public boolean isHideBG() {
        return hideBG;
    }

    public void setHideBG(boolean hideBG) {
        this.hideBG = hideBG;
    }

    public boolean isStackMobileLayout() {
        return stackMobileLayout;
    }

    public void setStackMobileLayout(boolean stackMobileLayout) {
        this.stackMobileLayout = stackMobileLayout;
    }

}
