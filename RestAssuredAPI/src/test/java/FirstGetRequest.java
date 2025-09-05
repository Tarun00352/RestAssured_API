import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class FirstGetRequest {

    @Test
    public void getRequest(){

        Response res = RestAssured.get("https://reqres.in/api/users/2");
        System.out.println(res.asString());
        System.out.println(res.getStatusCode());
    }
}
