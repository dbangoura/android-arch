package fr.soat.androidarchi.data.repository.network;

import fr.soat.androidarchi.data.model.PeopleListResult;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PeopleApi {

    @GET("people/")
    Call<PeopleListResult> getPeopleListAtPage(@Query("page") int page);

}
