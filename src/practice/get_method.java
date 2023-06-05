package practice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class get_method {

	@Test
	void getFblogin ()
	{
		RestAssured.baseURI="https://www.fb.com";
		RequestSpecification getrequest=RestAssured.given();
		Response response=getrequest.request(Method.GET,"/login/");
		String responsebody=response.getBody().asString();
		//System.out.println(responsebody);
	}
}
