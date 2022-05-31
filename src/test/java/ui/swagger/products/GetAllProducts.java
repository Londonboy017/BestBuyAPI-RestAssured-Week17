package ui.swagger.products;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;
import ui.swagger.testbase.TestBase;

import static io.restassured.RestAssured.given;

public class GetAllProducts extends TestBase {
    @Test
    public void getAllProducts(){
        Response response = given()
                .when()
                .get("/products");
        response.prettyPrint();
        response.then().statusCode(200);
    }
}

