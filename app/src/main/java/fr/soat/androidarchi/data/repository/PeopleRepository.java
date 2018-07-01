package fr.soat.androidarchi.data.repository;

import fr.soat.androidarchi.data.model.PeopleListResult;
import retrofit2.Callback;

public interface PeopleRepository {
    void getPeopleAtPage(int page, Callback<PeopleListResult> callback);
}
