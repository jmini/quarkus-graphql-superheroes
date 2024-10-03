
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

# quarkus-graphql-superheroes project

### GraphQL schema

The Schema is available from the running server:

    http://localhost:8080/graphql/schema.graphql

## curl example

```shell script
curl --request POST \
--url http://localhost:8080/graphql \
--header 'Content-Type: application/json' \
--data '{"query":"    {\n        allCities {\n            name\n        }\n    }"}'
```

## GraphQL tool

When running in dev mode, you can execute GraphQL queries directly from the UI (using GraphiQL):

    http://localhost:8080/q/graphql-ui/

## graphql queries

allCities

```graphql
{
    allCities {
        name
    }
}
```

getCity

```graphql
query getCity {
    city(cityId: 0) {
        name
    }
}
```

allSuperheroes

```graphql
{
    allSuperheroes {
        name
    }
}
```

getSuperHero

```graphql
query getSuperhero {
    superhero(heroId: 0) {
        name
    }
}
```

getCity with super heroes

```graphql
query getCity {
    city(cityId: 0) {
        name
        symbol
        superheroes {
            name
            }
    }
}
```

mutation

```graphql
mutation {
    createSuperhero(superhero: {name: "Name", city: {name: "City", symbol: "CTY"}}) {
        name
        city {
            name
            symbol
        }
    }
}
```

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./gradlew quarkusDev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at <http://localhost:8080/q/dev/>.

## Packaging and running the application

The application can be packaged using:

```shell script
./gradlew build
```

It produces the `quarkus-run.jar` file in the `build/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `build/quarkus-app/lib/` directory.

The application is now runnable using `java -jar build/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell script
./gradlew build -Dquarkus.package.jar.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar build/*-runner.jar`.

## Creating a native executable

You can create a native executable using:

```shell script
./gradlew build -Dquarkus.native.enabled=true
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./gradlew build -Dquarkus.native.enabled=true -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./build/code-with-quarkus-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult <https://quarkus.io/guides/gradle-tooling>.

## Related Guides

- SmallRye GraphQL ([guide](https://quarkus.io/guides/smallrye-graphql)): Create GraphQL Endpoints using the code-first approach from MicroProfile GraphQL
