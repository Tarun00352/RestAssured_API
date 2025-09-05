package HTTP_Requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Patch_Request {

    @Test
    public void patch_request(){

        JSONObject jsonData = new JSONObject();
        jsonData.put("Name","Tarun tk");
        jsonData.put("Job","Tester");

        Response response = RestAssured.given()
                .header("Content-Type","application/json")
                .header("x-api-key", "reqres-free-v1")
                .body(jsonData.toString())
                .patch("https://reqres.in/api/users/259");

        System.out.println("Response code: " + response.getStatusCode());
        System.out.println("Response body: " + response.getBody().asString());


        Assert.assertEquals(response.getStatusCode(),200,"Response code mismatch");
        Assert.assertTrue(response.getBody().asString().contains("Tarun tk"),"Name not found in response body");
        Assert.assertTrue(response.getBody().asString().contains("Tester"),"Job not found in response body");
    }
}
