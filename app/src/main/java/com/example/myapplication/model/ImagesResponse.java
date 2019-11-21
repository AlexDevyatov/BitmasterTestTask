package com.example.myapplication.model;

import com.google.gson.annotations.SerializedName;

public class ImagesResponse {

    @SerializedName("photos")
    private Images images;

    public Images getResponse() {
        return images;
    }

    public void setResponse(Images images) {
        this.images = images;
    }
}
