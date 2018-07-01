package fr.soat.androidarchi.features.people_detail;

import javax.inject.Inject;

import fr.soat.androidarchi.data.model.People;
import fr.soat.androidarchi.features.base.BasePresenterImpl;

public class PeopleDetailPresenter extends BasePresenterImpl<PeopleDetailContract.View> implements PeopleDetailContract.Presenter, PeopleDetailContract.Interactor.GetPeopleDetailCallback {

    PeopleDetailContract.Interactor interactor;

   @Inject
    public PeopleDetailPresenter(PeopleDetailContract.Interactor interactor) {
        this.interactor = interactor;
    }

    @Override
    public void getPeopleDetail(int peopleId) {
        getView().showLoading();
        interactor.getPeopleWithId(peopleId, this);
    }

    @Override
    public void onPeopleDetailSuccess(People people) {
        getView().updatePeopleDetail(people);
        getView().hideLoading();
    }

    @Override
    public void onPeopleDetailError() {
        getView().displayErrorMessage();
        getView().hideLoading();
    }
}
