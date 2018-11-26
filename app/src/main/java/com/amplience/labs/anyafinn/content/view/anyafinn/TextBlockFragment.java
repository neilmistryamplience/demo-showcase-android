package com.amplience.labs.anyafinn.content.view.anyafinn;

import android.widget.TextView;

import com.amplience.labs.anyafinn.R;
import com.amplience.cms.content.rendering.android.butterknife.ButterknifeContentView;
import com.amplience.labs.anyafinn.content.model.anyafinn.TextBlock;

import butterknife.BindView;

public class TextBlockFragment extends ButterknifeContentView<TextBlock> {

    @BindView(R.id.headline)
    TextView headline;

    @BindView(R.id.body)
    TextView body;

    public TextBlockFragment() {
        super(R.layout.fragment_content_blocks_text);
    }

    @Override
    protected void onRenderContent(TextBlock content) {
        headline.setText(content.getEditorialTitle());

        String bodyText = "";
        if(content.getParagraphs() != null && content.getParagraphs().size() > 0) {
            bodyText = content.getParagraphs().get(0);
        }

        body.setText(bodyText);
    }

}
