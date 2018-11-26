package com.amplience.cms.content.rendering.android;

import com.amplience.cms.content.delivery.ContentItemService;
import com.amplience.cms.content.delivery.model.ContentItem;

public interface ContentView<T extends ContentItem> {
    void setContent(T content);
}
