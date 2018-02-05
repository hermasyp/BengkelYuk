package bengkelyuk.bengkelapp.id.bengkelyuk.Base;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import butterknife.ButterKnife;

/**
 * Created by herma on 14-Sep-17.
 */

public class BaseActivity extends AppCompatActivity {
    protected Boolean connStatus;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        checkInternet();

    }
    private void checkInternet(){

        ConnectivityManager ConnectionManager =(ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=ConnectionManager.getActiveNetworkInfo();
        if(networkInfo != null && networkInfo.isConnected()==true ) {
            connStatus = true;
        }
        else {
            connStatus = false;
            showToast("No Internet Connection");
        }
    }

    protected void bind(int layout){
        setContentView(layout);
        ButterKnife.bind(this);
    }
    protected void showToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
