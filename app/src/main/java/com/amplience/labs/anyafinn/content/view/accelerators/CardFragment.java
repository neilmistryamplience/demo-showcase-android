package com.amplience.labs.anyafinn.content.view.accelerators;

import android.graphics.PorterDuff;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.amplience.cms.content.rendering.android.butterknife.ButterknifeContentView;
import com.amplience.labs.anyafinn.R;
import com.amplience.labs.anyafinn.content.model.accelerators.Banner;
import com.amplience.labs.anyafinn.content.model.accelerators.Card;
import com.squareup.picasso.Picasso;

import butterknife.BindView;


public class CardFragment extends ButterknifeContentView<Card> {

    @BindView(R.id.imageView)
    ImageView imageView;

    @BindView(R.id.callToActionButton)
    Button callToActionButton;

    @BindView(R.id.heading)
    TextView heading;

    @BindView(R.id.description)
    TextView description;

    @BindView(R.id.container)
    LinearLayout container;

    public CardFragment() {
        super(R.layout.fragment_accelerators_card);
    }

    protected void onRenderContent(Card content) {
        renderContent(content);
        renderStyles(content);
    }

    private void renderContent(Card content) {
        if(content.getImage() != null) {
            String url = content.getImage().getImageUrl();
            Picasso.with(getContext())
                    .load(content.getImage().getImageUrl(1, 1))
                    .into(imageView);
        } else {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)container.getLayoutParams();
            layoutParams.setMargins(
                layoutParams.leftMargin,
                layoutParams.bottomMargin,
                layoutParams.rightMargin,
                layoutParams.bottomMargin
            );
            container.setLayoutParams(layoutParams);
        }

        if(content.getCardName() != null) {
            heading.setText(content.getCardName());
        }
        if(content.getDescription() != null) {
            description.setText(content.getDescription());
        }
        if(content.getLinks() != null && content.getLinks().size() > 0) {
            callToActionButton.setText(content.getLinks().get(0).getLabel());
        }
    }

    private void renderStyles(Card content) {

//        if("white".equals(content.getStyle())) {
//            heading.setTextAppearance(R.style.Content_Banner_Header_Light);
//            description.setTextAppearance(R.style.Content_Banner_SubHeader_Light);
//            callToActionButton.getBackground().setColorFilter(0xCCFFFFFF, PorterDuff.Mode.MULTIPLY);
//            callToActionButton.setTextColor(0xFF000000);
//        }else{
//            heading.setTextAppearance(R.style.Content_Banner_Header);
//            description.setTextAppearance(R.style.Content_Banner_SubHeader);
//            callToActionButton.getBackground().setColorFilter(0xCC000000, PorterDuff.Mode.MULTIPLY);
//            callToActionButton.setTextColor(0xFFFFFFFF);
//        }

    }

}
