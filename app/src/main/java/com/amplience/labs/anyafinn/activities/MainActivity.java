package com.amplience.labs.anyafinn.activities;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.amplience.cms.content.delivery.ContentDeliveryClient;
import com.amplience.cms.content.delivery.ContentItemService;
import com.amplience.cms.content.delivery.ContentItemServiceImpl;
import com.amplience.cms.content.delivery.serialization.ContentItemDeserializer;
import com.amplience.labs.anyafinn.R;
import com.amplience.labs.anyafinn.content.ContentFacade;
import com.amplience.labs.anyafinn.content.model.accelerators.Banner;
import com.amplience.labs.anyafinn.content.model.accelerators.Card;
import com.amplience.labs.anyafinn.content.model.accelerators.CardList;
import com.amplience.labs.anyafinn.content.model.accelerators.FlexibleSlot;
import com.amplience.labs.anyafinn.content.model.accelerators.HeroSlot;
import com.amplience.labs.anyafinn.content.model.accelerators.Image;
import com.amplience.labs.anyafinn.content.model.accelerators.Slider;
import com.amplience.labs.anyafinn.content.model.accelerators.SplitBlock;
import com.amplience.labs.anyafinn.content.model.accelerators.Text;
import com.amplience.labs.anyafinn.content.model.accelerators.Video;
import com.amplience.labs.anyafinn.content.model.anyafinn.HeroBlock;
import com.amplience.labs.anyafinn.content.model.anyafinn.ImageBlock;
import com.amplience.labs.anyafinn.content.model.anyafinn.TextBlock;
import com.amplience.labs.anyafinn.content.model.anyafinn.Carousel;
import com.amplience.labs.anyafinn.content.model.anyafinn.Grid;
import com.amplience.labs.anyafinn.content.model.anyafinn.Page;
import com.amplience.labs.anyafinn.content.model.anyafinn.Stack;
import com.amplience.labs.anyafinn.fragments.CategoriesFragment;
import com.amplience.labs.anyafinn.fragments.HomeFragment;
import com.amplience.labs.anyafinn.model.ContentSettings;
import com.amplience.labs.anyafinn.fragments.VisualizationFragment;

public class MainActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    private ContentFacade contentFacade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        contentFacade = ContentFacade.getOrCreate(getIntent());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setLogo(R.drawable.anyafinn_logo);
        toolbar.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        toolbar.setTitle("");
        toolbar.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayUseLogoEnabled(true);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        if(contentFacade.getContentSettings().hasVisualization()) {
            tabLayout.getTabAt(2).select();
        }

        onRefresh();
    }

    private void onRefresh() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        private HomeFragment home;
        private CategoriesFragment categories;
        private VisualizationFragment visualization;

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            switch(position) {
                case 0:
                    if(home == null) {
                        home = new HomeFragment();
                        home.setContentItemService(contentFacade.getContentItemService());
                    }
                    return home;
                case 1:
                    if(categories == null) {
                        categories = new CategoriesFragment();
                    }
                    return categories;
                case 2:
                    if(visualization == null) {
                        visualization = new VisualizationFragment();
                        visualization.setContentItemService(contentFacade.getContentItemService());
                        visualization.setVisualization(contentFacade.getContentSettings().getVisualization());
                    }
                    return visualization;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            if(contentFacade.getContentSettings().hasVisualization()) {
                return 3;
            }else {
                return 2;
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "HOME";
                case 1:
                    return "CATEGORIES";
                case 2:
                    return "VISUALIZATION";
            }
            return null;
        }
    }
}
