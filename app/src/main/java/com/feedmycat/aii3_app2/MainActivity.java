package com.feedmycat.aii3_app2;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback {
  private GoogleMap map;
  private List<MarkerObj> mMarkerObjs = new ArrayList<>();
  private FirebaseFirestore db = FirebaseFirestore.getInstance();
  private CollectionReference markersRef = db.collection("Markers");

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


  @Override
  protected void onStart() {
    super.onStart();
    markersRef.addSnapshotListener(this, new EventListener<QuerySnapshot>() {
      @Override
      public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots,
          @Nullable FirebaseFirestoreException e) {
        if (e != null) {
          return;
        }
        for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
          MarkerObj markerObj = documentSnapshot.toObject(MarkerObj.class);
          mMarkerObjs.add(markerObj);
        }
        for (MarkerObj markerObj :
            mMarkerObjs) {
          addMarker(markerObj.getTitle(), markerObj.getLatitude(), markerObj.getLongitude(), markerObj.getColor());
        }
      }
    });
  }

  private void addMarker(String title, double latitude, double longitude, String color) {
    LatLng latLng = new LatLng(latitude, longitude);
    Marker marker = map.addMarker(new MarkerOptions().position(latLng));
    marker.setTitle(title);
    switch (color) {
      case "Red": marker.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        break;
      case "Blue": marker.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
        break;
      case "Green": marker.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
        break;
      case "Yellow": marker.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
        break;
      case "Orange": marker.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE));
        break;
    }
  }
}
