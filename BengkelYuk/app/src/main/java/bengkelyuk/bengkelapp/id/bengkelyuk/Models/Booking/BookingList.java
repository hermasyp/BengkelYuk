package bengkelyuk.bengkelapp.id.bengkelyuk.Models.Booking;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by herma on 17-Sep-17.
 */

public class BookingList {
    @SerializedName("UserBooking")
    @Expose
    private List<Booking> userBooking = null;

    public List<Booking> getUserBooking() {
        return userBooking;
    }

    public void setUserBooking(List<Booking> userBooking) {
        this.userBooking = userBooking;
    }
}
