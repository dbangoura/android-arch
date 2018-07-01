package fr.soat.androidarchi.features.people_list;

import javax.inject.Inject;

import fr.soat.androidarchi.data.model.PeopleListResult;
import fr.soat.androidarchi.data.repository.PeopleRepository;
import fr.soat.androidarchi.features.base.BaseInteractor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PeopleListInteractor extends BaseInteractor implements PeopleListContract.Interactor {

    @Inject
    public PeopleListInteractor(PeopleRepository peopleRepository) {
        super(peopleRepository);
    }

    @Override
    public void getPeopleAtPage(int page, final PeopleListCallback callback) {
        getPeopleRepository().getPeopleAtPage(page, new Callback<PeopleListResult>() {
            @Override
            public void onResponse(Call<PeopleListResult> call, Response<PeopleListResult> response) {
                if (response == null || (!response.isSuccessful() && response.errorBody() != null)) {
                    callback.onError();
                } else {
                    callback.onPeopleListSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<PeopleListResult> call, Throwable t) {
                callback.onError();
            }
        });
    }
}
