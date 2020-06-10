package com.feedmycat.aii3_app2;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback {
  private GoogleMap map;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Set up the map
    SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
        .findFragmentById(R.id.map);
    mapFragment.getMapAsync(this);
  }


  @Override
  public void onMapReady(GoogleMap googleMap) {
    map = googleMap;
  }
}
