package fr.soat.androidarchi.di.components;

import dagger.Component;
import fr.soat.androidarchi.di.modules.PeopleDetailModule;
import fr.soat.androidarchi.di.scopes.PeopleDetailScope;
import fr.soat.androidarchi.features.people_detail.PeopleDetailActivity;

@PeopleDetailScope
@Component(modules = {PeopleDetailModule.class}, dependencies = {AppComponent.class})
public interface PeopleDetailComponent {
    void inject(PeopleDetailActivity peopleDetailActivity);
}
