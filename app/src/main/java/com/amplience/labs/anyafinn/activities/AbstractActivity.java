package com.amplience.labs.anyafinn.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

import com.amplience.labs.anyafinn.R;
import com.amplience.labs.anyafinn.content.ContentFacade;

public abstract class AbstractActivity extends AppCompatActivity {

    protected ContentFacade contentFacade;
    protected Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        contentFacade = ContentFacade.getOrCreate(getIntent());
        super.onCreate(savedInstanceState);
        createView();
        createToolbar();
    }

    protected abstract void createView();

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    protected void createToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setLogo(R.drawable.anyafinn_logo);
        toolbar.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        toolbar.setTitle("");
        toolbar.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        setSupportActionBar(toolbar);
    }

}
