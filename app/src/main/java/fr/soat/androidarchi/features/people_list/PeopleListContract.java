package fr.soat.androidarchi.features.people_list;

import java.util.List;

import fr.soat.androidarchi.data.model.PeopleListResult;
import fr.soat.androidarchi.data.model.SimplifiedPeople;
import fr.soat.androidarchi.features.base.BasePresenter;
import fr.soat.androidarchi.features.base.BaseView;

public interface PeopleListContract {

    interface View extends BaseView {
        void updatePeopleList(List<SimplifiedPeople> peopleList);
        void displayErrorMessage();
    }

    interface Presenter extends BasePresenter<View> {
        void getPeopleForPage(int page);
    }

    interface Interactor {
        void getPeopleAtPage(int page, PeopleListCallback callback);

        interface PeopleListCallback {
            void onPeopleListSuccess(PeopleListResult peopleListResult);
            void onError();
        }
    }
}
