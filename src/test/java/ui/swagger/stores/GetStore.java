package ui.swagger.stores;

import io.restassured.response.Response;
import org.junit.Test;
import ui.swagger.testbase.TestBase;
import ui.swagger.utils.TestUtils;

import static io.restassured.RestAssured.given;

public class GetStore extends TestBase {
    @Test
    public void getStoreDetails() {
        Response response = given()
                .pathParam("id", 4)
                .when()
                .get("/stores/{id}");
        response.prettyPrint();
        response.then().statusCode(200);
    }
}
