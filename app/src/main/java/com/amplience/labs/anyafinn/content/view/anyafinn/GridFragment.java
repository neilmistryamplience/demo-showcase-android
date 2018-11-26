package com.amplience.labs.anyafinn.content.view.anyafinn;

import android.widget.LinearLayout;

import com.amplience.cms.content.rendering.android.butterknife.ButterknifeContentView;
import com.amplience.labs.anyafinn.R;
import com.amplience.cms.content.delivery.model.ContentItem;
import com.amplience.cms.content.rendering.android.ContentTypeFragment;
import com.amplience.labs.anyafinn.content.model.anyafinn.Grid;
import com.amplience.labs.anyafinn.content.model.common.ContentContainer;
import com.amplience.labs.anyafinn.content.model.common.ContentGrid;
import com.google.common.collect.Lists;

import java.util.List;

import butterknife.BindView;

public class GridFragment extends ButterknifeContentView<ContentItem> {

    //@BindView(R.id.grid)
    //GridLayout grid;

    @BindView(R.id.grid)
    LinearLayout linearLayout;

    public GridFragment() {
        super(R.layout.fragment_content_containers_grid);
    }

    @Override
    protected void onRenderContent(ContentItem content) {

        assert content instanceof ContentGrid;

        List<ContentItem> children = Lists.newArrayList();
        for(ContentItem child : ((ContentContainer)content).getChildren()) {
            if(child != null) {
                children.add(child);
            }
        }


        int size = children.size();

        int columns = ((ContentGrid)content).getColumns();
//        if(content.getItemColumnsMobile() != null) {
//            columns = content.getItemColumnsMobile();
//        }else{
//            columns = Math.min(1, size);
//        }

        List<GridRowData> gridContent = Lists.newArrayList();

        for(int i=0; i < children.size(); i++) {
            ContentItem item = children.get(i);
            int row = (int)Math.floor(i / columns);
            if(row >= gridContent.size()) {
                gridContent.add(new GridRowData());
            }
            gridContent.get(row).getItems().add(item);
        }

        renderCollection(R.id.grid, gridContent);
    }


    public static class GridCell extends ButterknifeContentView<ContentItem> {

        @BindView(R.id.container)
        LinearLayout container;

        public GridCell() {
            super(R.layout.fragment_content_containers_grid_cell);
        }

        @Override
        protected void onRenderContent(ContentItem content) {
            renderCollection(R.id.container, Lists.<ContentItem>newArrayList(content));
        }
    }


    public static class GridRow extends ButterknifeContentView<GridRowData> {
        @BindView(R.id.container)
        LinearLayout container;

        public GridRow() {
            super(R.layout.fragment_content_containers_grid_row);
        }

        @Override
        protected void onRenderContent(GridRowData content) {
            container.setWeightSum(content.getItems().size());
            renderCollection(R.id.container, content.getItems(), GridCell.class, null);
        }
    }

    @ContentTypeFragment(fragment = GridRow.class)
    public static class GridRowData extends ContentItem {
        private List<ContentItem> items = Lists.newArrayList();

        public List<ContentItem> getItems() {
            return items;
        }

        public void setItems(List<ContentItem> items) {
            this.items = items;
        }
    }

}
