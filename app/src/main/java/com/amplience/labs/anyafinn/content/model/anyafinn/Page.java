package com.amplience.labs.anyafinn.content.model.anyafinn;

import com.amplience.cms.content.delivery.model.ContentItem;
import com.amplience.cms.content.delivery.serialization.ContentType;
import com.amplience.cms.content.rendering.android.ContentTypeFragment;
import com.amplience.labs.anyafinn.content.model.common.ContentContainer;
import com.amplience.labs.anyafinn.content.view.common.StackFragment;

import java.util.List;

@ContentType(pattern = "/page.json")
@ContentTypeFragment(fragment = StackFragment.class)
public class Page extends ContentItem implements ContentContainer {

    private List<ContentItem> contentSlots;

    public List<ContentItem> getContentSlots() {
        return contentSlots;
    }

    public void setContentSlots(List<ContentItem> contentSlots) {
        this.contentSlots = contentSlots;
    }

    @Override
    public List<ContentItem> getChildren() {
        return getContentSlots();
    }

}
