package bengkelyuk.bengkelapp.id.bengkelyuk.Networking;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import bengkelyuk.bengkelapp.id.bengkelyuk.BuildConfig;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by herma on 14-Sep-17.
 */

public class APIClient {
    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BuildConfig.URI)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }
}
