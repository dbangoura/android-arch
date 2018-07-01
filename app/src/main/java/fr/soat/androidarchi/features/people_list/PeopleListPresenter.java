package fr.soat.androidarchi.features.people_list;

import fr.soat.androidarchi.data.model.PeopleListResult;
import fr.soat.androidarchi.data.repository.PeopleRepository;
import fr.soat.androidarchi.data.repository.PeopleRepositoryImpl;
import fr.soat.androidarchi.features.base.BasePresenterImpl;

public class PeopleListPresenter extends BasePresenterImpl<PeopleListContract.View> implements PeopleListContract.Presenter, PeopleListContract.Interactor.PeopleListCallback {

    private PeopleListContract.Interactor interactor;


    public PeopleListPresenter() {
        PeopleRepository peopleRepository = new PeopleRepositoryImpl();
        interactor = new PeopleListInteractor(peopleRepository);
    }

    public PeopleListPresenter(PeopleListContract.Interactor interactor) {
        this.interactor = interactor;
    }

    @Override
    public void getPeopleForPage(int page) {
        interactor.getPeopleAtPage(page, this);
    }

    @Override
    public void onPeopleListSuccess(PeopleListResult peopleListResult) {
        getView().updatePeopleList(peopleListResult.getResults());
    }

    @Override
    public void onError() {
        getView().displayErrorMessage();
    }
}
