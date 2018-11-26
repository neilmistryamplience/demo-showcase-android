package com.amplience.labs.anyafinn.content.view.anyafinn;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.amplience.labs.anyafinn.R;
import com.amplience.cms.content.rendering.android.butterknife.ButterknifeContentView;
import com.amplience.labs.anyafinn.content.model.anyafinn.HeroBlock;
import com.squareup.picasso.Picasso;

import butterknife.BindView;

public class HeroBlockFragment extends ButterknifeContentView<HeroBlock> {

    @BindView(R.id.imageView)
    ImageView imageView;

    EditorialFragment editorial;

    public HeroBlockFragment() {
        super(R.layout.fragment_content_blocks_hero);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup vg, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, vg, savedInstanceState);
        editorial = (EditorialFragment) getChildFragmentManager().findFragmentById(R.id.editorial);
        return view;
    }

    protected void onRenderContent(HeroBlock content) {
        if(imageView == null){
            return;
        }

        String url = content.getPanelContent().getImageUrl();
        Picasso.with(getContext())
                .load(url)
                .into(imageView);

        editorial.setContent(content.getPanelContent().getEditorial());
    }

}
