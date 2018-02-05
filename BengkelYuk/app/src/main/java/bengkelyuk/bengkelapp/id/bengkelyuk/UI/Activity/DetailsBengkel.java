package bengkelyuk.bengkelapp.id.bengkelyuk.UI.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import bengkelyuk.bengkelapp.id.bengkelyuk.Base.BaseActivity;
import bengkelyuk.bengkelapp.id.bengkelyuk.Models.Bengkel.Bengkel;
import bengkelyuk.bengkelapp.id.bengkelyuk.Networking.APIClient;
import bengkelyuk.bengkelapp.id.bengkelyuk.Networking.APIInterface;
import bengkelyuk.bengkelapp.id.bengkelyuk.R;
import bengkelyuk.bengkelapp.id.bengkelyuk.Utils.GlideApp;
import butterknife.BindView;

public class DetailsBengkel extends BaseActivity {
    @BindView(R.id.txtAlamatBengkel)TextView txtAlamatBengkel ;
    @BindView(R.id.txtJadwal)TextView txtJadwal ;
    @BindView(R.id.txtTelp) TextView txtTelp ;
    @BindView(R.id.txtNamaBengkel)TextView txtNamaBengkel ;
    @BindView(R.id.imgHeader) ImageView imgHeader;
    @BindView(R.id.btnBooking) Button btnBooking;
    private String id_bengkel;
    private Bengkel bengkel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind(R.layout.activity_details_bengkel);
        setTitle("Detail Bengkel");
        Bundle data = getIntent().getExtras();
        bengkel = data.getParcelable("bengkel");
        if(bengkel != null){
            id_bengkel = bengkel.getIdBengkel();
            txtAlamatBengkel.setText(bengkel.getAlamatBengkel());
            txtJadwal.setText(bengkel.getHariBuka());
            txtTelp.setText(bengkel.getNoTelp());
            txtNamaBengkel.setText(bengkel.getNamaBengkel());
            if(!bengkel.getImgBengkel().equals(null)){
                GlideApp.with(DetailsBengkel.this)
                        .load(bengkel.getImgBengkel())
                        .centerCrop()
                        .placeholder(R.drawable.placeholder)
                        .into(imgHeader);
            }
        }
        btnBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DetailsBengkel.this,BookingActivity.class);
                i.putExtra("id_bengkel",id_bengkel);
                startActivity(i);
            }
        });
    }
}
