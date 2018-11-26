package com.amplience.labs.anyafinn.content.model.accelerators;

import com.amplience.cms.content.delivery.model.ContentItem;
import com.amplience.cms.content.delivery.serialization.ContentType;
import com.amplience.cms.content.rendering.android.ContentTypeFragment;
import com.amplience.labs.anyafinn.content.view.accelerators.TextFragment;

@ContentType(pattern = "/text.json")
@ContentTypeFragment(fragment = TextFragment.class)
public class Text extends ContentItem {

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
