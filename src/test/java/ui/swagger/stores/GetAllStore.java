package ui.swagger.stores;

import io.restassured.response.Response;
import org.junit.Test;
import ui.swagger.testbase.TestBase;

import static io.restassured.RestAssured.given;

public class GetAllStore extends TestBase {
    @Test
    public void getAllStoreDetails() {
        Response response = given()
                .when()
                .get("/stores");
        response.prettyPrint();
        response.then().statusCode(200);
    }
}
