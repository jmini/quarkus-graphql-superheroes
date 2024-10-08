package web;

import java.util.List;

import jakarta.inject.Inject;

import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;
import org.eclipse.microprofile.graphql.Source;

import model.City;
import model.Superhero;
import service.SuperheroService;

@GraphQLApi
public class SuperheroResolver {

    @Inject
    SuperheroService superheroService;

    @Query("allCities")
    @Description("Get all cities.")
    public List<City> getAllCities() {
        return superheroService.getAllCities();
    }

    @Query
    @Description("Get a City.")
    public City getCity(@Name("cityId") int id) {
        return superheroService.getCity(id);
    }

    @Query("allSuperheroes")
    @Description("Get all superheroes.")
    public List<Superhero> getAllSuperheroes() {
        return superheroService.getAllSuperheroes();
    }

    @Query
    @Description("Get a super hero.")
    public Superhero getSuperhero(@Name("heroId") int id) {
        return superheroService.getSuperhero(id);
    }

    public List<Superhero> superheroes(@Source City city) {
        return superheroService.getSuperheroesByCity(city);
    }
}
