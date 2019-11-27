package com.example.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.example.myapplication.App;
import com.example.myapplication.R;
import com.example.myapplication.di.AppComponent;
import com.example.myapplication.model.Image;
import com.example.myapplication.viewmodel.LocationViewModel;
import com.example.myapplication.viewmodel.factory.LocationViewModelFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {

    private ArrayList<Image> images;
    private GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        images = getIntent().getParcelableArrayListExtra("images");

        AppComponent appComponent = ((App) getApplication()).getAppComponent();

        LocationViewModel locationViewModel = ViewModelProviders.of(this, new LocationViewModelFactory(appComponent)).get(LocationViewModel.class);
        locationViewModel.getData().observe(this, location -> {
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(new LatLng(location.getLatitude(), location.getLongitude()));
            map.addMarker(markerOptions);
        });
        for (Image image : images) {
            locationViewModel.setPhotoId(image.getId());
            locationViewModel.get();
        }
    }
}
