package com.amplience.labs.anyafinn.content.model.anyafinn;

import android.view.View;
import android.view.ViewGroup;

public class AspectRatio {

    private Integer w;
    private Integer h;

    public Integer getW() {
        return w;
    }

    public void setW(Integer w) {
        this.w = w;
    }

    public Integer getH() {
        return h;
    }

    public void setH(Integer h) {
        this.h = h;
    }


    public boolean isSpecified() {
        return getW() != null && getH() != null;
    }

}
