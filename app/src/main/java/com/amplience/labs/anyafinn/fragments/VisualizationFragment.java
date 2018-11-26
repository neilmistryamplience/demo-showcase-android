package com.amplience.labs.anyafinn.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amplience.cms.content.delivery.ContentItemService;
import com.amplience.cms.content.delivery.OnContentItemLoaded;
import com.amplience.cms.content.delivery.model.ContentItem;
import com.amplience.labs.anyafinn.R;
import com.amplience.labs.anyafinn.content.view.common.ContainerFragment;
import com.amplience.labs.anyafinn.model.ContentVisualization;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by darren on 12/11/2017.
 */

public class VisualizationFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.swipe_container)
    SwipeRefreshLayout swipeContainer;

    private ContainerFragment slot;

    private ContentVisualization visualization;
    private ContentItemService contentItemService;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup vg,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_visualization, vg, false);
        ButterKnife.bind(this, view);

        slot = (ContainerFragment) getChildFragmentManager().findFragmentById(R.id.content);

        swipeContainer.setOnRefreshListener(this);
        swipeContainer.setRefreshing(true);

        onRefresh();

        return view;
    }

    @Override
    public void onRefresh() {

        if(contentItemService == null || visualization == null) {
            return;
        }

        contentItemService.getById(visualization.getContentId(), new OnContentItemLoaded() {
            @Override
            public void onLoaded(Error error, ContentItem item) {
                if(item != null) {
                    slot.setContent(item);
                }
                swipeContainer.setRefreshing(false);
            }
        });

    }

    public ContentVisualization getVisualization() {
        return visualization;
    }

    public void setVisualization(ContentVisualization visualization) {
        this.visualization = visualization;
    }

    public ContentItemService getContentItemService() {
        return contentItemService;
    }

    public void setContentItemService(ContentItemService contentItemService) {
        this.contentItemService = contentItemService;
    }
}
