package com.amplience.labs.anyafinn;

import android.content.Intent;

public class Application {

    private static Application INSTANCE;
    public static Application getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Application();
        }
        return INSTANCE;
    }


    public void activate(final Intent intent) {

    }


}
