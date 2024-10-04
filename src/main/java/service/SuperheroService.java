package service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.enterprise.context.ApplicationScoped;

import model.Attribute;
import model.City;
import model.Gender;
import model.Superhero;
import model.Superpower;

@ApplicationScoped
public class SuperheroService {

    private final List<Superhero> superheroes = new ArrayList<>();

    private final List<City> cities = new ArrayList<>();

    public SuperheroService() {
        var gothamCity = new City("Gotham City", "GC");
        cities.add(gothamCity);

        var batman = new Superhero(
                "Batman",
                Gender.MALE,
                gothamCity,
                List.of(
                        new Superpower("Genius-Level Intellect"),
                        new Superpower("Expert Martial Artist"),
                        new Superpower("Master Detective"),
                        new Superpower("Peak Human Conditioning"),
                        new Superpower("Expert in Stealth"),
                        new Superpower("Proficient in Various Weapons"),
                        new Superpower("Access to Advanced Technology"),
                        new Attribute(
                                "Intelligence", 100, "Genius-level intellect with vast knowledge in various fields"),
                        new Attribute("Strength", 85, "Peak human strength, trained to physical perfection"),
                        new Attribute("Speed", 70, "Highly trained agility and quick reflexes"),
                        new Attribute("Power", 75, "Strategic mind with considerable influence in combat"),
                        new Attribute("Combat", 95, "Expert martial artist, skilled in various forms of combat"),
                        new Attribute(
                                "Durability",
                                80,
                                "High endurance, capable of withstanding significant physical punishment")));
        superheroes.add(batman);

        var catwoman = new Superhero(
                "Catwoman",
                Gender.FEMALE,
                gothamCity,
                List.of(
                        new Superpower("Agility"),
                        new Superpower("Enhanced Reflexes"),
                        new Superpower("Acrobatics"),
                        new Superpower("Stealth"),
                        new Superpower("Expert Hand-to-Hand Combatant"),
                        new Superpower("Cat-Like Reflexes"),
                        new Superpower("Master Thief"),
                        new Attribute("Intelligence", 85, "Clever and resourceful, often outsmarts opponents"),
                        new Attribute("Strength", 60, "Strong for a human, with above-average physical capabilities"),
                        new Attribute("Speed", 80, "Known for agility and quick reflexes"),
                        new Attribute("Power", 50, "Relies on skills and cunning rather than raw power"),
                        new Attribute("Combat", 75, "Proficient in hand-to-hand combat and acrobatics"),
                        new Attribute("Durability", 65, "Can endure physical punishment, though still vulnerable")));
        superheroes.add(catwoman);

        var newYorkCity = new City("New York City", "NYC");
        cities.add(newYorkCity);

        var spiderMan = new Superhero(
                "Spider Man",
                Gender.MALE,
                newYorkCity,
                List.of(
                        new Superpower("Superhuman Strength"),
                        new Superpower("Wall-Crawling"),
                        new Superpower("Spider-Sense"),
                        new Superpower("Enhanced Reflexes"),
                        new Superpower("Web-Shooting"),
                        new Superpower("Agility"),
                        new Superpower("Stealth"),
                        new Attribute("Intelligence", 85, "Highly intelligent, especially in science and technology"),
                        new Attribute("Strength", 80, "Superhuman strength, able to lift several tons"),
                        new Attribute("Speed", 75, "Quick reflexes and agility, allowing for rapid movement"),
                        new Attribute("Power", 90, "High-level powers, including web-slinging and wall-crawling"),
                        new Attribute(
                                "Combat", 70, "Skilled in hand-to-hand combat but relies more on agility and reflexes"),
                        new Attribute(
                                "Durability",
                                70,
                                "Able to withstand injuries better than an average human, thanks to his powers")));
        superheroes.add(spiderMan);
    }

    public List<City> getAllCities() {
        return cities;
    }

    public City getCity(int id) {
        return cities.get(id);
    }

    public List<Superhero> getAllSuperheroes() {
        return superheroes;
    }

    public Superhero getSuperhero(int id) {
        return superheroes.get(id);
    }

    public List<Superhero> getSuperheroesByCity(City city) {
        return superheroes.stream().filter(hero -> hero.getCity().equals(city)).collect(Collectors.toList());
    }

    public void addSuperhero(Superhero superhero) {
        superheroes.add(superhero);
        cities.add(superhero.getCity());
    }

    public Superhero deleteSuperhero(int id) {
        return superheroes.remove(id);
    }

    public List<Superhero> getSuperheroesByName(String name) {
        return superheroes.stream().filter(hero -> hero.getName().equals(name)).collect(Collectors.toList());
    }
}
