package web;

import static io.restassured.RestAssured.given;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class SchemaTest {

    @Test
    void schemaUpToDate() throws Exception {
        String content = given().get("graphql/schema.graphql")
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .extract()
                .body()
                .asString();

        Path file = Paths.get("schema.graphql").toAbsolutePath();
        String expectedContent;
        if (Files.exists(file)) {
            expectedContent = Files.readString(file);
        } else {
            expectedContent = null;
        }

        if (!Objects.equals(content, expectedContent)) {
            Files.createDirectories(file.getParent());
            Files.writeString(file, content);
        }
        Assertions.assertThat(content).as("File content " + file).isEqualTo(expectedContent);
    }
}
