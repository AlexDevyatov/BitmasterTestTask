package com.example.myapplication.service;

import com.example.myapplication.model.ImagesResponse;
import com.example.myapplication.model.LocationResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("?method=flickr.photos.search&sort=relevance&content_type=1&media=photos&format=json&nojsoncallback=1&has_geo=1")
    Single<ImagesResponse> getImages(@Query("api_key") String apikey, @Query("per_page") int perPage, @Query("page")int page, @Query("text") String keyword);

    @GET("?method=flickr.photos.geo.getLocation&format=json&nojsoncallback=1")
    Single<LocationResponse> getImageLocation(@Query("api_key") String apikey, @Query("photo_id") long photoId);
}
