package com.amplience.labs.anyafinn.content.model.accelerators;

import com.amplience.cms.content.delivery.model.ContentItem;
import com.amplience.cms.content.delivery.serialization.ContentType;
import com.amplience.cms.content.rendering.android.ContentTypeFragment;
import com.amplience.labs.anyafinn.content.model.common.ContentContainer;
import com.amplience.labs.anyafinn.content.view.common.StackFragment;

import java.util.List;

/**
 * Created by darren on 21/08/2018.
 */

@ContentType(pattern = "/splitBlock.json")
@ContentTypeFragment(fragment = StackFragment.class)
public class SplitBlock extends ContentItem implements ContentContainer {

    private List<ContentItem> content;

    public List<ContentItem> getContent() {
        return content;
    }

    public void setContent(List<ContentItem> content) {
        this.content = content;
    }

    @Override
    public List<ContentItem> getChildren() {
        return getContent();
    }

}
