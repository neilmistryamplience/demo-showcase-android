package com.amplience.labs.anyafinn.content.view.accelerators;

import android.widget.TextView;

import com.amplience.cms.content.rendering.android.butterknife.ButterknifeContentView;
import com.amplience.labs.anyafinn.R;
import com.amplience.labs.anyafinn.content.model.accelerators.Text;

import butterknife.BindView;
import ru.noties.markwon.Markwon;
import ru.noties.markwon.SpannableConfiguration;
import ru.noties.markwon.spans.SpannableTheme;

public class TextFragment extends ButterknifeContentView<Text> {

    @BindView(R.id.body)
    TextView body;

    public TextFragment() {
        super(R.layout.fragment_accelerators_text);
    }

    @Override
    protected void onRenderContent(Text content) {
        SpannableConfiguration config = SpannableConfiguration.builder(getContext())
                .theme(SpannableTheme.builder()
                        .tableBorderWidth(0)
                        .build())
                .build();

        Markwon.setMarkdown(body, config, content.getText());
    }

}
