package bengkelyuk.bengkelapp.id.bengkelyuk.Models.Bengkel;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by herma on 17-Sep-17.
 */

public class Bengkel implements Parcelable{

    @SerializedName("id_bengkel")
    @Expose
    private String idBengkel;
    @SerializedName("nama_bengkel")
    @Expose
    private String namaBengkel;
    @SerializedName("alamat_bengkel")
    @Expose
    private String alamatBengkel;
    @SerializedName("no_telp")
    @Expose
    private String noTelp;
    @SerializedName("hari_buka")
    @Expose
    private String hariBuka;
    @SerializedName("img_bengkel")
    @Expose
    private String imgBengkel;
    @SerializedName("longitude")
    @Expose
    private String longitude;
    @SerializedName("latitude")
    @Expose
    private String latitude;

    public Bengkel(String idBengkel, String namaBengkel, String alamatBengkel, String noTelp, String hariBuka, String imgBengkel, String longitude, String latitude) {
        this.idBengkel = idBengkel;
        this.namaBengkel = namaBengkel;
        this.alamatBengkel = alamatBengkel;
        this.noTelp = noTelp;
        this.hariBuka = hariBuka;
        this.imgBengkel = imgBengkel;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getIdBengkel() {
        return idBengkel;
    }

    public void setIdBengkel(String idBengkel) {
        this.idBengkel = idBengkel;
    }

    public String getNamaBengkel() {
        return namaBengkel;
    }

    public void setNamaBengkel(String namaBengkel) {
        this.namaBengkel = namaBengkel;
    }

    public String getAlamatBengkel() {
        return alamatBengkel;
    }

    public void setAlamatBengkel(String alamatBengkel) {
        this.alamatBengkel = alamatBengkel;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public String getHariBuka() {
        return hariBuka;
    }

    public void setHariBuka(String hariBuka) {
        this.hariBuka = hariBuka;
    }

    public Object getImgBengkel() {
        return imgBengkel;
    }

    public void setImgBengkel(String imgBengkel) {
        this.imgBengkel = imgBengkel;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.idBengkel);
        dest.writeString(this.namaBengkel);
        dest.writeString(this.alamatBengkel);
        dest.writeString(this.noTelp);
        dest.writeString(this.hariBuka);
        dest.writeString(this.imgBengkel);
        dest.writeString(this.longitude);
        dest.writeString(this.latitude);
    }
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Bengkel createFromParcel(Parcel in) {
            return new Bengkel(in);
        }

        public Bengkel[] newArray(int size) {
            return new Bengkel[size];
        }
    };

    public Bengkel(Parcel in) {
        this.idBengkel = in.readString();
        this.namaBengkel = in.readString();
        this.alamatBengkel = in.readString();
        this.noTelp = in.readString();
        this.hariBuka = in.readString();
        this.imgBengkel = in.readString();
        this.longitude = in.readString();
        this.latitude = in.readString();
    }
}
