package com.amplience.labs.anyafinn.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.amplience.labs.anyafinn.R;
import com.amplience.labs.anyafinn.activities.CategoryActivity;
import com.amplience.labs.anyafinn.activities.MainActivity;
import com.google.common.collect.Lists;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoriesFragment extends Fragment {

    @BindView(R.id.list)
    ListView list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup vg,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_categories, vg, false);
        ButterKnife.bind(this, view);

        List<String> categories = Lists.newArrayList();
        categories.add("Women");
        categories.add("Men");
        categories.add("Beauty");
        categories.add("Lighting");
        categories.add("Furniture");
        categories.add("Electrical");
        categories.add("Inspiration");

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                getContext(),
                android.R.layout.simple_list_item_1,
                categories);

        list.setAdapter(arrayAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startTransition(view, arrayAdapter.getItem(position));
            }
        });

        //2efd489b-6ebe-49fb-882d-cc8c858b8abb

        return view;
    }

    private void startTransition(View view, String category) {
        Intent intent = new Intent(view.getContext(), CategoryActivity.class);
        intent.putExtras(getActivity().getIntent());
        intent.putExtra("category", category);

//        Pair<View, String>[] transitionPairs = new Pair[3];
//        transitionPairs[0] = Pair.create(getActivity().findViewById(R.id.toolbar), "toolbar"); // Transition the Toolbar
//        //transitionPairs[1] = Pair.create(view, "content_area"); // Transition the content_area (This will be the content area on the detail screen)
////
////        // We also want to transition the status and navigation bar barckground. Otherwise they will flicker
//        transitionPairs[1] = Pair.create(getActivity().findViewById(android.R.id.statusBarBackground), Window.STATUS_BAR_BACKGROUND_TRANSITION_NAME);
//        transitionPairs[2] = Pair.create(getActivity().findViewById(android.R.id.navigationBarBackground), Window.NAVIGATION_BAR_BACKGROUND_TRANSITION_NAME);
//        Bundle b = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(), transitionPairs).toBundle();

        startActivity(intent);
    }

}
