package com.project.foodpipe.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.project.foodpipe.R;

public class MapTabView extends Activity {
  static final LatLng BANGALORE = new LatLng(12.9667, 77.5667);
  static final LatLng MYSORE = new LatLng(12.3000, 76.6500);
  private GoogleMap map;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.map_view_layout);
    map = ((MapFragment) getFragmentManager().findFragmentById(R.id.mapview))
        .getMap();
    map.setMyLocationEnabled(true);

    Marker bangalore = map.addMarker(new MarkerOptions().position(BANGALORE)
        .title("Vidyarthi Bhavan")
        .snippet("Basavanagudi, Bangalore")
        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher)));
    Marker kiel = map.addMarker(new MarkerOptions()
        .position(MYSORE)
        .title("Siddartha")
        .snippet("Kaveri Emporium, Mysore")
        .icon(BitmapDescriptorFactory
            .fromResource(R.drawable.ic_launcher)));
 //   kiel.showInfoWindow();
	
    // Move the camera instantly to hamburg with a zoom of 15.
    map.moveCamera(CameraUpdateFactory.newLatLngZoom(BANGALORE, 15));

    // Zoom in, animating the camera.
    map.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);
    //This method is used when we click on marker.
    //But requirement is to direct the user to details page when we click on infoWindo().
    
//    map.setOnMarkerClickListener(new OnMarkerClickListener()
//    {
//
//        @Override
//        public boolean onMarkerClick(Marker arg0) {
//            if(arg0.getTitle().equals("Kiel")) {// if marker source is clicked
//                Intent goToDetailsPage = new Intent(MapTabView.this,DetailsActivity.class);
//        	startActivity(goToDetailsPage);
//            }
//            return true;
//        }
//
//    });   

    //This is infoWindo click listener. ie, the pop up which is showed when we click on marker.
    map.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {

        @Override
        public void onInfoWindowClick(Marker marker) {
        	 if(marker.getTitle().equals("Vidyarthi Bhavan")) {// if marker source is clicked
                 Intent goToDetailsPage = new Intent(MapTabView.this,DetailsActivity.class);
         	startActivity(goToDetailsPage);
             }
        	 else if(marker.getTitle().equals("Siddartha")){
        		 Intent goToDetailsPage = new Intent(MapTabView.this,DetailsActivity.class);
              	startActivity(goToDetailsPage);
        	 }
            
        }
    });

  }
  
  
}