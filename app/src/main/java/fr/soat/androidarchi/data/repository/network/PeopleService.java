package fr.soat.androidarchi.data.repository.network;

import fr.soat.androidarchi.utils.Constants;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PeopleService {

    private static Retrofit retrofit;

    public static  PeopleApi getPeopleApi() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.SWAPI_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(PeopleApi.class);
    }
}
