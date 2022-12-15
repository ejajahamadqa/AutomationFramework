package rest.tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import utils.RESTAssuredCommonMethods;
import java.util.List;

public class GetTest extends RESTAssuredCommonMethods {

    @Test
    public void hitGetrequest() {
        Response response = get("page","2");

        response.prettyPrint();

        verifyContentType(response, "JSON");

        // Verify the response status code
        verifyResponseCode(response, 200);

        // Verify the response time
        verifyResponseTime(response, 10000);

        // Verify the value of first_name for "id": 10 is ‘Byron’
        List<String> firstNameList = response.jsonPath().getList("data.first_name");

        for(String firstName : firstNameList) {
            if(firstName.equalsIgnoreCase("Byron")) {
                System.out.println("First Name:- "+firstName);
                break;
            }
        }
    }
}
