package com.amplience.labs.anyafinn.content.model.anyafinn;

import com.amplience.cms.content.delivery.model.ContentItem;
import com.amplience.cms.content.delivery.serialization.ContentType;
import com.amplience.cms.content.rendering.android.ContentTypeFragment;
import com.amplience.labs.anyafinn.content.model.common.ContentGrid;
import com.amplience.labs.anyafinn.content.view.anyafinn.GridFragment;

import java.util.List;

@ContentType(pattern = "/grid.json")
@ContentTypeFragment(fragment = GridFragment.class)
public class Grid extends ContentItem implements ContentGrid {

    private List<ContentItem> gridContent;
    private Integer itemColumnsMobile;

    public Integer getItemColumnsMobile() {
        return itemColumnsMobile;
    }

    public void setItemColumnsMobile(Integer itemColumnsMobile) {
        this.itemColumnsMobile = itemColumnsMobile;
    }

    public List<ContentItem> getGridContent() {
        return gridContent;
    }

    public void setGridContent(List<ContentItem> gridContent) {
        this.gridContent = gridContent;
    }

    @Override
    public int getColumns() {
        return 1;
    }

    @Override
    public List<ContentItem> getChildren() {
        return getGridContent();
    }

}
