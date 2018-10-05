package com.example.taras.privatinfo.screens.fragments;

import android.annotation.SuppressLint;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.taras.privatinfo.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.Context.LOCATION_SERVICE;

public class MapFragment extends Fragment implements OnMapReadyCallback {
    private static final String LOG_TAG = MapFragment.class.getSimpleName();

    private GoogleMap mMap;
    LocationManager locationManager;
    LocationListener locationListener;

    private Marker myMarker = null;
    private float lastZoom = 20f;



    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_map, container, false);

        //ButterKnife.bind(this, rootView);
        return rootView;
    }

    @SuppressLint("MissingPermission")
    @Override
    public void onStart() {
        super.onStart();

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        locationManager = (LocationManager) getActivity().getSystemService(LOCATION_SERVICE);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                setMyLocationOnMap(location);
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMaxZoomPreference(21f);
    }

    private void setMyLocationOnMap(Location location){
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
        //get the location name from latitude and longitude
        Geocoder geocoder = new Geocoder(getContext());
        try {
            List<Address> addresses =
                    geocoder.getFromLocation(latitude, longitude, 1);
            String result = addresses.get(0).getLocality()+":";
            result += addresses.get(0).getCountryName();
            Log.d(LOG_TAG, result);

            LatLng latLng = new LatLng(latitude, longitude);

            if (myMarker == null){
                MarkerOptions myMarkerOptions = new MarkerOptions().position(latLng);
                myMarker = mMap.addMarker(myMarkerOptions);
                myMarker.setPosition(latLng);
            } else {
                myMarker.setPosition(latLng);
            }

            mMap.setMaxZoomPreference(20);
            lastZoom = mMap.getCameraPosition().zoom;
            lastZoom = 20f;
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, lastZoom));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
