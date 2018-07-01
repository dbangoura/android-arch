package fr.soat.androidarchi.di.modules;

import dagger.Module;
import dagger.Provides;
import fr.soat.androidarchi.data.repository.PeopleRepository;
import fr.soat.androidarchi.data.repository.PeopleRepositoryImpl;
import fr.soat.androidarchi.di.scopes.AppScope;

@Module
public class AppModule {

    @AppScope
    @Provides
    PeopleRepository providePeopleRepository() {
        return new PeopleRepositoryImpl();
    }
}
