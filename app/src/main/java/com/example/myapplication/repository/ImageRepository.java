package com.example.myapplication.repository;

import com.example.myapplication.model.Image;

import java.util.List;

import io.reactivex.Single;

public interface ImageRepository {

    public Single<List<Image>> loadImages(String keyword, int perPage);
}
