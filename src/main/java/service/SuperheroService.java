package service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.enterprise.context.ApplicationScoped;

import model.City;
import model.Gender;
import model.Superhero;

@ApplicationScoped
public class SuperheroService {

    private final List<Superhero> superheroes = new ArrayList<>();

    private final List<City> cities = new ArrayList<>();

    public SuperheroService() {
        var gothamCity = new City("Gotham City", "GC");
        cities.add(gothamCity);

        var batman = new Superhero("Batman", Gender.MALE, gothamCity);
        superheroes.add(batman);

        var catwoman = new Superhero("Catwoman", Gender.FEMALE, gothamCity);
        superheroes.add(catwoman);

        var newYorkCity = new City("New York City", "NYC");
        cities.add(newYorkCity);

        var spiderMan = new Superhero("Spider Man", Gender.MALE, newYorkCity);
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
