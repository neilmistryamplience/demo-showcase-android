package com.amplience.labs.anyafinn.content.view.anyafinn;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.amplience.labs.anyafinn.R;
import com.amplience.cms.content.rendering.android.butterknife.ButterknifeContentView;
import com.amplience.labs.anyafinn.content.model.anyafinn.ImageBlock;
import com.squareup.picasso.Picasso;

import butterknife.BindView;

public class ImageBlockFragment extends ButterknifeContentView<ImageBlock> {

    @BindView(R.id.imageView)
    ImageView imageView;

    EditorialFragment editorial;

    public ImageBlockFragment() {
        super(R.layout.fragment_content_blocks_image);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup vg, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, vg, savedInstanceState);
        editorial = (EditorialFragment) getChildFragmentManager().findFragmentById(R.id.editorial);
        return view;
    }

    protected void onRenderContent(ImageBlock content) {
        String url = content.getImageUrl();

        Picasso.with(getContext())
                .load(url)
                .into(imageView);

        editorial.setContent(content.getEditorial());
    }

}
