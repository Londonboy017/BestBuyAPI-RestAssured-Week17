package ui.swagger.stores;

import io.restassured.response.Response;
import org.junit.Test;
import ui.swagger.model.UserPojo;
import ui.swagger.testbase.TestBase;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class CreateStore extends TestBase {
    @Test
    public void createANewStore() {
        HashMap<Object, Object> servicesData = new HashMap<>();
        UserPojo userPojo = new UserPojo();
        userPojo.setName("Baroda");
        userPojo.setType("BigBox");
        userPojo.setAddress("108 Golden way");
        userPojo.setAddress2("");
        userPojo.setCity("Baroda");
        userPojo.setState("BD");
        userPojo.setZip("23332");
        userPojo.setLat(23);
        userPojo.setLng(65);
        userPojo.setHours("Mon: 10-9; Tue: 10-9; Wed: 10-9; Thurs: 10-9; Fri: 10-9; Sat: 10-9; Sun: 10-8");
        userPojo.setServices(servicesData);

        Response response = given()
                .header("Content-Type", "application/json")
                .body(userPojo)
                .when()
                .post("/stores");
        response.prettyPrint();
        response.then().statusCode(201);
    }
}
