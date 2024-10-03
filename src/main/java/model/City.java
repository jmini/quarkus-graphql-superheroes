package model;

import org.eclipse.microprofile.graphql.Description;

@Description("City where a superhero is located or operates")
public class City {

    public City() {}

    public City(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    @Description("The name of the city")
    private String name;

    @Description("A short abbreviation or symbolic representation of the city")
    private String symbol;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
