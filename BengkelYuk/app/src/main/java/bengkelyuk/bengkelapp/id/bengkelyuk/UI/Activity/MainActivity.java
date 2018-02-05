package bengkelyuk.bengkelapp.id.bengkelyuk.UI.Activity;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
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

import java.util.HashMap;
import java.util.List;

import bengkelyuk.bengkelapp.id.bengkelyuk.Base.BaseActivity;
import bengkelyuk.bengkelapp.id.bengkelyuk.Models.Bengkel.Bengkel;
import bengkelyuk.bengkelapp.id.bengkelyuk.Models.Bengkel.BengkelList;
import bengkelyuk.bengkelapp.id.bengkelyuk.Networking.APIClient;
import bengkelyuk.bengkelapp.id.bengkelyuk.Networking.APIInterface;
import bengkelyuk.bengkelapp.id.bengkelyuk.R;
import bengkelyuk.bengkelapp.id.bengkelyuk.SessionManager.UserSession;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener, OnMapReadyCallback {
    private GoogleMap mMap;
    SupportMapFragment mapFragment;
    LatLng mLatlng;
    List<Bengkel> bengkelList ;
    HashMap<Marker, Bengkel> detailMarkerMap = new HashMap<>();
    private final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_profile) {
            startActivity(new Intent(this, ProfileActivity.class));
        } else if (id == R.id.nav_history) {
            startActivity(new Intent(this, HistoryActivity.class));

        } else if (id == R.id.nav_logout) {
            UserSession session = new UserSession(this);
            session.logoutUser();
            finish();
        }
        else if (id == R.id.nav_about) {
            showDialogAbout();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        setUpMap();
    }


    private void setUpMap() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        // Enable MyLocation Layer of Google Map
        mMap.setMyLocationEnabled(true);
        // Menggunakan LocationManager untuk menentukan posisi kamera
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        // Criteria digunakan untuk mengambil Location Mode pada device pengguna
        // Yang akan digunakan untuk mengambil lokasi terakhir pengguna
        Criteria criteria = new Criteria();
        Location location = locationManager.getLastKnownLocation(locationManager.getBestProvider(criteria, false));

        // Jika lokasi terakhir pengguna tidak ada...
        if (location != null)
        {
            // Geser posisi kamera pada peta sesuai dengan posisi pengguna
            CameraPosition cameraPosition = new CameraPosition.Builder()
                    .target(new LatLng(location.getLatitude(), location.getLongitude()))
                    .zoom(17)
                    .build();
            mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        }
        addMarkers();


    }

    private void addMarkers(){
        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<BengkelList> call = apiInterface.getAllBengkel();
        call.enqueue(new Callback<BengkelList>() {
            @Override
            public void onResponse(Call<BengkelList> call, Response<BengkelList> response) {
                bengkelList = response.body().getBengkel();
                Log.d(TAG, "onResponse: " + response.body().toString());
                for (int i = 0;i< bengkelList.size();i++){
                    mLatlng = new LatLng(Double.parseDouble(bengkelList.get(i).getLatitude()),
                            Double.parseDouble(bengkelList.get(i).getLongitude()));
                    Marker marker = mMap.addMarker(new MarkerOptions()
                            .position(mLatlng)
                            .title(bengkelList.get(i).getNamaBengkel())
                            .snippet("Booking Disini"));
                    detailMarkerMap.put(marker,bengkelList.get(i));
                }
                showToast("Getting Workshop Location Success");

            }

            @Override
            public void onFailure(Call<BengkelList> call, Throwable t) {
                showToast("Getting Workshop Location Failed");
            }
        });
        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                Intent i = new Intent(MainActivity.this,DetailsBengkel.class);
                i.putExtra("bengkel",detailMarkerMap.get(marker));
                startActivity(i);
                //showToast(detailMarkerMap.get(marker).getAlamatBengkel());
            }
        });
    }
    @Override
    public void onResume() {
        // Jika aplikasi dilanjutkan
        super.onResume();
        // Setup peta jika dibutuhkan
        if (mMap == null) {
            // Buat peta secara asynchronous
            mapFragment.getMapAsync(this);
        }
    }
    public void showDialogAbout(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        //alert.setTitle("About");
        // this is set the view from XML inside AlertDialog
        alert.setView(R.layout.dialog_about);
        // disallow cancel of AlertDialog on click of back button and outside touch
        alert.setCancelable(false);
        alert.setNegativeButton("Done", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getBaseContext(), "Thanks for using my apps", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();
    }

}
