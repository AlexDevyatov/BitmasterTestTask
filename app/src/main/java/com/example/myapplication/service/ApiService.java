package com.example.myapplication.service;

import com.example.myapplication.model.ImagesResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("?method=flickr.photos.search&sort=relevance&content_type=1&page=1&media=photos&format=json&nojsoncallback=1")
    Single<ImagesResponse> getImages(@Query("api_key") String key, @Query("per_page") int perPage, @Query("text") String keyword);
}
