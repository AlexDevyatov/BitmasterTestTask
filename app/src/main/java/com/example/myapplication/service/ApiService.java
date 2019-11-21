package com.example.myapplication.service;

import com.example.myapplication.model.Image;
import com.example.myapplication.model.ImagesResponse;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    @GET("?method=flickr.photos.search&api_key={api_key}&sort=relevance&content_type=1&per_page={per_page}&page=1&media=photos&format=json&text='{text}'")
    Single<ImagesResponse> getImages(@Path("api_key") String key, @Path("per_page") int perPage, @Path("text") String keyword);

}
