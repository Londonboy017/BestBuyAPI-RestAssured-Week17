package ui.swagger.categories;

import io.restassured.response.Response;
import org.junit.Test;
import ui.swagger.testbase.TestBase;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class GetTest extends TestBase {
    @Test
    public void getAllCategoriesInformation() {
        Response response = given()
                .header("Accept", "application/json")
                .header("Authorization", "8bc13c20a8ab19fdf152065554a0e38e1545013fd1c3feb811568f9a151005f7")
                .when()
                .get("/categories");
        response.then().statusCode(200);
        response.then().time(lessThan(5000L));
        response.prettyPrint();
    }

    @Test
    public void getASingleCategoryInfo() {
        Response response = given()
                .pathParam("id","abcat0010000")
                .when()
                .get("/categories/{id}");
        response.then().statusCode(200);
        response.then().time(lessThan(5000L));
        response.prettyPrint();
    }
}
