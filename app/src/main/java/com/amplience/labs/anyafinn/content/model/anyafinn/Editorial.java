package com.amplience.labs.anyafinn.content.model.anyafinn;

import android.databinding.Bindable;

import com.amplience.cms.content.delivery.model.ContentItem;

public class Editorial extends ContentItem {

    private String title;
    private String text;
    private String overlayTheme;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Bindable
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getOverlayTheme() {
        return overlayTheme;
    }

    public void setOverlayTheme(String overlayTheme) {
        this.overlayTheme = overlayTheme;
    }
}
