package com.example.myapplication.viewmodel;

import android.annotation.SuppressLint;

import com.example.myapplication.model.Image;
import com.example.myapplication.repository.ImageRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ImageViewModel extends BaseViewModel<List<Image>> {

    @Inject
    ImageRepository repository;

    private String keyword;
    private int perPage;

    public ImageViewModel(String keyword, int perPage) {
        this.keyword = keyword;
        this.perPage = perPage;
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
