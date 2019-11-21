package com.example.myapplication.di;

import com.example.myapplication.repository.ImageRepository;
import com.example.myapplication.repository.ImageRepositoryImpl;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface AppComponent {

    void inject(ImageRepository repository);

}
