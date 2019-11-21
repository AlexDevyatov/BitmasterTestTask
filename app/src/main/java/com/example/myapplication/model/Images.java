package com.example.myapplication.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Images {

    @SerializedName("page")
    private Integer page;

    @SerializedName("pages")
    private Integer pages;

    @SerializedName("perpage")
    private Integer perPage;

    @SerializedName("total")
    private Integer total;

    @SerializedName("photo")
    private List<Image> images;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}
