package bengkelyuk.bengkelapp.id.bengkelyuk.UI.Activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import bengkelyuk.bengkelapp.id.bengkelyuk.Adapter.RVAdapterHistory;
import bengkelyuk.bengkelapp.id.bengkelyuk.Base.BaseActivity;
import bengkelyuk.bengkelapp.id.bengkelyuk.Models.Booking.Booking;
import bengkelyuk.bengkelapp.id.bengkelyuk.Models.Booking.BookingList;
import bengkelyuk.bengkelapp.id.bengkelyuk.Networking.APIClient;
import bengkelyuk.bengkelapp.id.bengkelyuk.Networking.APIInterface;
import bengkelyuk.bengkelapp.id.bengkelyuk.R;
import bengkelyuk.bengkelapp.id.bengkelyuk.SessionManager.UserSession;
import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HistoryActivity extends BaseActivity {
    @BindView(R.id.rvHistory) RecyclerView rvHistory;
    List<Booking> bookings ;
    private static String TAG = "HistoryActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Booking History");
        bind(R.layout.activity_history);
        rvHistory.setLayoutManager(new LinearLayoutManager(this));
        getData();
    }

        private void getData(){
            int id_user = new UserSession(HistoryActivity.this).getUserID();
            APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
            Call<BookingList> call = apiInterface.getBookingData(id_user);
            Log.d(TAG, "getData: " + call.request().url());
            call.enqueue(new Callback<BookingList>() {
                @Override
                public void onResponse(Call<BookingList> call, Response<BookingList> response) {
                    bookings = response.body().getUserBooking();
                    RVAdapterHistory adapterHistory = new RVAdapterHistory(HistoryActivity.this,bookings);
                    rvHistory.setAdapter(adapterHistory);
                }

                @Override
                public void onFailure(Call<BookingList> call, Throwable t) {
                    showToast("Gagal");
                }
            });
        }

}
