package com.amplience.labs.anyafinn.content.view.accelerators;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.LinearLayout;

import com.amplience.cms.content.delivery.model.ContentItem;
import com.amplience.cms.content.rendering.android.ContentView;
import com.amplience.cms.content.rendering.android.butterknife.ButterknifeContentView;
import com.amplience.labs.anyafinn.R;
import com.amplience.labs.anyafinn.content.model.accelerators.Card;
import com.amplience.labs.anyafinn.content.model.accelerators.CardList;
import com.amplience.labs.anyafinn.content.model.common.ContentContainer;
import com.amplience.labs.anyafinn.content.view.common.CarouselFragment;
import com.google.common.collect.Lists;

import java.util.List;

import butterknife.BindView;

public class CardListFragment extends ButterknifeContentView<CardList> {

    @BindView(R.id.container)
    LinearLayout container;

    GridViewAdapter viewAdapter;

    public CardListFragment() {
        super(R.layout.fragment_accelerators_card_list);
    }

    protected void onRenderContent(CardList content) {
        renderContent(content);
        renderStyles(content);
    }

    private void renderContent(CardList content) {
        assert content instanceof ContentContainer;

        List<ContentItem> children = Lists.newArrayList();
        for(ContentItem child : ((ContentContainer)content).getChildren()) {
            if(child != null) {
                children.add(child);
            }
        }

        this.renderCollection(R.id.container, children);
    }

    private void renderStyles(CardList content) {

    }

    public class GridViewAdapter extends FragmentPagerAdapter {
        private List<ContentItem> content;

        public GridViewAdapter(List<ContentItem> content, FragmentManager fm) {
            super(fm);
            this.content = content;
        }

        @Override
        public Fragment getItem(int position) {
            ContentItem model = content.get(position);
            if(model == null) {
                return null;
            }

            ContentView fragment = createContentFragment(model);
            if(fragment != null) {
                fragment.setContent(model);
            }
            return (Fragment)fragment;
        }

        @Override
        public int getCount() {
            return content.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "";
        }
    }

}
