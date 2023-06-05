package practice;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

import org.testng.Assert;

public class put_reference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//step1- define the baseURI
		RestAssured.baseURI="https://reqres.in";
		
		//step2- create a local variable to store requestBody
		String requestBody="{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"zion resident\"\r\n"
				+ "}";
		
		
		//step3- create a object of JsonPath for requestBody 
		JsonPath JSP_req=new JsonPath(requestBody);
		
		     //parsing the request
		String req_name=JSP_req.getString("name");
		System.out.println("Req name is:" +req_name);
		
		String req_job=JSP_req.getString("job");
		System.out.println("Req job is:" +req_job);
		
		      //Extract status code
		int status_code=given().header("Content-Tyepe","applicatin/json").body(requestBody)
				.when().put("/api/users/2").getStatusCode();		
		
		//step4- trigger the API
		String responseBody=given().header("Content-Type", "application/json").body(requestBody).when()
		.put("/api/users/2").then().extract().response().asString();
		
		System.out.println(responseBody);
		
		//step5- create a object of JsonPath for responseBody
		JsonPath JSP_res=new JsonPath(responseBody);
		
		     //parsing the response
		String res_name=JSP_res.getString("name");
		System.out.println("Res name is:" +res_name);
		
		String res_job=JSP_res.getString("job");
		System.out.println("Res job is:" +res_job);
		
		String res_updatedAt=JSP_res.getString("updatedAt");
		System.out.println("Res name is:" +res_updatedAt);
		
		      //Extracting record created date
		String res_date=res_updatedAt.substring(0,10);
		System.out.println("created date is:" +res_date);
		
		     //Extracting local date
		String LocalDate=java.time.LocalDate.now().toString();
		System.out.println("local date is:" +LocalDate);
		
		//step6- validate the responseBody with requestBody
		Assert.assertEquals(res_name, req_name);
		Assert.assertEquals(res_job, req_job);
		Assert.assertEquals(res_date, LocalDate);
		Assert.assertEquals(status_code, 200);
		
		
	}

}
