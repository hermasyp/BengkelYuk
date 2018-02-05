package bengkelyuk.bengkelapp.id.bengkelyuk.Models.Booking;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by herma on 17-Sep-17.
 */

public class Booking {

    public Booking(String namaUser, String namaBengkel, String namaTipe, String platNo, String tanggalService, String keluhan, String statusChecked) {
        this.namaUser = namaUser;
        this.namaBengkel = namaBengkel;
        this.namaTipe = namaTipe;
        this.platNo = platNo;
        this.tanggalService = tanggalService;
        this.keluhan = keluhan;
        this.statusChecked = statusChecked;
    }

    @SerializedName("id_booking")
    @Expose
    private String idBooking;
    @SerializedName("nama_user")
    @Expose
    private String namaUser;
    @SerializedName("nama_bengkel")
    @Expose
    private String namaBengkel;
    @SerializedName("nama_tipe")
    @Expose
    private String namaTipe;
    @SerializedName("plat_no")
    @Expose
    private String platNo;
    @SerializedName("tanggal_service")
    @Expose
    private String tanggalService;
    @SerializedName("keluhan")
    @Expose
    private String keluhan;
    @SerializedName("status_checked")
    @Expose
    private String statusChecked;

    public String getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(String idBooking) {
        this.idBooking = idBooking;
    }

    public String getNamaUser() {
        return namaUser;
    }

    public void setNamaUser(String namaUser) {
        this.namaUser = namaUser;
    }

    public String getNamaBengkel() {
        return namaBengkel;
    }

    public void setNamaBengkel(String namaBengkel) {
        this.namaBengkel = namaBengkel;
    }

    public String getNamaTipe() {
        return namaTipe;
    }

    public void setNamaTipe(String namaTipe) {
        this.namaTipe = namaTipe;
    }

    public String getPlatNo() {
        return platNo;
    }

    public void setPlatNo(String platNo) {
        this.platNo = platNo;
    }

    public String getTanggalService() {
        return tanggalService;
    }

    public void setTanggalService(String tanggalService) {
        this.tanggalService = tanggalService;
    }

    public String getKeluhan() {
        return keluhan;
    }

    public void setKeluhan(String keluhan) {
        this.keluhan = keluhan;
    }

    public String getStatusChecked() {
        return statusChecked;
    }

    public void setStatusChecked(String statusChecked) {
        this.statusChecked = statusChecked;
    }
}
