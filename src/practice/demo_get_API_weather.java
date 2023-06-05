package practice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class demo_get_API_weather {
	
	@Test
	public void getApi_details() {
		
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		
		RequestSpecification httpsRequest=RestAssured.given();
		
		Response response=httpsRequest.request(Method.GET,"/Hyderabad");
		
		String responseBody=response.getBody().asString();
		System.out.println("responsebody is: " +responseBody);
		
		
	}

}
