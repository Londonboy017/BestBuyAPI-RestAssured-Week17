package ui.swagger.stores;

import io.restassured.response.Response;
import org.junit.Test;
import ui.swagger.model.UserPojo;
import ui.swagger.testbase.TestBase;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class UpdateStore extends TestBase {
    @Test
    public void updateAStore() {
        HashMap<Object, Object> servicesData = new HashMap<>();
        UserPojo userPojo = new UserPojo();
        userPojo.setName("London");
        userPojo.setType("SmallBox");
        userPojo.setAddress("3 Rose Road");
        userPojo.setAddress2("Behind NHS Building");
        userPojo.setCity("London");
        userPojo.setState("LN");
        userPojo.setZip("44551");
        userPojo.setLat(34);
        userPojo.setLng(46);
        userPojo.setHours("Mon: 10-8; Tue: 10-8; Wed: 10-8; Thurs: 10-8; Fri: 10-8; Sat: 10-8; Sun: 10-6");
        userPojo.setServices(servicesData);

        Response response = given()
                .header("Content-Type", "application/json")
                .pathParam("id", 8926)
                .body(userPojo)
                .when()
                .patch("/stores/{id}");
        response.prettyPrint();
        response.then().statusCode(200);
    }

}
