package model;

import org.eclipse.microprofile.graphql.Description;

@Description("A general attribute that a superhero possesses")
public class Attribute implements Ability {

    @Description("Attribute name (e.g. intelligence, strength, speed ...) that describes a superhero")
    private String name;

    @Description("Value from 0-100 indicating their rating for that particular attribute")
    private Integer rating;

    @Description("Explanation why the rating is given")
    private String motivation;

    public Attribute() {}

    public Attribute(String name, Integer rating, String motivation) {
        super();
        this.name = name;
        this.rating = rating;
        this.motivation = motivation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getMotivation() {
        return motivation;
    }

    public void setMotivation(String motivation) {
        this.motivation = motivation;
    }
}
