package fr.soat.androidarchi.data.model;

import java.util.List;

public class PeopleListResult {

    private String count;
    private List<SimplifiedPeople> results;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public List<SimplifiedPeople> getResults() {
        return results;
    }

    public void setResults(List<SimplifiedPeople> results) {
        this.results = results;
    }
}
