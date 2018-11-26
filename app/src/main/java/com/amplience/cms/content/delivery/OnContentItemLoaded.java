package com.amplience.cms.content.delivery;

import com.amplience.cms.content.delivery.model.ContentItem;

public interface OnContentItemLoaded {
    void onLoaded(Error error, ContentItem item);
}
