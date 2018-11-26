package com.amplience.labs.anyafinn.content.model.anyafinn;

import android.databinding.Bindable;

import com.amplience.cms.content.delivery.model.ContentItem;
import com.amplience.cms.content.delivery.serialization.ContentType;
import com.amplience.cms.content.rendering.android.ContentTypeFragment;
import com.amplience.labs.anyafinn.content.view.anyafinn.HeroBlockFragment;

@ContentType(pattern = "/hero-block.json")
@ContentTypeFragment(fragment = HeroBlockFragment.class)
public class HeroBlock extends ContentItem {

    private ImageBlock panelContent;

    @Bindable
    public ImageBlock getPanelContent() {
        return panelContent;
    }

    public void setPanelContent(ImageBlock panelContent) {
        this.panelContent = panelContent;
    }

}
