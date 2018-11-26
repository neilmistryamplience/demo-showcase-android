package com.amplience.labs.anyafinn.content.view.accelerators;


import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import com.amplience.cms.content.rendering.android.butterknife.ButterknifeContentView;
import com.amplience.labs.anyafinn.R;
import com.amplience.labs.anyafinn.content.model.accelerators.Banner;
import com.amplience.labs.anyafinn.content.model.accelerators.Video;
import com.squareup.picasso.Picasso;

import butterknife.BindView;

public class VideoFragment extends ButterknifeContentView<Video> {

    @BindView(R.id.videoView)
    VideoView videoView;

    MediaController mediaController;

    public VideoFragment() {
        super(R.layout.fragment_accelerators_video);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup vg, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, vg, savedInstanceState);
        mediaController = new MediaController(getActivity());


        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        return view;
    }

    @Override
    protected void onRenderContent(Video content) {
        String url = content.getVideo().getVideoUrl("mp4_720p");

        videoView.setVideoURI(Uri.parse(url));
        videoView.start();
        videoView.requestFocus();
    }

}
