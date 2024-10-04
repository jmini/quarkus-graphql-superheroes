package model;

import org.eclipse.microprofile.graphql.Description;

@Description("A superpower that a superhero possesses")
public class Superpower implements Ability {

    @Description("The name of the superpower that a superherow has")
    private String name;

    public Superpower() {}

    public Superpower(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
