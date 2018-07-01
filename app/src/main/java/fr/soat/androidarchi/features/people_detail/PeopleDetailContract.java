package fr.soat.androidarchi.features.people_detail;

import fr.soat.androidarchi.data.model.People;
import fr.soat.androidarchi.features.base.BasePresenter;
import fr.soat.androidarchi.features.base.BaseView;

public class PeopleDetailContract {

    interface View extends BaseView {
        void updatePeopleDetail(People people);
        void displayErrorMessage();
    }

    interface Presenter extends BasePresenter<View> {
        void getPeopleDetail(int peopleId);
    }

    interface Interactor {
        void getPeopleWithId(int id, GetPeopleDetailCallback callback);
        interface GetPeopleDetailCallback {
            void onPeopleDetailSuccess(People people);
            void onPeopleDetailError();
        }
    }
}
