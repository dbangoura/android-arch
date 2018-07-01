package fr.soat.androidarchi.features.people_detail;

import fr.soat.androidarchi.data.model.People;
import fr.soat.androidarchi.data.repository.PeopleRepository;
import fr.soat.androidarchi.features.base.BaseInteractor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PeopleDetailInteractor extends BaseInteractor implements PeopleDetailContract.Interactor {

    public PeopleDetailInteractor(PeopleRepository peopleRepository) {
        super(peopleRepository);
    }

    @Override
    public void getPeopleWithId(int id, final GetPeopleDetailCallback callback) {
        getPeopleRepository().getPeopleById(id, new Callback<People>() {
            @Override
            public void onResponse(Call<People> call, Response<People> response) {
                if (response == null || (!response.isSuccessful() && response.errorBody() != null)) {
                    callback.onPeopleDetailError();
                } else {
                    callback.onPeopleDetailSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<People> call, Throwable t) {
                callback.onPeopleDetailError();
            }
        });
    }
}
