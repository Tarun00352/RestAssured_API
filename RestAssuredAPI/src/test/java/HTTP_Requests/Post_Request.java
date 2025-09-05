package HTTP_Requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Post_Request {

    @Test
    public void postRequest(){

        JSONObject jsonData = new JSONObject();
        jsonData.put("Name","Tarun Kumar");
        jsonData.put("Job","QA");

        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("x-api-key", "reqres-free-v1")
                .body(jsonData.toString())
                .post("https://reqres.in/api/users");

        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());

        Assert.assertEquals(response.getStatusCode(), 201, "Status code mismatch!");
        Assert.assertTrue(response.getBody().asString().contains("Tarun Kumar"), "Name not found in response!");
        Assert.assertTrue(response.getBody().asString().contains("QA"), "Job not found in response!");
    }
}
