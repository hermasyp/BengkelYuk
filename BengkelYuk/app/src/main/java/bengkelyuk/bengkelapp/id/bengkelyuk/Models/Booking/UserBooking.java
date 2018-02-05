package bengkelyuk.bengkelapp.id.bengkelyuk.Models.Booking;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by herma on 17-Sep-17.
 */

public class UserBooking {
    @SerializedName("id_user")
    @Expose
    private String idUser;
    @SerializedName("id_bengkel")
    @Expose
    private String idBengkel;
    @SerializedName("id_tipe_motor")
    @Expose
    private String idTipeMotor;
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

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getIdBengkel() {
        return idBengkel;
    }

    public void setIdBengkel(String idBengkel) {
        this.idBengkel = idBengkel;
    }

    public String getIdTipeMotor() {
        return idTipeMotor;
    }

    public void setIdTipeMotor(String idTipeMotor) {
        this.idTipeMotor = idTipeMotor;
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
