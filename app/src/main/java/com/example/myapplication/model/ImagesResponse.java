package com.example.myapplication.model;

import com.google.gson.annotations.SerializedName;

public class ImagesResponse {

    @SerializedName("photos")
    private Images images;

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }
}
