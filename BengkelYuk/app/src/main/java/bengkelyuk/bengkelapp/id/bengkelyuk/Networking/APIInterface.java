package bengkelyuk.bengkelapp.id.bengkelyuk.Networking;

import bengkelyuk.bengkelapp.id.bengkelyuk.Models.Bengkel.BengkelList;
import bengkelyuk.bengkelapp.id.bengkelyuk.Models.Booking.BookingList;
import bengkelyuk.bengkelapp.id.bengkelyuk.Models.Booking.UserBooking;
import bengkelyuk.bengkelapp.id.bengkelyuk.Models.Login.LoginRequest;
import bengkelyuk.bengkelapp.id.bengkelyuk.Models.Login.RequestResponse;
import bengkelyuk.bengkelapp.id.bengkelyuk.Models.Motor.ListMotor;
import bengkelyuk.bengkelapp.id.bengkelyuk.Models.Motor.Motor;
import bengkelyuk.bengkelapp.id.bengkelyuk.Models.User.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface APIInterface {
    @POST("/api/login")
    Call<RequestResponse> getLoginStatus(@Body LoginRequest request);

    @POST("/api/register")
    Call<RequestResponse> registerUser (@Body User user);

    @POST("/api/edituser")
    Call<RequestResponse> editUser (@Body User user);

    @GET("/api/user/{id_user}")
    Call<User> getUserData(@Path("id_user") int id_user);

    @GET("/api/bookingdata/{id_user}")
    Call<BookingList> getBookingData (@Path("id_user") int id_user);

    @GET("/api/allbengkel")
    Call<BengkelList> getAllBengkel();

    @GET("/api/allmotor")
    Call<ListMotor> getAllMotor();

    @POST("/api/booking")
    Call<RequestResponse> bookingInput (@Body UserBooking booking);

}
