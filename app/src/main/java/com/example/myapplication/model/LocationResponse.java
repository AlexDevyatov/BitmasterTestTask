package com.example.myapplication.model;

import com.google.gson.annotations.SerializedName;

public class LocationResponse {

    @SerializedName("photo")
    private LocationInfo locationInfo;

    public LocationInfo getLocationInfo() {
        return locationInfo;
    }

    public void setLocationInfo(LocationInfo locationInfo) {
        this.locationInfo = locationInfo;
    }
}
