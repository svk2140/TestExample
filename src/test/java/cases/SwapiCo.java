package cases;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class SwapiCo
{
    @Test()
    public void main() throws Throwable
    {
        given().when().get("https://swapi.co/api/people/").then()
                .body("count", equalTo(87))
                .body("results[0].name", equalTo("Luke Skywalker"))
                .body("results[1].name", equalTo("C-3PO"))
                .body("results[2].name", equalTo("R2-D2"));
    }
}
