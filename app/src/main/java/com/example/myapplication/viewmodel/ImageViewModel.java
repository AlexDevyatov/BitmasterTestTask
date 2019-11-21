package com.example.myapplication.viewmodel;

import androidx.lifecycle.ViewModel;

import com.example.myapplication.model.Image;
import com.example.myapplication.repository.ImageRepository;

import javax.inject.Inject;

public class ImageViewModel extends BaseViewModel<Image> {

    @Inject
    ImageRepository repository;


    @Override
    protected void loadData() {

    }
}
