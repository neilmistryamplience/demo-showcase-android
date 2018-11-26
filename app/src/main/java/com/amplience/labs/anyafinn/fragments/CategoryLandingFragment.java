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
import com.amplience.labs.anyafinn.content.view.common.StackFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryLandingFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.swipe_container)
    SwipeRefreshLayout swipeContainer;

    private StackFragment bodySlot;
    private StackFragment heroSlot;

    private ContentItemService contentItemService;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup vg,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category_landing, vg, false);
        ButterKnife.bind(this, view);

//        heroSlot = (StackFragment) getChildFragmentManager().findFragmentById(R.id.heroSlot);
        bodySlot = (StackFragment) getChildFragmentManager().findFragmentById(R.id.bodySlot);

        swipeContainer.setOnRefreshListener(this);
        swipeContainer.setRefreshing(true);

        onRefresh();

        return view;
    }

    @Override
    public void onRefresh() {

        if(contentItemService == null) {
            return;
        }

//        contentItemService.getById("83bdebf1-3483-4622-a0e3-1dff9b663f7a", new OnContentItemLoaded() {
//            @Override
//            public void onLoaded(Error error, ContentItem item) {
//                if(item != null && item instanceof ContentItem) {
//                    heroSlot.setContent((ContentItem) item);
//                }
//                swipeContainer.setRefreshing(false);
//            }
//        });

        contentItemService.getById("2efd489b-6ebe-49fb-882d-cc8c858b8abb", new OnContentItemLoaded() {
            @Override
            public void onLoaded(Error error, ContentItem item) {
                if(item != null && item instanceof ContentItem) {
                    bodySlot.setContent((ContentItem) item);
                }
                swipeContainer.setRefreshing(false);
            }
        });

    }


    public ContentItemService getContentItemService() {
        return contentItemService;
    }

    public void setContentItemService(ContentItemService contentItemService) {
        this.contentItemService = contentItemService;
    }

}
