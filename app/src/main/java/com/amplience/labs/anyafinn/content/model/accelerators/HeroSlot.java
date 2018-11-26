package com.amplience.labs.anyafinn.content.model.accelerators;

import com.amplience.cms.content.delivery.model.ContentItem;
import com.amplience.cms.content.delivery.serialization.ContentType;
import com.amplience.cms.content.rendering.android.ContentTypeFragment;
import com.amplience.labs.anyafinn.content.model.common.ContentContainer;
import com.amplience.labs.anyafinn.content.view.common.StackFragment;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by darren on 21/08/2018.
 */

@ContentType(pattern = "/banner-slot.json")
@ContentTypeFragment(fragment = StackFragment.class)
public class HeroSlot extends ContentItem implements ContentContainer {

    private ContentItem content;

    public ContentItem getContent() {
        return content;
    }

    public void setContent(ContentItem content) {
        this.content = content;
    }

    @Override
    public List<ContentItem> getChildren() {
        return Lists.newArrayList(getContent());
    }

}
