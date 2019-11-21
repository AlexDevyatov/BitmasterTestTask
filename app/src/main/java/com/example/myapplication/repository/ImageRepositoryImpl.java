package com.example.myapplication.repository;

import com.example.myapplication.service.ApiService;
import com.example.myapplication.model.Image;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Single;

public class ImageRepositoryImpl implements ImageRepository {

    private final String KEY = "acf517aa0540aea48493f524cf58225d";

    private ApiService service;

    public ImageRepositoryImpl(ApiService service) {
        this.service = service;
    }

    @Override
    public Single<List<Image>> loadImages(String keyWord, int perPage) {
        return service.getImages(KEY, perPage, keyWord);
    }

}
