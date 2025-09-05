package HTTP_Requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Delete_Request {

    @Test
    public void delete_request(){

        //JSONObject jsonData = new JSONObject();

        Response response= RestAssured.given()
                .header("x-api-key", "reqres-free-v1")
                .delete("https://reqres.in/api/users/259");

        System.out.println("Response code: " + response.getStatusCode());

        Assert.assertEquals(response.getStatusCode(),204,"Response code mismatch");
    }
}
