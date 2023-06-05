package practice;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

import org.testng.Assert;

public class get_method_ashish {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		RestAssured.baseURI="https://reqres.in/";
		
		int status_code=given().header("Content-Type","application/json").when().get("/api/users?page=2").then().extract().response().statusCode();
		System.out.println(status_code);
		
		String responseBody = given().header("Content-Type","application/json").when().get("/api/users?page=2").then().extract().response().asString();
		System.out.println(responseBody);
		
		JsonPath jsp=new JsonPath(responseBody);
		
		int datasize=jsp.getList("data").size();
		System.out.println("datasize is: " +datasize);
		
		Assert.assertEquals(datasize, 6);       // validate data size
		
		// for validate data in data array
		
		for(int i=0; i<datasize; i++)
		{
			String id=jsp.getString("data["+i+"].id");
			System.out.println(id);
			String email=jsp.getString("data["+i+"].email");
			System.out.println(email);
			String F_name=jsp.getString("data["+i+"].first_name");
			System.out.println(F_name);
			String L_name=jsp.getString("data["+i+"].last_name");
			System.out.println(L_name);
			String avatar=jsp.getString("data["+i+"].avatar");
			System.out.println(avatar);
		}
	}

}
