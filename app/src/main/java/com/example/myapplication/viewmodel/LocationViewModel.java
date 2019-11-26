package com.example.myapplication.viewmodel;

import android.util.Log;

import com.example.myapplication.di.AppComponent;
import com.example.myapplication.model.Location;
import com.example.myapplication.model.LocationResponse;
import com.example.myapplication.repository.ImageRepositoryImpl;

import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LocationViewModel extends BaseViewModel<Location> {

    @Inject
    ImageRepositoryImpl repository;

    private long photoId;

    public LocationViewModel(AppComponent appComponent) {
        appComponent.inject(this);
    }

    public long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(long photoId) {
        this.photoId = photoId;
    }

    public void get() {
        loadData();
    }

    @Override
    protected void loadData() {
        repository.getImageLocation(photoId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<LocationResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(LocationResponse locationResponse) {
                        if (locationResponse.getLocationInfo() != null) {
                            data.postValue(locationResponse.getLocationInfo().getLocation());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("GetLocationRequest", "error");
                        e.printStackTrace();
                    }
                });
    }
}
