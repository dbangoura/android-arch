package fr.soat.androidarchi.features.base;

import fr.soat.androidarchi.data.repository.PeopleRepository;

public class BaseInteractor {

    private PeopleRepository peopleRepository;

    public BaseInteractor(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public PeopleRepository getPeopleRepository() {
        return peopleRepository;
    }
}
