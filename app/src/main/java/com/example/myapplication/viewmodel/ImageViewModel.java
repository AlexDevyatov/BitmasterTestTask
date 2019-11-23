package com.example.myapplication.viewmodel;


import com.example.myapplication.di.AppComponent;
import com.example.myapplication.model.Image;
import com.example.myapplication.repository.ImageRepositoryImpl;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ImageViewModel extends BaseViewModel<List<Image>> {

    @Inject
    ImageRepositoryImpl repository;

    private final AppComponent appComponent;

    private String keyword;
    private final int perPage = 10;

    public ImageViewModel(AppComponent appComponent) {
        this.appComponent = appComponent;
        appComponent.inject(this);
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getPerPage() {
        return perPage;
    }

    public void loadImages() {
        loadData();
    }

    @Override
    protected void loadData() {
        repository
                .loadImages(keyword, perPage)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSuccess(imagesResponse -> data.postValue(imagesResponse.getResponse().getImages()));
    }
}
