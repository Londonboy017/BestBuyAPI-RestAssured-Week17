package ui.swagger.stores;

import io.restassured.response.Response;
import org.junit.Test;
import ui.swagger.testbase.TestBase;

import static io.restassured.RestAssured.given;

public class DeleteStore extends TestBase {
    @Test
    public void deleteAStore() {
        Response response = given()
                .header("Content-Type", "application/json")
                .pathParam("id", 7)
                .when()
                .delete("/stores/{id}");
        response.prettyPrint();
        response.then().statusCode(200);
    }
}
