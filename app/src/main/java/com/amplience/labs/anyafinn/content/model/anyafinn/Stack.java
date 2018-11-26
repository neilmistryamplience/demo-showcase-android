package com.amplience.labs.anyafinn.content.model.anyafinn;

import com.amplience.cms.content.delivery.model.ContentItem;
import com.amplience.cms.content.delivery.serialization.ContentType;
import com.amplience.cms.content.rendering.android.ContentTypeFragment;
import com.amplience.labs.anyafinn.content.model.common.ContentContainer;
import com.amplience.labs.anyafinn.content.view.common.StackFragment;

import java.util.List;

@ContentType(pattern = "/stack.json")
@ContentTypeFragment(fragment = StackFragment.class)
public class Stack extends ContentItem implements ContentContainer {

    private List<ContentItem> content;

    public List<ContentItem> getChildren() {
        return content;
    }

    public void setContent(List<ContentItem> content) {
        this.content = content;
    }

}
