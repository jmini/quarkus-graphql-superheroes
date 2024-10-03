package web;

import jakarta.inject.Inject;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Name;

import model.Superhero;
import service.SuperheroService;

@GraphQLApi
public class SuperheroMutation {

    @Inject
    SuperheroService superheroService;

    @Mutation
    public Superhero createSuperhero(@Name("superhero") Superhero superheroInput) {
        var superhero = new Superhero(superheroInput.getName(), superheroInput.getCity());
        superheroService.addSuperhero(superhero);
        return superhero;
    }
}
