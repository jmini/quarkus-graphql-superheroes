package model;

public class Superhero {

    public Superhero() {}

    public Superhero(String name, City city) {
        this.name = name;
        this.city = city;
    }

    private String name;
    private City city;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
