package web;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.json.config.JsonParserType;
import io.restassured.path.json.config.JsonPathConfig;
import io.restassured.response.Response;
import model.City;

@QuarkusTest
public class SuperheroTest {

    @BeforeAll
    static void configureRestAssured() {
        RestAssured.config = RestAssured.config()
                .objectMapperConfig(
                        ObjectMapperConfig.objectMapperConfig().defaultObjectMapperType(ObjectMapperType.GSON));
        JsonPath.config = new JsonPathConfig().defaultParserType(JsonParserType.GSON);
    }

    @Test
    void allCities() {
        final Response response = given().contentType(ContentType.JSON)
                .body("{\"query\":\"{\\n allCities{\\n name\\n}\\n}\"}")
                .when()
                .post("/graphql")
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .extract()
                .response();

        final List<City> allCities = response.jsonPath(JsonPath.config).getList("data.allCities", City.class);
        assertThat(allCities)
                .isNotEmpty()
                .hasSize(2)
                .extracting(City::getName)
                .contains("Gotham City", "New York City");
    }
}
