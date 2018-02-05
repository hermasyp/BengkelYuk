package bengkelyuk.bengkelapp.id.bengkelyuk.Models.Motor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by herma on 17-Sep-17.
 */

public class Motor {
    @SerializedName("id_tipe_motor")
    @Expose
    private String idTipeMotor;
    @SerializedName("nama_merk")
    @Expose
    private String namaMerk;
    @SerializedName("nama_tipe")
    @Expose
    private String namaTipe;

    public String getIdTipeMotor() {
        return idTipeMotor;
    }

    public void setIdTipeMotor(String idTipeMotor) {
        this.idTipeMotor = idTipeMotor;
    }

    public String getNamaMerk() {
        return namaMerk;
    }

    public void setNamaMerk(String namaMerk) {
        this.namaMerk = namaMerk;
    }

    public String getNamaTipe() {
        return namaTipe;
    }

    public void setNamaTipe(String namaTipe) {
        this.namaTipe = namaTipe;
    }
}
