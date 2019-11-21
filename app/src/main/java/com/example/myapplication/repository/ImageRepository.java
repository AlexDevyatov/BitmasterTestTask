package com.example.myapplication.repository;

import com.example.myapplication.model.Image;
import com.example.myapplication.model.ImagesResponse;

import java.util.List;

import io.reactivex.Single;

public interface ImageRepository {

    public Single<ImagesResponse> loadImages(String keyword, int perPage);
}
