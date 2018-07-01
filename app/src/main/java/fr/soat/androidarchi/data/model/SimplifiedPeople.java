package fr.soat.androidarchi.data.model;

public class SimplifiedPeople {

    private String name;
    private String url;

    public int getId(){
        String id = url.replace("https://swapi.co/api/people/", "");
        id = id.replace("/", "");
        return Integer.parseInt(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String peopleName) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
