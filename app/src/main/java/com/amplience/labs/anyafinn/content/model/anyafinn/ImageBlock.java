package com.amplience.labs.anyafinn.content.model.anyafinn;

import android.databinding.Bindable;

import com.amplience.cms.content.delivery.model.ContentItem;
import com.amplience.cms.content.delivery.serialization.ContentType;
import com.amplience.labs.anyafinn.content.view.anyafinn.ImageBlockFragment;
import com.amplience.cms.content.delivery.model.Image;
import com.amplience.cms.content.rendering.android.ContentTypeFragment;

@ContentType(pattern = "/image-block.json")
@ContentTypeFragment(fragment = ImageBlockFragment.class)
public class ImageBlock extends ContentItem {

    private Editorial editorial;

    private Image image;

    private AspectRatio aspectRatio;

    private AspectRatio mobileAspectRatio;

    @Bindable
    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    @Bindable
    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    public AspectRatio getAspectRatio() {
        return aspectRatio;
    }

    public void setAspectRatio(AspectRatio aspectRatio) {
        this.aspectRatio = aspectRatio;
    }

    public AspectRatio getMobileAspectRatio() {
        return mobileAspectRatio;
    }

    public void setMobileAspectRatio(AspectRatio mobileAspectRatio) {
        this.mobileAspectRatio = mobileAspectRatio;
    }

    public String getImageUrl() {
        String baseUrl = getImage().getUrl();

        if(getMobileAspectRatio() != null && getMobileAspectRatio().isSpecified()) {
            return baseUrl + "?$poi$&w=600&fmt=jpg&sm=aspect&aspect=" + getMobileAspectRatio().getW() + ":" + getMobileAspectRatio().getH();
        }else if(getAspectRatio() != null && getAspectRatio().isSpecified()) {
            return baseUrl + "?$poi$&w=600&fmt=jpg&sm=aspect&aspect=" + getAspectRatio().getW() + ":" + getAspectRatio().getH();
        }else{
            return baseUrl + "?maxW=600&fmt=png";
        }
    }

}
