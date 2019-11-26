package com.example.myapplication.model;

import com.google.gson.annotations.SerializedName;

public class LocationInfo {

    @SerializedName("id")
    private Long id;
    @SerializedName("location")
    private Location location;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
