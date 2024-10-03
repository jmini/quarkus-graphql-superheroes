package model;

public class City {

    public City() {}

    public City(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    private String name;
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
