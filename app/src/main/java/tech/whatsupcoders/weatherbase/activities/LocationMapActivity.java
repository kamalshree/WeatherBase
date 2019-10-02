package tech.whatsupcoders.weatherbase.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import tech.whatsupcoders.weatherbase.R;
import tech.whatsupcoders.weatherbase.adapters.ItemLocationCardAdapter;
import tech.whatsupcoders.weatherbase.models.Location;

public class LocationMapActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    ImageButton addButton;
    String addressVal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        addButton=findViewById(R.id.add_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("addressVal", addressVal);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        mapFragment.getMapAsync(this);

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

        // Add a marker in Chicago and move the camera
        LatLng myLocation = new LatLng(41.8781, -87.6298);
        mMap.addMarker(new MarkerOptions().position(myLocation).title("Marker in Chicago"));
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.getUiSettings().setZoomGesturesEnabled(true);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(myLocation));
        mMap.animateCamera( CameraUpdateFactory.zoomTo( 4.0f ) );

        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                mMap.clear();
                mMap.addMarker(new MarkerOptions().position(latLng));
                addressVal=getAddress(latLng.latitude,latLng.longitude);
                Toast.makeText(getApplicationContext(),
                        latLng.latitude + ", " + latLng.longitude + "," +addressVal,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private String getAddress(double latitude, double longitude) {
            String strAdd = "";
            Geocoder geocoder = new Geocoder(this, Locale.getDefault());
            try {
                List<Address> addresses = geocoder.getFromLocation(latitude, longitude, 1);
                if (addresses != null) {
                    String cityName = addresses.get(0).getLocality();
                    String stateName = addresses.get(0).getAdminArea();
                    String countryName = addresses.get(0).getCountryName();

                    strAdd = cityName+","+stateName+","+countryName;
                    Log.w("My Current location add", strAdd);
                } else {
                    Log.w("My Current location add", "No Address returned!");
                }
            } catch (Exception e) {
                e.printStackTrace();
                Log.w("My Current location add", "Cannot get Address!");
            }
            return strAdd;

    }

}
