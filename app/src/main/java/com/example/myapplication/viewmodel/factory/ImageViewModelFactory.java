package com.example.myapplication.viewmodel.factory;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.di.AppComponent;
import com.example.myapplication.viewmodel.ImageViewModel;

public class ImageViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private final AppComponent appComponent;

    public ImageViewModelFactory(AppComponent appComponent) {
        this.appComponent = appComponent;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass == ImageViewModel.class) {
            return (T) new ImageViewModel(appComponent);
        }
        return null;
    }
}
