package fr.istic.ccn2.ftedelascience.activity;

import android.Manifest;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import fr.istic.ccn2.ftedelascience.R;
import fr.istic.ccn2.ftedelascience.model.MapsEvent;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, LocationListener {

    private GoogleMap mMap;
    private Marker currenLocationMarker;
    private LatLng currentLocationLatlng;
    private DatabaseReference db;
    private List<MapsEvent> mapsEvents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps2);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        startGettingLocation();
        db =FirebaseDatabase.getInstance().getReference().child("eventsScience");
        getMarkers();

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
        // Add a marker in Sydney and move the camera
        LatLng recife = new LatLng(45.4203227, 3.048898);
        mMap.addMarker(new MarkerOptions().position(recife).title("Marker in recife"));
        CameraPosition camera = new CameraPosition.Builder().zoom(5).target(recife).build();
        mMap.moveCamera(CameraUpdateFactory.newLatLng(recife));

        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(camera));
    }

    @Override
    public void onLocationChanged(Location location) {
        if (currenLocationMarker != null){
            currenLocationMarker.remove();
        }
        //add Marker
        currentLocationLatlng = new LatLng(location.getLatitude(), location.getLongitude());
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(currentLocationLatlng);
        markerOptions.title("Location actuelle");
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
        currenLocationMarker = mMap.addMarker(markerOptions);
        //move to new location
        CameraPosition cameraPosition = new CameraPosition.Builder().zoom(5).target(currentLocationLatlng).build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        MapsEvent locationData = new MapsEvent(location.getLatitude(), location.getLongitude());
        Toast.makeText(this, "Location", Toast.LENGTH_SHORT).show();
        getMarkers();
    }

    private void getMarkers(){
        mapsEvents = new ArrayList<MapsEvent>();
        int i = 1;
        while (i < 100) {
            db = FirebaseDatabase.getInstance().getReference().child("eventsScience").child(Integer.toString(i));
            i++;
            db.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    double latitude = dataSnapshot.child("fields").child("geolocalisation").child("0").getValue(Double.class);
                    double longitude = dataSnapshot.child("fields").child("geolocalisation").child("1").getValue(Double.class);
                    String Titre = dataSnapshot.child("fields").child("title_fr").getValue(String.class);
                    MapsEvent mapsEvent = new MapsEvent(latitude, longitude);
                    Log.i("laaaaat", String.valueOf(mapsEvent.getLatitude()));
                    Log.i("laaaaat", String.valueOf(mapsEvent.getLongitude()));
                    mapsEvents.add(mapsEvent);
                    if (mapsEvents.size() != 0){
                        getAllGeolocalisation((ArrayList<MapsEvent>) mapsEvents);
                    }
                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
    }

    private void getAllGeolocalisation(ArrayList<MapsEvent> locations) {
        for (MapsEvent mapsEvent : mapsEvents) {
           // Log.i("events", String.valueOf(mapsEvent.getLatitude()));
            //Date newDate = new Date(Long.valueOf((long) mapsEvent.getLatitude()));
          //  Map singleLocation = (Map) entry.getValue();
            LatLng latLng = new LatLng(mapsEvent.getLatitude(), mapsEvent.getLongitude());
            addGreenMarker(latLng);
        }
    }

    private void addGreenMarker(LatLng latLng) {
       // SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        //markerOptions.title(dt.format(newDate));
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
        mMap.addMarker(markerOptions);
    }

   private boolean hasPermission(String permission){
        if (canAskPermission()){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                return (checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED);
            }
        }
        return true;
    }

    private boolean canAskPermission() {
        return (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1);
    }
    public void showSettingAlert () {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("GPS dialogue");
        alertDialog.setMessage("Activer GPS");
        alertDialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
            }
        });
        alertDialog.setNegativeButton("non", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
    }
   private ArrayList<String> findUnAskedPermissions(ArrayList<String> permissions) {
        ArrayList result = new ArrayList();
        for (String pern : permissions){
            if (!hasPermission(pern)){
                result.add(pern);
            }
        }
        return result;
    }

    public void startGettingLocation(){
        LocationManager locationManager= (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        boolean isGPS  = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        boolean isNetWork = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        boolean canGetLocation = true;
        int All_PERMISSIONS_RESULT = 101;
        long MIN_DISTANCE_CHANGE_FOR_UPDATES = 10; // distance in meters
        long MIN_TIME_BW_UPDATES = 1000*10; // time in milliseconde

        ArrayList<String> permissions = new ArrayList<>();
        ArrayList<String> permissionsToRequest;

        permissions.add(Manifest.permission.ACCESS_FINE_LOCATION);
        permissions.add(Manifest.permission.ACCESS_COARSE_LOCATION);
        permissionsToRequest = findUnAskedPermissions(permissions);

        if (!isGPS && !isNetWork){
            showSettingAlert();
        }

        else {
            //check permmissions
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                if (permissionsToRequest.size() > 0 ){
                    requestPermissions(permissionsToRequest.toArray(new String[permissionsToRequest.size()]),
                            All_PERMISSIONS_RESULT);
                    canGetLocation = false;
                }
            }

        }
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
        ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this, "Permission" , Toast.LENGTH_SHORT).show();
            return;
        }

        if (canGetLocation){
            if (isGPS){
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, MIN_TIME_BW_UPDATES, MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
            }else if (isNetWork){
                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, MIN_TIME_BW_UPDATES,MIN_DISTANCE_CHANGE_FOR_UPDATES,this);
            }
        }else {
            Toast.makeText(this, "localisation", Toast.LENGTH_SHORT).show();
        }

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



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //ajoute les entrées de menu_test à l'ActionBar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.carte:
                startActivity( new Intent(this, MapsActivity.class));
                return true;
            case R.id.liste:
                startActivity(new Intent(this, Event_Activity.class));
                return true;
            case R.id.parcours:

        }

        return super.onOptionsItemSelected(item);
    }

}
/*  db.child("fields").child("geolocalisation").addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.getValue() != null){
                            getAllGeolocalisation((Map<String,Object>) dataSnapshot.getValue());
                        }
                    }*/