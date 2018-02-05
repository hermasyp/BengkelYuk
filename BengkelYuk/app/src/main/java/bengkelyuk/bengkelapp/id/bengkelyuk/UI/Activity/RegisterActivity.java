package bengkelyuk.bengkelapp.id.bengkelyuk.UI.Activity;

import android.app.ProgressDialog;
import android.support.design.widget.TextInputEditText;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import bengkelyuk.bengkelapp.id.bengkelyuk.Base.BaseActivity;
import bengkelyuk.bengkelapp.id.bengkelyuk.Models.Login.RequestResponse;
import bengkelyuk.bengkelapp.id.bengkelyuk.Models.User.User;
import bengkelyuk.bengkelapp.id.bengkelyuk.Networking.APIClient;
import bengkelyuk.bengkelapp.id.bengkelyuk.Networking.APIInterface;
import bengkelyuk.bengkelapp.id.bengkelyuk.R;
import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends BaseActivity {
    @BindView(R.id.txtNamaReg)TextInputEditText txtNamaReg;
    @BindView(R.id.txtAlamatReg)TextInputEditText txtAlamatReg;
    @BindView(R.id.txtNoTelpReg)TextInputEditText txtNoTelpReg;
    @BindView(R.id.txtPasswordReg)TextInputEditText txtPasswordReg;
    @BindView(R.id.txtEmailReg)TextInputEditText txtEmailReg;
    @BindView(R.id.btnDaftar)Button btnDaftar;
    private ProgressDialog mRegProgres;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind(R.layout.activity_register);
        setTitle("Register");
        mRegProgres = new ProgressDialog(this);

        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(fieldCheck() == true ){
                    mRegProgres.setTitle("Getting Data");
                    mRegProgres.setMessage("Please Wait...");
                    mRegProgres.setCanceledOnTouchOutside(false);
                    mRegProgres.show();
                    String nama = txtNamaReg.getText().toString().trim();
                    String alamat = txtAlamatReg.getText().toString().trim();
                    String telp = txtNoTelpReg.getText().toString().trim();
                    String email = txtEmailReg.getText().toString().trim();
                    String password = txtPasswordReg.getText().toString().trim();
                    APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
                    Call<RequestResponse> call = apiInterface.registerUser(new User(nama,email,alamat,telp,password));
                    call.enqueue(new Callback<RequestResponse>() {
                        @Override
                        public void onResponse(Call<RequestResponse> call, Response<RequestResponse> response) {
                            if(response.body().getSuccess() == true){
                                Toast.makeText(RegisterActivity.this, response.body().getInfo(), Toast.LENGTH_SHORT).show();
                                mRegProgres.dismiss();
                                finish();
                            }else{
                                mRegProgres.dismiss();
                                Toast.makeText(RegisterActivity.this, response.body().getInfo(), Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<RequestResponse> call, Throwable t) {
                            mRegProgres.dismiss();
                        }
                    });
                }
            }
        });
    }
    private Boolean fieldCheck(){
        Boolean fieldCheck = true;

        if(TextUtils.isEmpty(txtNamaReg.getText())){
            txtNamaReg.setError("Insert this Field!");
            fieldCheck = false;
        }
        if(TextUtils.isEmpty(txtAlamatReg.getText())){
            txtAlamatReg.setError("Insert this Field!");
            fieldCheck = false;
        }
        if(TextUtils.isEmpty(txtNoTelpReg.getText())){
            txtNoTelpReg.setError("Insert this Field!");
            fieldCheck = false;
        }
        if(TextUtils.isEmpty(txtEmailReg.getText())){
            txtEmailReg.setError("Insert this Field!");
            fieldCheck = false;
        }
        if(TextUtils.isEmpty(txtPasswordReg.getText())){
            txtPasswordReg.setError("Insert this Field!");
            fieldCheck = false;
        }

        return fieldCheck;
    }
}
