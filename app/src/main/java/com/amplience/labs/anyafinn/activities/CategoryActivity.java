package com.amplience.labs.anyafinn.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.MenuItem;
import android.view.View;

import com.amplience.cms.content.delivery.OnContentItemLoaded;
import com.amplience.cms.content.delivery.model.ContentItem;
import com.amplience.labs.anyafinn.R;
import com.amplience.labs.anyafinn.content.view.common.StackFragment;
import com.amplience.labs.anyafinn.fragments.CategoriesFragment;
import com.amplience.labs.anyafinn.fragments.CategoryLandingFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryActivity extends AbstractActivity {

    @BindView(R.id.viewPager)
    ViewPager viewPager;

    @BindView(R.id.tabs)
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void createView() {
        setContentView(R.layout.activity_category);
        ButterKnife.bind(this);

        viewPager.setAdapter(new CategoryTabsAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    protected void createToolbar() {
        super.createToolbar();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public class CategoryTabsAdapter extends FragmentPagerAdapter {

        public CategoryTabsAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch(position) {
                case 0:
                    CategoryLandingFragment fragment = new CategoryLandingFragment();
                    fragment.setContentItemService(contentFacade.getContentItemService());
                    return fragment;
                case 1:
                    return new CategoriesFragment();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getIntent().getStringExtra("category").toUpperCase();
                case 1:
                    return "SUB-CATEGORIES";
            }
            return null;
        }

    }

}
