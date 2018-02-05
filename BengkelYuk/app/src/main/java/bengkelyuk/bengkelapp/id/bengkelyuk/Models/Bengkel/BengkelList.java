package bengkelyuk.bengkelapp.id.bengkelyuk.Models.Bengkel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by herma on 17-Sep-17.
 */

public class BengkelList {
    @SerializedName("Bengkel")
    @Expose
    private List<Bengkel> bengkel = null;

    public List<Bengkel> getBengkel() {
        return bengkel;
    }

    public void setBengkel(List<Bengkel> bengkel) {
        this.bengkel = bengkel;
    }
}
