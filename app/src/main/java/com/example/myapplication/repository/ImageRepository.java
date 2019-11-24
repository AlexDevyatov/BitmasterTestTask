package com.example.myapplication.repository;

import com.example.myapplication.model.ImagesResponse;

import io.reactivex.Single;

public interface ImageRepository {

    Single<ImagesResponse> loadImages(String keyword, int perPage, int page);
}
