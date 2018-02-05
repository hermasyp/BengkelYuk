package bengkelyuk.bengkelapp.id.bengkelyuk.Models.User;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by herma on 17-Sep-17.
 */

public class User {
    public User(String namaUser, String email, String alamat, String noTelp, String password) {
        this.namaUser = namaUser;
        this.email = email;
        this.alamat = alamat;
        this.noTelp = noTelp;
        this.password = password;
    }

    public User(String idUser, String namaUser, String email, String alamat, String noTelp, String password) {
        this.idUser = idUser;
        this.namaUser = namaUser;
        this.email = email;
        this.alamat = alamat;
        this.noTelp = noTelp;
        this.password = password;
    }

    @SerializedName("id_user")
    @Expose
    private String idUser;
    @SerializedName("nama_user")
    @Expose
    private String namaUser;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("alamat")
    @Expose
    private String alamat;
    @SerializedName("no_telp")
    @Expose
    private String noTelp;
    @SerializedName("password")
    @Expose
    private String password;

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getNamaUser() {
        return namaUser;
    }

    public void setNamaUser(String namaUser) {
        this.namaUser = namaUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
