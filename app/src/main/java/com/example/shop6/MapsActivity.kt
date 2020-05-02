package com.example.shop6


import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.os.AsyncTask
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker

class MapsActivity : AppCompatActivity(), OnMapReadyCallback,
    GoogleMap.OnMarkerClickListener {




    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1
    }


    private lateinit var lastLocation: Location
    private lateinit var map: GoogleMap
    private lateinit var fusedLocationClient: FusedLocationProviderClient


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

    }


    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap

        map.uiSettings.isZoomControlsEnabled = true
        map.setOnMarkerClickListener(this)

        setUpMap()
        // 1
        map.isMyLocationEnabled = true

// 2
        fusedLocationClient.lastLocation.addOnSuccessListener(this) { location ->
            // Got last known location. In some rare situations this can be null.
            // 3
            if (location != null) {
                lastLocation = location
                val currentLatLng = LatLng(location.latitude, location.longitude)
                map.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLatLng, 12f))
            }
        }





    }

    fun hello(){

    }

    private inner class HitApi: AsyncTask<Void, Void, String> {
        var context:Context?=null
        var Lat:Double?=null
        var Lng:Double?=null
        var radius:Int?=null
        var type:String?=null

        constructor(context: Context,Lat: Double,  Lng: Double, radius: Int,type: String){
            this.context = context
            this.Lat = Lat
            this.Lng = Lng
            this.radius = radius
            this.type = type
        }

        override fun doInBackground(vararg params: Void?): String? {
            return placesapi().getplacesJSON(context as Context,Lat as Double,  Lng as Double, radius as Int,type as String)
        }

        private fun placesapi(): Any {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            
        }

//
//        override fun doInBackground(vararg params: Void?): String {
//

    }



    override fun onMarkerClick(p0: Marker?): Boolean{
        TODO("not implemented") //To change body of created functions
    }


    private fun setUpMap() {
        if (ActivityCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), LOCATION_PERMISSION_REQUEST_CODE)
            return
        }

    }


}

private fun Any.getplacesJSON(context: Context, d: Double, d1: Double, i: Int, s: String): String? {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}
