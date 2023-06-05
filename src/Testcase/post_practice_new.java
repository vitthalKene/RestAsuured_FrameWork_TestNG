package Testcase;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import org.testng.Assert;

public class post_practice_new {

	public static void post_practice () {
		// TODO Auto-generated method stub
		
		
		RestAssured.baseURI="https://reqres.in";
		String requestBody="{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}";
		
		Response response=given().header("Content-Type", "application/json").body(requestBody).when().post("/api/users").then().extract().response();
		
		String responseBody=response.getBody().asString();
		int status_code=response.statusCode();
		
		JsonPath jsp_res=new JsonPath(responseBody);   //create object of JsonPath
		JsonPath jsp_req=new JsonPath(requestBody);
		
		String res_name=jsp_res.getString("name");
		String res_job=jsp_res.getString("job");    //parsing responseBody parameter
		String res_id=jsp_res.getString("id");
		String res_createdAt=jsp_res.getString("createdAt");
		
		String req_name=jsp_req.getString("name");         //parsing requestBody parameter
		String req_job=jsp_req.getString("job");
		
		String res_date=res_createdAt.substring(0,10);
		String res_Date=java.time.LocalDate.now().toString();
		
		Assert.assertEquals(res_name, req_name);
	    Assert.assertEquals(res_job, req_job);
	    Assert.assertNotNull(res_id);
	    Assert.assertEquals(res_date, res_Date);
	    Assert.assertEquals(status_code, 201);

	}

}
