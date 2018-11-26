package com.amplience.labs.anyafinn.content.view.accelerators;

import android.graphics.PorterDuff;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.amplience.cms.content.delivery.model.Image;
import com.amplience.cms.content.rendering.android.butterknife.ButterknifeContentView;
import com.amplience.cms.content.rendering.android.butterknife.ConditionalButterknifeContentView;
import com.amplience.labs.anyafinn.R;
import com.amplience.labs.anyafinn.content.model.accelerators.Banner;
import com.squareup.picasso.Picasso;

import butterknife.BindView;

public class BannerFragment extends ConditionalButterknifeContentView<Banner> {

    @BindView(R.id.imageView)
    ImageView imageView;

    @BindView(R.id.roundelView)
    ImageView roundelView;

    @BindView(R.id.callToActionButton)
    Button callToActionButton;

    @BindView(R.id.heading)
    TextView heading;

    @BindView(R.id.description)
    TextView description;
//
//    @BindView(R.id.overlayPanel)
//    LinearLayout overlayPanel;

    public BannerFragment() {
    }

    @Override
    protected int getLayout(Banner content) {
        if(content.isStackMobileLayout()) {
            return R.layout.fragment_accelerators_banner_mobile_layout;
        }else{
            return R.layout.fragment_accelerators_banner;
        }
    }

    protected void onRenderContent(Banner content) {
        renderContent(content);
        renderStyles(content);
    }

    private void renderContent(Banner content) {
        Picasso.with(getContext())
                .load(content.getImg().getImageUrl(1, 1))
                .noFade()
                .into(imageView);

        if(content.getContentImg() != null) {
            Picasso.with(getContext())
                    .load(content.getContentImg().getImageUrl())
                    .noFade()
                    .into(roundelView);
        }

        if(content.getButton() != null && content.getButton().getLabel() != null) {
            callToActionButton.setText(content.getButton().getLabel());
        }

        if(content.getHeader() != null) {
            heading.setText(content.getHeader());
        }

        if(content.getDescription() != null) {
            description.setText(content.getDescription());
        }else if(content.getSubheader() != null) {
            description.setText(content.getSubheader());
        }
    }

    private void renderStyles(Banner content) {

        if(!content.isStackMobileLayout()) {
            LinearLayout overlayPanel = getView().findViewById(R.id.overlayPanel);

            if(content.isHideBG()) {
                overlayPanel.setBackgroundColor(0x00FFFFFF);
            }else{
                if(content.getStyle() != null && "white".equals(content.getStyle())) {
                    overlayPanel.setBackgroundColor(0x99000000);
                }else{
                    overlayPanel.setBackgroundColor(0xBBFFFFFF);
                }
            }

            if("white".equals(content.getStyle())) {
                heading.setTextAppearance(R.style.Content_Banner_Header_Light);
                description.setTextAppearance(R.style.Content_Banner_SubHeader_Light);
                callToActionButton.getBackground().setColorFilter(0xCCFFFFFF, PorterDuff.Mode.MULTIPLY);
                callToActionButton.setTextColor(0xFF000000);
            }else{
                heading.setTextAppearance(R.style.Content_Banner_Header);
                description.setTextAppearance(R.style.Content_Banner_SubHeader);
                callToActionButton.getBackground().setColorFilter(0xCC000000, PorterDuff.Mode.MULTIPLY);
                callToActionButton.setTextColor(0xFFFFFFFF);
            }
        }

    }

}
