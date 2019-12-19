package com.example.onlineshoppingapp;

import androidx.fragment.app.FragmentActivity;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    EditText edtLocation;
    Button btnShowLoaction;
    MyLocationListener myLocationListener;
    LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);


        myLocationListener = new MyLocationListener(getApplicationContext());
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        try {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 6000, 0, myLocationListener);
        }catch (SecurityException ex) {
            Toast.makeText(MapsActivity.this, "You Are No Allow to acces current loatcion", Toast.LENGTH_SHORT).show();
        }
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(30.04441960, 31.235711600), 8));

        btnShowLoaction = (Button) findViewById(R.id.btnshowmyloction);
        btnShowLoaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMap.clear();
                Geocoder coder = new Geocoder(getApplicationContext());
                List<Address> addressList;
                Location loc = null;
                try {
                    loc = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                } catch (SecurityException e) {
                    Toast.makeText(MapsActivity.this, "You Are Not Allow To Acces Current Locations", Toast.LENGTH_SHORT).show();
                }

                if(loc != null) {
                    LatLng myLocation = new LatLng(loc.getLatitude(), loc.getLongitude());
                    try {
                        addressList = coder.getFromLocation(myLocation.latitude, myLocation.longitude, 1);
                        if(!addressList.isEmpty()) {
                            String Address = null;
                            for(int i = 0; i <= addressList.get(0).getMaxAddressLineIndex(); i++) {
                                Address += addressList.get(0).getAddressLine(i) + ", ";
                            }
                            mMap.addMarker(new MarkerOptions().position(myLocation).title("My Location").snippet(Address)).setDraggable(true);
                            edtLocation.setText(Address);
                        }
                    } catch (IOException ioe) {
                        mMap.addMarker(new MarkerOptions().position(myLocation).title("My Loaction"));
                    }
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(myLocation, 15));
                } else {
                    Toast.makeText(MapsActivity.this, "Plaese Wait until locatio is detemined", Toast.LENGTH_SHORT).show();
                }

            }
        });
        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}
