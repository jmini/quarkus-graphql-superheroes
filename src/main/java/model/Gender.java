package model;

import org.eclipse.microprofile.graphql.Description;

@Description("Gender of a superhero")
public enum Gender {
    @Description("Male")
    MALE,

    @Description("Female")
    FEMALE,

    @Description("Not applicable or unknown")
    NOT_APPLICABLE
}
