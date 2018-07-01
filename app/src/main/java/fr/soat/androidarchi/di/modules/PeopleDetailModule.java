package fr.soat.androidarchi.di.modules;

import dagger.Module;
import dagger.Provides;
import fr.soat.androidarchi.data.repository.PeopleRepository;
import fr.soat.androidarchi.di.scopes.PeopleDetailScope;
import fr.soat.androidarchi.features.people_detail.PeopleDetailContract;
import fr.soat.androidarchi.features.people_detail.PeopleDetailInteractor;
import fr.soat.androidarchi.features.people_detail.PeopleDetailPresenter;

@Module
public class PeopleDetailModule {

    @PeopleDetailScope
    @Provides
    PeopleDetailContract.Interactor providePeopleDetailInteractor(PeopleRepository peopleRepository) {
        return new PeopleDetailInteractor(peopleRepository);
    }

    @PeopleDetailScope
    @Provides
    PeopleDetailContract.Presenter providePeopleDetailPresenter(PeopleDetailContract.Interactor interactor) {
        return new PeopleDetailPresenter(interactor);
    }
}
