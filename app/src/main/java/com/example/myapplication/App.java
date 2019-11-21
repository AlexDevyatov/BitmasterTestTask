package com.example.myapplication;

import android.app.Application;

import com.example.myapplication.di.AppComponent;
import com.example.myapplication.di.AppModule;
import com.example.myapplication.di.DaggerAppComponent;
import com.example.myapplication.di.NetModule;

public class App extends Application {

    //key acf517aa0540aea48493f524cf58225d
    //secret dec539bbfa9fdfcf

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("https://api.flickr.com/services/rest/"))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
