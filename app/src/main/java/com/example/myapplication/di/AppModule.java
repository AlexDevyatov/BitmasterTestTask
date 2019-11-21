package com.example.myapplication.di;

import com.example.myapplication.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    App app;

    public AppModule(App app) {
        this.app = app;
    }

    @Provides
    @Singleton
    App providesApplication() {
        return app;
    }
}
