package model;

import java.util.List;

import org.eclipse.microprofile.graphql.Description;

@Description("Representation of a Superhero")
public class Superhero {

    public Superhero() {}

    public Superhero(String name, Gender gender, City city, List<Ability> abilities) {
        this.name = name;
        this.gender = gender;
        this.city = city;
        this.abilities = abilities;
    }

    @Description("The name of the superhero")
    private String name;

    @Description("The gender of the superhero")
    private Gender gender;

    @Description("The city where the superhero is based or operates")
    private City city;

    @Description("A list of abilities the superhero possesses, which can be superpowers or general attributes")
    private List<Ability> abilities;

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

    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }
}
