package com.amplience.labs.anyafinn.content.model.anyafinn;

import com.amplience.cms.content.delivery.model.ContentItem;
import com.amplience.cms.content.delivery.serialization.ContentType;
import com.amplience.cms.content.rendering.android.ContentTypeFragment;
import com.amplience.labs.anyafinn.content.model.common.ContentContainer;
import com.amplience.labs.anyafinn.content.view.common.CarouselFragment;

import java.util.List;

@ContentType(pattern = "/carousel.json")
@ContentTypeFragment(fragment = CarouselFragment.class)
public class Carousel extends ContentItem implements ContentContainer {

    private List<ContentItem> slides;

    public List<ContentItem> getSlides() {
        return slides;
    }

    public void setSlides(List<ContentItem> slides) {
        this.slides = slides;
    }

    @Override
    public List<ContentItem> getChildren() {
        return getSlides();
    }
}
