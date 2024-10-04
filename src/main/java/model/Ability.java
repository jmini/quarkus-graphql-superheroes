package model;

import jakarta.json.bind.annotation.JsonbSubtype;
import jakarta.json.bind.annotation.JsonbTypeInfo;

import org.eclipse.microprofile.graphql.Description;

import io.smallrye.graphql.api.Union;

@Union
@JsonbTypeInfo(
        key = "__typename",
        value = {
            @JsonbSubtype(alias = "Superpower", type = Superpower.class),
            @JsonbSubtype(alias = "Attribute", type = Attribute.class)
        })
@Description("An ability that a superhero possesses, which can be either a superpower or a general attribute")
public interface Ability {}
