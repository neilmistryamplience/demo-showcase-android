package com.amplience.labs.anyafinn.content.view.common;


import com.amplience.cms.content.delivery.model.ContentItem;
import com.amplience.cms.content.rendering.android.butterknife.ButterknifeContentView;
import com.amplience.labs.anyafinn.R;
import com.amplience.labs.anyafinn.content.model.common.ContentContainer;

public class StackFragment extends ButterknifeContentView<ContentItem> {

    public StackFragment() {
        super(R.layout.fragment_content_container);
    }

    @Override
    protected void onRenderContent(ContentItem content) {
        assert content instanceof ContentContainer;
        renderCollection(R.id.container, ((ContentContainer) content).getChildren());
    }

}
