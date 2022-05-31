package ui.swagger.categories;

import io.restassured.response.Response;
import org.junit.Test;
import ui.swagger.model.CategoriesPojo;
import ui.swagger.testbase.TestBase;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class PostTest extends TestBase {
    @Test
    public void createACategory() {

        CategoriesPojo categoriesPojo = new CategoriesPojo();

        categoriesPojo.setID("abcat0020003");
        categoriesPojo.setName("Billy Bob Thornton");


        Response response = given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer 8bc13c20a8ab19fdf152065554a0e38e1545013fd1c3feb811568f9a151005f7")
                .body(categoriesPojo)
                .when()
                .post("/categories");
        response.then().statusCode(201);
        response.then().time(lessThan(5000L));
        response.prettyPrint();
    }
}
