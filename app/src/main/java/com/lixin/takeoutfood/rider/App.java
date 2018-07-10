package com.lixin.takeoutfood.rider;

import android.support.multidex.MultiDexApplication;

public class App extends MultiDexApplication {

    private static App app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }

    public static App getInstance() {
        return app;
    }
}
