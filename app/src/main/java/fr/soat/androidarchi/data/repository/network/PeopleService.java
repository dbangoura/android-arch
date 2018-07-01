package fr.soat.androidarchi.data.repository.network;

import fr.soat.androidarchi.utils.Constants;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PeopleService {

    public static  PeopleApi getPeopleApi() {
        return new Retrofit.Builder()
                .baseUrl(Constants.SWAPI_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(PeopleApi.class);
    }
}
