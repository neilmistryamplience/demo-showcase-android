package com.amplience.cms.content.rendering.android.butterknife;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amplience.cms.content.delivery.model.ContentItem;
import com.amplience.cms.content.rendering.android.basic.BasicContentView;
import com.google.common.base.Function;

import butterknife.ButterKnife;

public abstract class ConditionalButterknifeContentView<T extends ContentItem> extends BasicContentView<T> {

    public ConditionalButterknifeContentView() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup vg,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(content), vg, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        renderContent();
    }

    protected abstract void onRenderContent(T content);

    protected abstract int getLayout(T content);

}
