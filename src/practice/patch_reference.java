package practice;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

import org.testng.Assert;

public class patch_reference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//step1- Define the baseURI
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
	    
		
		//Extract the status code
	    int status_code=given().header("Content-Type","application/json").body(requestBody)
	    		        .when().patch("/api/users/2").getStatusCode();
	    
	       System.out.println("Status code is:" +status_code);
	    
	    
	    
		//step3- trigger the API

	    String responseBody=given().header("Content-Type", "application/json").body(requestBody).when()
	    		.patch("/api/users/2").then().extract().response().asString();
		System.out.println(responseBody);
		
		//step4- create an object of JsonPath for responseBody parameter
		
		JsonPath JSP_res=new JsonPath(responseBody);
		
		String res_name=JSP_res.getString("name");
		System.out.println(res_name);
		
		String res_job=JSP_res.getString("job");
		System.out.println(res_job);
		
		String res_updatedAt=JSP_res.getString("updatedAt");
		System.out.println(res_updatedAt);
		 
		     //Extracting record created date
		String res_date=res_updatedAt.substring(0,10);
		System.out.println("Created Date is:" +res_date);
		
		    //extracting the local date
		String LocalDate=java.time.LocalDate.now().toString();
		System.out.println("Local Date is:" +LocalDate);
		
		//Step5- validate the response with request
		Assert.assertEquals(res_name, req_name);
		Assert.assertEquals(res_job, req_job);
		Assert.assertEquals(res_date, LocalDate);
		Assert.assertEquals(status_code, 200);
		
		
	}

}
