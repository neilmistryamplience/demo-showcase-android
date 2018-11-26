package com.amplience.labs.anyafinn.content.view.common;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.amplience.cms.content.rendering.android.ContentView;
import com.amplience.labs.anyafinn.R;
import com.amplience.cms.content.rendering.android.butterknife.ButterknifeContentView;
import com.amplience.cms.content.delivery.model.ContentItem;
import com.amplience.labs.anyafinn.content.model.anyafinn.Carousel;
import com.amplience.labs.anyafinn.content.model.common.ContentContainer;
import com.google.common.collect.Lists;

import java.util.List;

import butterknife.BindView;

public class CarouselFragment extends ButterknifeContentView<ContentItem> {

    @BindView(R.id.viewPager)
    ViewPager viewPager;

    @BindView(R.id.tabs)
    TabLayout tabs;

    private CarouselPagerAdapter pagerAdapter;

    public CarouselFragment() {
        super(R.layout.fragment_content_containers_carousel);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tabs.setupWithViewPager(viewPager, true);
    }

    @Override
    protected void onRenderContent(ContentItem content) {
        assert content instanceof ContentContainer;

        List<ContentItem> children = Lists.newArrayList();
        for(ContentItem child : ((ContentContainer)content).getChildren()) {
            if(child != null) {
                children.add(child);
            }
        }

        pagerAdapter = new CarouselPagerAdapter(children, getChildFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(0);

        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.requestLayout();
                viewPager.invalidate();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


    public class CarouselPagerAdapter extends FragmentPagerAdapter {
        private List<ContentItem> content;

        public CarouselPagerAdapter(List<ContentItem> content, FragmentManager fm) {
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
