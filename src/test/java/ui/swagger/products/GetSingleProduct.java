package ui.swagger.products;

import io.restassured.response.Response;
import org.junit.Test;
import ui.swagger.testbase.TestBase;

import static io.restassured.RestAssured.given;

public class GetSingleProduct extends TestBase {
    @Test
    public void getAllProducts(){
        Response response = given()
                .when()
                .pathParam("id","48530")
                .get("/products/{id}");
        response.prettyPrint();
        response.then().statusCode(200);
    }
}

