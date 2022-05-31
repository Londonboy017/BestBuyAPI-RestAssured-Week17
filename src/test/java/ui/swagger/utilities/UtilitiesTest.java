package ui.swagger.utilities;

import io.restassured.response.Response;
import org.junit.Test;
import ui.swagger.testbase.TestBase;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class UtilitiesTest extends TestBase {
    @Test
    public void getVersionInformation() {
        Response response = given()
                .header("Accept", "application/json")
                .when()
                .get("/version");
        response.then().statusCode(200);
        response.then().time(lessThan(2000L));
        response.prettyPrint();
    }

    @Test
    public void getHealthCheckInfo() {
        Response response = given()
                .when()
                .get("/healthcheck");
        response.then().statusCode(200);
        response.then().time(lessThan(2000L));
        response.prettyPrint();
    }
}
