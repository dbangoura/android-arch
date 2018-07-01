package fr.soat.androidarchi.di.components;

import dagger.Component;
import fr.soat.androidarchi.di.modules.PeopleListModule;
import fr.soat.androidarchi.di.scopes.PeopleListScope;
import fr.soat.androidarchi.features.people_list.PeopleListActivity;

@PeopleListScope
@Component(modules = {PeopleListModule.class}, dependencies = {AppComponent.class})
public interface PeopleListComponent {
    void inject(PeopleListActivity peopleListActivity);
}
