package com.amplience.labs.anyafinn.content.model.common;

import com.amplience.cms.content.delivery.model.ContentItem;

import java.util.List;

public interface ContentContainer {
    List<ContentItem> getChildren();
}
