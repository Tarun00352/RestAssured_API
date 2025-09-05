package ResponseHeaderValidation;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Header_Validation {

    @Test
    public void getSingleUser(){

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://reqres.in/");
        requestSpecification.basePath("api/users/2");

        Response response = requestSpecification.get();
        String content_type = response.header("Content-Type");
        System.out.println("Content-Type: " + content_type);

        String Access_Control_Allow_Headers = response.header("Access-Control-Allow-Headers");
        System.out.println(Access_Control_Allow_Headers);
        System.out.println();

        Assert.assertEquals(content_type,"application/json; charset=utf-8", "Actual and expected are not same");

        Headers headersList = response.getHeaders();
        int count = 0;
        for(Header header : headersList){
            System.out.println("Header Key: " + header.getName() + ", Header Value: " + header.getValue());
            count++;
        }
        System.out.println("Total headers present: " + count);
    }
}
