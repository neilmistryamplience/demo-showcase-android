package com.amplience.labs.anyafinn.content.model.anyafinn;

import android.databinding.Bindable;

import com.amplience.cms.content.delivery.model.ContentItem;
import com.amplience.cms.content.delivery.serialization.ContentType;
import com.amplience.cms.content.rendering.android.ContentTypeFragment;
import com.amplience.labs.anyafinn.content.view.anyafinn.TextBlockFragment;

import java.util.List;

@ContentType(pattern = "/text-block.json")
@ContentTypeFragment(fragment = TextBlockFragment.class)
public class TextBlock extends ContentItem {

    private String editorialTitle;
    private List<String> paragraphs;

    @Bindable
    public String getEditorialTitle() {
        return editorialTitle;
    }

    public void setEditorialTitle(String editorialTitle) {
        this.editorialTitle = editorialTitle;
    }

    @Bindable
    public List<String> getParagraphs() {
        return paragraphs;
    }

    public void setParagraphs(List<String> paragraphs) {
        this.paragraphs = paragraphs;
    }

}
