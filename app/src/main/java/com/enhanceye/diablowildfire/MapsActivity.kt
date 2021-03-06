package com.enhanceye.diablowildfire

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
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
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sacramento and move the camera
        //val sydney = LatLng(-34.0, 151.0)
        val sacramento = LatLng(38.5616501,-121.5833428)
        val augustcf = LatLng(40.249134,-123.294563)
        val creekf = LatLng(37.353180,-119.201202)

        mMap.addMarker(MarkerOptions().position(augustcf).title("August Complex Fire"))
        mMap.addMarker(MarkerOptions().position(creekf).title("Creek Fire"))

        mMap.addMarker(MarkerOptions().position(sacramento).title("Center on California"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sacramento))
        mMap.moveCamera(CameraUpdateFactory.zoomTo(5.0.toFloat()))
    }
}