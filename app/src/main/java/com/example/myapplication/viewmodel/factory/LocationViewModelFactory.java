package com.example.myapplication.viewmodel.factory;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.di.AppComponent;
import com.example.myapplication.viewmodel.LocationViewModel;

public class LocationViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private final AppComponent appComponent;

    public LocationViewModelFactory(AppComponent appComponent) {
        this.appComponent = appComponent;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass == LocationViewModel.class) {
            return (T) new LocationViewModel(appComponent);
        }
        return null;
    }
}
