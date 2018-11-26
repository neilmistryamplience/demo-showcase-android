package com.amplience.labs.anyafinn.content.model.accelerators;

import com.amplience.cms.content.delivery.model.ContentItem;
import com.amplience.cms.content.delivery.serialization.ContentType;
import com.amplience.labs.anyafinn.content.model.common.ContentContainer;
import com.amplience.labs.anyafinn.content.view.common.StackFragment;
import com.amplience.cms.content.rendering.android.ContentTypeFragment;

import java.util.List;

@ContentType(pattern = "/flexible-slot.json")
@ContentTypeFragment(fragment = StackFragment.class)
public class FlexibleSlot extends ContentItem implements ContentContainer {

    private List<ContentItem> contentTypes;

    public List<ContentItem> getContentTypes() {
        return contentTypes;
    }

    public void setContentTypes(List<ContentItem> contentTypes) {
        this.contentTypes = contentTypes;
    }

    @Override
    public List<ContentItem> getChildren() {
        return getContentTypes();
    }

}
