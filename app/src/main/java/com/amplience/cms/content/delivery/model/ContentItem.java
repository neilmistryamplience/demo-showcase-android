package com.amplience.cms.content.delivery.model;

import android.databinding.BaseObservable;

public abstract class ContentItem extends BaseObservable {

    private ContentMetaData _meta;

    public ContentMetaData get_meta() {
        return _meta;
    }

    public void set_meta(ContentMetaData _meta) {
        this._meta = _meta;
    }

}
