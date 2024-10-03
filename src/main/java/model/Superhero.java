package model;

public class Superhero {

    public Superhero() {}

    public Superhero(String name, Gender gender, City city) {
        this.name = name;
        this.gender = gender;
        this.city = city;
    }

    private String name;
    private Gender gender;
    private City city;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
