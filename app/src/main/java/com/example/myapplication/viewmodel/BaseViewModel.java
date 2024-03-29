package com.example.myapplication.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.service.ApiService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.inject.Inject;

public abstract class BaseViewModel<T> extends ViewModel {

    @Inject
    protected ApiService api;

    protected MutableLiveData<T> data;

    private ExecutorService service = Executors.newSingleThreadExecutor();

    public MutableLiveData<T> getData() {
        if (data == null) {
            data = new MutableLiveData<>();
        }
        service.submit(this::loadData);
        return data;
    }

    protected abstract void loadData();
}
