package bengkelyuk.bengkelapp.id.bengkelyuk.Models.Login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by herma on 17-Sep-17.
 */

public class RequestResponse {
    @SerializedName("id_user")
    @Expose
    private String idUser;
    @SerializedName("Success")
    @Expose
    private Boolean success;
    @SerializedName("Info")
    @Expose
    private String info;

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

}
