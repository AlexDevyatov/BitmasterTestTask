package com.example.myapplication.repository;

import com.example.myapplication.model.Image;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

public class ImageRepositoryImpl implements ImageRepository {

    @Override
    public Single<List<Image>> loadImages() {
        return null;
    }

}
