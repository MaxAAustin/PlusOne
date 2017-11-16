package com.maxaaustin.plusone;

import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class GuestMap extends FragmentActivity implements OnMapReadyCallback {

    private final int LOCATION_REQUEST_CODE = 1;

    private final LatLng markMSB = new LatLng(39.627459, -79.961238);
    private final LatLng markCA = new LatLng(39.646834, -79.977523);
    private final LatLng markAER = new LatLng(39.646001, -79.971380);
    private final LatLng markCP = new LatLng(39.648296, -79.980465);


    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    private void enableCurrentLocation(){
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != android.content.pm.PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != android.content.pm.PackageManager.PERMISSION_GRANTED) {

            return;
        }else if (mMap != null){
        mMap.setMyLocationEnabled(true);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults){
        if(requestCode != LOCATION_REQUEST_CODE){
            return;
        }

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        //adds markers at several Morgantown locations
        LatLng wvu = new LatLng(39.634874, -79.953696);
        mMap.addMarker(new MarkerOptions().position(wvu).title("Mountain Lair"));
        mMap.addMarker(new MarkerOptions().position(markAER).title("Advanced Engin. Research"));
        mMap.addMarker(new MarkerOptions().position(markMSB).title("Mountain State Brewery"));
        mMap.addMarker(new MarkerOptions().position(markCA).title("Core Arboretum"));
        mMap.addMarker(new MarkerOptions().position(markCP).title("Coliseum Tailgate"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(wvu, 18));
        enableCurrentLocation();
    }
}
