package web;

import java.util.List;

import jakarta.inject.Inject;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Name;

import model.Superhero;
import model.SuperheroInput;
import service.SuperheroService;

@GraphQLApi
public class SuperheroMutation {

    @Inject
    SuperheroService superheroService;

    @Mutation
    public Superhero createSuperhero(@Name("superhero") SuperheroInput superheroInput) {
        var superhero = new Superhero(
                superheroInput.getName(), superheroInput.getGender(), superheroInput.getCity(), List.of());
        superheroService.addSuperhero(superhero);
        return superhero;
    }
}
