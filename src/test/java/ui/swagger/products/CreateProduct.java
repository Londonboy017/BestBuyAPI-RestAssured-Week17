package ui.swagger.products;

import io.restassured.response.Response;
import org.junit.Test;
import ui.swagger.model.ProductPojo;
import ui.swagger.testbase.TestBase;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.rootPath;

public class CreateProduct extends TestBase {
    @Test
    public void createANewProduct(){
        ProductPojo productPojo = new ProductPojo();
        productPojo.setName("Duracell - AAA Batteries (4-Pack)");
        productPojo.setType("HardGood");
        productPojo.setPrice("4.32");
        productPojo.setUpc("041333424019");
        //productPojo.setShipping();
        productPojo.setDescription("Compatible with select electronic devices; AAA size; DURALOCK Power Preserve technology; 4-pack");
        productPojo.setModel("MN2400B4Z");
        productPojo.setUrl("http://www.bestbuy.com/site/duracell-aaa-batteries-4-pack/43900.p?id=1051384074145&skuId=43900&cmp=RMXCC");
        productPojo.setImage("http://img.bbystatic.com/BestBuy_US/images/products/4390/43900_sa.jpg");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(productPojo)
                .when()
                .post("/products");
        response.prettyPrint();
        response.then().statusCode(201);
    }
}
