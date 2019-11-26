package com.example.myapplication.viewmodel;

import android.util.Log;

import com.example.myapplication.di.AppComponent;
import com.example.myapplication.model.Image;
import com.example.myapplication.model.ImagesResponse;
import com.example.myapplication.repository.ImageRepositoryImpl;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ImageViewModel extends BaseViewModel<List<Image>> {

    @Inject
    ImageRepositoryImpl repository;

    private static int page = 1;

    private String keyword = "";
    private final int perPage = 20;

    public ImageViewModel(AppComponent appComponent) {
        appComponent.inject(this);
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public static int getPage() {
        return page;
    }

    public static void setPage(int newPage) {
        page = newPage;
    }

    public static void incPage() {
        page++;
    }

    public int getPerPage() {
        return perPage;
    }

    public void request() {
        loadData();
    }

    @Override
    protected void loadData() {
        repository
                .loadImages(keyword, perPage, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<ImagesResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d("request", "subscribe");
                    }

                    @Override
                    public void onSuccess(ImagesResponse imagesResponse) {
                        Log.d("request", "success");
                        data.postValue(imagesResponse.getResponse().getImages());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("GetImagesRequest", "error");
                        e.printStackTrace();
                    }
                });
    }
}
