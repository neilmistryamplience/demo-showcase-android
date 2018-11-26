package com.amplience.labs.anyafinn.content.model.accelerators;

import com.amplience.cms.content.delivery.model.ContentItem;
import com.amplience.cms.content.delivery.serialization.ContentType;
import com.amplience.cms.content.rendering.android.ContentTypeFragment;
import com.amplience.labs.anyafinn.content.model.common.ContentContainer;
import com.amplience.labs.anyafinn.content.view.common.CarouselFragment;

import java.util.List;

@ContentType(pattern = "/slider.json")
@ContentTypeFragment(fragment = CarouselFragment.class)
public class Slider extends ContentItem implements ContentContainer {

    private List<ContentItem> slides;
    private boolean loop;
    private boolean navigationDots;

    public List<ContentItem> getSlides() {
        return slides;
    }

    public void setSlides(List<ContentItem> slides) {
        this.slides = slides;
    }

    public boolean isLoop() {
        return loop;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    public boolean isNavigationDots() {
        return navigationDots;
    }

    public void setNavigationDots(boolean navigationDots) {
        this.navigationDots = navigationDots;
    }

    @Override
    public List<ContentItem> getChildren() {
        return getSlides();
    }
}
