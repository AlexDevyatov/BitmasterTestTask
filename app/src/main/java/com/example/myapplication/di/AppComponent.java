package com.example.myapplication.di;

import com.example.myapplication.repository.ImageRepository;
import com.example.myapplication.repository.ImageRepositoryImpl;
import com.example.myapplication.viewmodel.ImageViewModel;
import com.example.myapplication.viewmodel.LocationViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface AppComponent {

    void inject(ImageRepository repository);

    void inject(ImageViewModel imageViewModel);

    void inject(LocationViewModel locationViewModel);
}
