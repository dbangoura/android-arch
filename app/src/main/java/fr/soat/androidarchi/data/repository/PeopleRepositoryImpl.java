package fr.soat.androidarchi.data.repository;

import fr.soat.androidarchi.data.model.People;
import fr.soat.androidarchi.data.model.PeopleListResult;
import fr.soat.androidarchi.data.repository.network.PeopleService;
import retrofit2.Callback;

public class PeopleRepositoryImpl implements PeopleRepository {
    @Override
    public void getPeopleAtPage(int page, Callback<PeopleListResult> callback) {
        PeopleService.getPeopleApi().getPeopleListAtPage(page)
                .enqueue(callback);
    }

    @Override
    public void getPeopleById(int id, Callback<People> callback) {
        PeopleService.getPeopleApi().getPeopleWithId(id)
                .enqueue(callback);
    }
}
