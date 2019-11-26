package com.example.myapplication.repository;

import com.example.myapplication.model.ImagesResponse;
import com.example.myapplication.model.LocationResponse;
import com.example.myapplication.service.ApiService;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ImageRepositoryImpl implements ImageRepository {

    private final String KEY = "acf517aa0540aea48493f524cf58225d";

    private ApiService service;

    public ImageRepositoryImpl(ApiService service) {
        this.service = service;
    }

    @Override
    public Single<ImagesResponse> loadImages(String keyWord, int perPage, int page) {
        return service.getImages(KEY, perPage, page, keyWord)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Single<LocationResponse> getImageLocation(long photoId) {
        return service.getImageLocation(KEY, photoId);
    }

}
