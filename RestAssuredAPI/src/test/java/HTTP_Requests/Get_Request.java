package HTTP_Requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Get_Request {

    @Test
    public void get_request(){

        Response response = RestAssured.given()
                .header("x-api-key", "reqres-free-v1")
                .get("https://reqres.in/api/users?page=2");
        System.out.println("Response body: " + response.getBody().asString());
        System.out.println("Time in milliseconds: " + response.getTime());
        System.out.println("Response Header: " + response.getHeader("Content-Type"));
        System.out.println("Response status code: " + response.getStatusCode());

        int expectedStatusCode = 200;
        int actualStatusCode = response.getStatusCode();

        Assert.assertEquals(actualStatusCode, expectedStatusCode, "Actual and expected code are not same");

    }
}
