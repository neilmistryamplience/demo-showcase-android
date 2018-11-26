package com.amplience.labs.anyafinn.content.view.anyafinn;


import android.graphics.Color;
import android.widget.TextView;

import com.amplience.labs.anyafinn.R;
import com.amplience.cms.content.rendering.android.butterknife.ButterknifeContentView;
import com.amplience.labs.anyafinn.content.model.anyafinn.Editorial;

import butterknife.BindView;

public class EditorialFragment extends ButterknifeContentView<Editorial> {


    @BindView(R.id.title)
    TextView title;

    @BindView(R.id.text)
    TextView text;

    public EditorialFragment() {
        super(R.layout.fragment_content_mixins_editorial);
    }

    @Override
    protected void onRenderContent(Editorial content) {
        title.setText(content.getTitle());
        text.setText(content.getText());

        if("Lighten".equals(content.getOverlayTheme())) {
            title.setTextColor(Color.BLACK);
            text.setTextColor(Color.BLACK);
        }else if("Darken".equals(content.getOverlayTheme())) {
            title.setShadowLayer(10, 1.5f, 1.5f, Color.DKGRAY);
            text.setShadowLayer(10, 1.5f, 1.5f, Color.DKGRAY);
        }
    }

}
