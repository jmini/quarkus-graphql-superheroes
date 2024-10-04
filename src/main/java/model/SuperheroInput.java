package model;

import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.Input;

@Input("SuperheroInput")
@Description("Representation of a Superhero")
public class SuperheroInput {

    public SuperheroInput() {}

    public SuperheroInput(String name, Gender gender, City city) {
        this.name = name;
        this.gender = gender;
        this.city = city;
    }

    @Description("The name of the superhero")
    private String name;

    @Description("The gender of the superhero")
    private Gender gender;

    @Description("The city where the superhero is based or operates")
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
