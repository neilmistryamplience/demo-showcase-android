package com.amplience.cms.content.delivery;

public interface ContentItemService {
    void getById(String id, OnContentItemLoaded callback);
}
