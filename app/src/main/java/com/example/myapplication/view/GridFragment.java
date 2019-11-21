package com.example.myapplication.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.adapter.ImagesAdapter;
import com.example.myapplication.model.Image;
import com.example.myapplication.viewmodel.ImageViewModel;

import java.util.ArrayList;
import java.util.List;

public class GridFragment extends Fragment {

    private final int SPAN_COUNT = 4;

    private RecyclerView recyclerView;
    private ImagesAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grid, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        layoutManager = new GridLayoutManager(getActivity(), SPAN_COUNT);
        recyclerView.setLayoutManager(layoutManager);
        List<Image> images = new ArrayList<>();
        mAdapter = new ImagesAdapter(images);

        ImageViewModel imageViewModel = ViewModelProviders.of(this).get(ImageViewModel.class);
        imageViewModel.getData().observe(this, this::updateImages);
        return view;
    }

    private void updateImages(List<Image> images) {
        mAdapter.updateImages(images);
    }
}