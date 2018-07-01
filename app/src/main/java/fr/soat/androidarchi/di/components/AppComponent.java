package fr.soat.androidarchi.di.components;

import dagger.Component;
import fr.soat.androidarchi.PeopleApplication;
import fr.soat.androidarchi.data.repository.PeopleRepository;
import fr.soat.androidarchi.di.modules.AppModule;
import fr.soat.androidarchi.di.scopes.AppScope;

@AppScope
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(PeopleApplication application);
    PeopleRepository getPeopleRepository();
}
