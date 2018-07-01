package fr.soat.androidarchi.di.modules;

import dagger.Module;
import dagger.Provides;
import fr.soat.androidarchi.data.repository.PeopleRepository;
import fr.soat.androidarchi.di.scopes.PeopleListScope;
import fr.soat.androidarchi.features.people_list.PeopleListContract;
import fr.soat.androidarchi.features.people_list.PeopleListInteractor;
import fr.soat.androidarchi.features.people_list.PeopleListPresenter;

@Module
public class PeopleListModule {

    @PeopleListScope
    @Provides
    PeopleListContract.Interactor providePeopleListInteractor(PeopleRepository repository) {
        return new PeopleListInteractor(repository);
    }

    @PeopleListScope
    @Provides
    PeopleListContract.Presenter providePeopleListPresenter(PeopleListContract.Interactor interactor) {
        return new PeopleListPresenter(interactor);
    }
}
