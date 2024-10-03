package model;

import org.eclipse.microprofile.graphql.Description;

@Description("Representation of a Superhero")
public class Superhero {

    public Superhero() {}

    public Superhero(String name, City city) {
        this.name = name;
        this.city = city;
    }

    @Description("The name of the superhero")
    private String name;

    @Description("The city where the superhero is based or operates")
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
