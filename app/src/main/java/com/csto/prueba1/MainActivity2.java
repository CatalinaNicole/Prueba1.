package com.csto.prueba1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity2 extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Spinner sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        sp=(Spinner) findViewById(R.id.spinner3);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings().setZoomControlsEnabled(true);

    }

    public void mapa(View v){

        if(sp.getSelectedItemPosition()==1) {

            LatLng Talca = new LatLng(-35.428130, -71.654545);
            mMap.addMarker(new MarkerOptions().position(Talca).title("Talca"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(Talca));
            mMap.moveCamera(CameraUpdateFactory.zoomTo(10));

        }else {
            if (sp.getSelectedItemPosition()==2) {

                LatLng Curico = new LatLng(-34.977641, -71.235428);
                mMap.addMarker(new MarkerOptions().position(Curico).title("Curico"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(Curico));
                mMap.moveCamera(CameraUpdateFactory.zoomTo(11));

            }else {
                if (sp.getSelectedItemPosition()==3) {

                    LatLng Santiago = new LatLng(-33.434662, -70.719135);
                    mMap.addMarker(new MarkerOptions().position(Santiago).title("Santiago"));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(Santiago));
                    mMap.moveCamera(CameraUpdateFactory.zoomTo(9));

                }
            }
        }
    }
}