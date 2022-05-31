package ui.swagger.exctractionresponsedata;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import javafx.beans.property.adapter.ReadOnlyJavaBeanBooleanProperty;
import org.junit.BeforeClass;
import org.junit.Test;
import ui.swagger.model.UserPojo;
import ui.swagger.testbase.TestBase;
import ui.swagger.utils.TestUtils;

import java.util.*;

import static io.restassured.RestAssured.given;

public class SearchJsonPathExample extends TestUtils {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/stores")
                .then().statusCode(200);
    }

    @Test
    public void test01() {
        int limit = response.extract().path("limit");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + limit);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test02() {
        int total = response.extract().path("total");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Total: " + total);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test03() {
        String name = response.extract().path("data[4].name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Name of fifth store: " + name);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test04() {
        List<String> name = response.extract().path("data.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of name of all stores are : " + name);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test05() {
        List<Integer> storeId = response.extract().path("data.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of name of all stores id are : " + storeId);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test06() {
        List<Integer> dataSize = response.extract().path("data");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The size of data list are : " + dataSize.size());
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test07() {
        List<HashMap<String, ?>> storeName = response.extract().path("data.findAll{it.name=='St Cloud'}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of store is : " + storeName);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test08() {
        List<String> address = response.extract().path("data.findAll{it.name=='Rochester'}.address");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The address of store : " + address);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test09() {
        List<String> services = response.extract().path("data[7].services");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The services of 8th store : " + services);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test10() {
        List<?> storeServices = response.extract().path("data.find{it.services}.services.findAll{it.name=='Windows Store'}.storeservices");
//pending
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The storeservices : " + storeServices);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test11() {
        List<?> storeId = response.extract().path("data.services.storeservices.findAll{it.storeId}.storeId");
        Iterator<?> itr = storeId.iterator();
        while (itr.hasNext()) {
            // System.out.println(itr.next());
            List<?> check = (List<?>) itr.next();
            System.out.println("List all stores id are : " + check.get(0));
        }
    }

    @Test
    public void test12() {
        List<Integer> id = response.extract().path("data.services.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of name of all id are : " + id);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test13() {
        List<Object> name = response.extract().path("data.findAll{it.state=='ND'}.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of name of store : " + name);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test14() {
        List<?> totalServices = response.extract().path("data.findAll{it.name=='Rochester'}.services.find{it.name}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The total number of services of store : " + totalServices.size());
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test15() {
        List<String> createdAt = response.extract().path("data.find{it.services}.services.findAll{it.name=='Windows Store'}.createdAt");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The createdAt : " + createdAt);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test16() {
        List<String> services = response.extract().path("data.findAll{it.name=='Fargo'}.services.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The services : " + services);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test17() {
        List<String> zip = response.extract().path("data.zip");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The zip codes : " + zip);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test18() {
        List<String> zip = response.extract().path("data.findAll{it.name=='Roseville'}.zip");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("zip of Roseville: " + zip);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test19() {
        List<HashMap<String, ?>> storeServices = response.extract().path("data.find{it.services}.services.findAll{it.name='Magnolia Home Theater'}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The store services of Magnolia Home Theater : " + storeServices);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test20() {
        List<?> lat = response.extract().path("data.lat");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Thelat of all stores : " + lat);
        System.out.println("------------------End of Test---------------------------");
    }

}
