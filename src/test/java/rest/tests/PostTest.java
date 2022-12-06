package rest.tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import utils.RESTAssuredCommonMethods;
import java.util.HashMap;
import java.util.Map;

public class PostTest  extends RESTAssuredCommonMethods {

    @Test
    public void hitPostRequest() {

        Map<String, String> map = new HashMap<>();
        map.put("name","Bryant");
        map.put("job","BA");

        // Post the request
        Response response = postWithBodyAsMap(map);

        response.prettyPrint();

        //Verify the Content by Specific Key
        verifyContentWithKey(response, "id", "66");

        // Verify the response status code
        verifyResponseCode(response, 201);

        // Verify the Content type
        verifyContentType(response, "JSON");

        // Verify the response time
        verifyResponseTime(response, 10000);

        //Verify the response json scheme
        validateJsonSchema(response);
    }
}
