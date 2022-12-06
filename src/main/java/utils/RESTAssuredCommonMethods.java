package utils;

import java.io.File;
import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import net.minidev.json.JSONObject;
import org.testng.Assert;

public class RESTAssuredCommonMethods extends RestAssuredBaseClass{

	public static RequestSpecification setLogs() {
		return RestAssured
				.given()
				.log()
				.all()
				.contentType(getContentType());
	}

	public static RequestSpecification setLogsWithParam(String key, String value) {
		return RestAssured
				.given()
				.log()
				.all()
				.queryParam(key,value)
				.contentType(getContentType());
	}

	public static Response getWithParam(String URL) {
		return setLogs()
				.when()
				.get(URL);
	}

	public static Response get(String key, String value) {
		return setLogsWithParam(key,value)
				.when()
				.get();
	}

	public static Response get() {
		return setLogs()
				.get();
	}

	public static Response getWithHeader(Map<String, String> headers, String URL) {

		return setLogs()
				.when()
				.headers(headers)
				.get(URL);
	}

	public static Response post() {

		return setLogs()
				.post();
	}

	public static Response post(String URL) {
		setLogs()
		.post(URL)
		.then()
		.log().all();
		
		return setLogs()
				.post(URL);
	}

	public static Response postWithBodyAsFile(File bodyFile) {

		return setLogs()
				.body(bodyFile)
				.post();
	}
	
	public static Response postWithBodyAsFileAndUrl(File bodyFile, String URL) {
		
		return setLogs()
				.body(bodyFile)
				.post(URL);
	}

	public static Response postWithHeaderAndForm(Map<String, String> headers,
			JSONObject jsonObject, String URL) {

		return setLogs()
				.headers(headers)
				.body(jsonObject)
				.post(URL);
	}

	public static Response postWithJsonAsBody(String jsonObject, String URL) {

		return setLogs()
				.body(jsonObject)
				.post(URL);
	}


	public static Response postWithHeaderAndJsonBody(Map<String, String> headers,
			String jsonObject, String URL) {

		return setLogs()
				.when()
				.headers(headers)
				.body(jsonObject)
				.post(URL);
	}


	public static Response postWithHeaderParam(Map<String, String> headers, String URL) {

		return setLogs()
				.when()
				.headers(headers)
				.post(URL);
	}

	public static Response postWithBodyAsMap(Map<String, String> body) {

		return setLogs()
				.body(body)
				.when()
				.post();
	}
	
	public static Response delete(String URL) {
		return setLogs()
				.when()
				.delete(URL);
	}

	public static Response deleteWithHeaderAndPathParam(Map<String, String> headers,
			JSONObject jsonObject, String URL) {

		return setLogs()
				.when()
				.headers(headers)
				.body(jsonObject)
				.delete(URL);
	}

	public static Response deleteWithHeaderAndPathParamWithoutRequestBody(
			Map<String, String> headers, String URL) throws Exception {
		return setLogs()
				.when()
				.headers(headers)
				.delete(URL);
	}

	public static Response putWithHeaderAndBodyParam(Map<String, String> headers,
			JSONObject jsonObject, String URL) {

		return RestAssured.given().headers(headers).contentType(getContentType()).request()
				.body(jsonObject).when().put(URL);
	}

	public static ValidatableResponse enableResponseLog(Response response) {
		return response.then().log().all();
	}

	private static ContentType getContentType() {
		return ContentType.JSON;
	}

	public static List<String> getContentsWithKey(Response response, String key) {
		if(response.getContentType().contains("json")) {
			JsonPath jsonPath = response.jsonPath();
			return jsonPath.getList(key);
		}else {
			return null;
		}
	}

	public static String getContentWithKey(Response response, String key) {
		if(response.getContentType().contains("json")) {
			JsonPath jsonPath = response.jsonPath();
			return (String) jsonPath.get(key);			
		}else {
			return null;
		}
	}

	public static void verifyContentType(Response response, String type) {
		if(response.getContentType().toLowerCase().contains(type.toLowerCase())) {
			System.out.println("The Content type "+type+" matches the expected content type");
		}else {
			System.out.println("The Content type "+type+" does not matches the expected content type");
		}
	}

	public static void verifyResponseCode(Response response, int code) {
		Assert.assertEquals(response.statusCode(), code);
		if(response.statusCode() == code) {
			System.out.println("The status code "+code+" matches the expected code");
		}else {
			System.out.println("The status code "+code+" does not matches the expected code");
		}
	}

	public static void verifyResponseTime(Response response, long time) {
		if(response.time() <= time) {
			System.out.println("The time taken "+response.time() +" with in the expected time");
		}else {
			System.out.println("The time taken "+response.time() +" is more than theexpected time");
		}
	}

	public static void verifyContentWithKey(Response response, String key, String expVal) {
		if(response.getContentType().contains("json")) {
			JsonPath jsonPath = response.jsonPath();
			String actValue = jsonPath.get(key);
			if(actValue.equalsIgnoreCase(expVal)) {
				System.out.println("The JSON response has value "+expVal+" as expected. ");
			}else {
				System.out.println("The JSON response does not has value "+expVal+" as expected. ");
			}
		}
	}

	public void validateJsonSchema(Response response) {
		enableResponseLog(response)
				.assertThat()
				.body(JsonSchemaValidator.
						matchesJsonSchema(new File(System.getProperty("user.dir")+ "//src//main//java//json//schema//schema.json")));
	}


}
