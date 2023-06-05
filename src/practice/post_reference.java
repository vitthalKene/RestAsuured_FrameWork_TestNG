package practice;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

import org.testng.Assert;

public class post_reference {

	public static void main(String[] args) {
		
		//step1- Define the baseURI
		RestAssured.baseURI="https://reqres.in";
		
		//step2- create a local variable to store requestBody
		String requestBody="{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}";
		
		//step3- create a object of JsonPath for requestBody
	    JsonPath JSP_req=new JsonPath(requestBody);
	    
	    //step4- parsing the requestBody parameter
	    String req_name=JSP_req.getString("name");
	    System.out.println("RequestBody Name is :" +req_name);
	    
	    String req_job=JSP_req.getString("job");
	    System.out.println("RequestBody Job is :" +req_job);
	    
	    //extract status code 
	   int status_code=given().header("Content-Type", "application/json")
    	.body(requestBody).when().post("/api/users").getStatusCode();
	   
	   System.out.println("Status code is:" +status_code);
		
		//step5- trigger the API
	    String responseBody=given().header("Content-Type", "application/json")
	    	.body(requestBody).when().post("/api/users").then().extract().response().asString();
	    
	    System.out.println(responseBody);
	    
	    
	    //step6- create a object object JsonPath for responseBody
	    JsonPath JSP_res=new JsonPath(responseBody);
	    
	    //step7- parsing the responseBody parameter
	   String res_name=JSP_res.getString("name");
	    System.out.println("ResponseBody Name is:" +res_name);
	    
	    String res_job=JSP_res.getString("job");
	    System.out.println("ResponseBody Job is:" +res_job);
	    
	    String res_id=JSP_res.getString("id");
	    System.out.println("ResponseBody id is:" +res_id);
	    
	    String res_createdAt=JSP_res.getString("createdAt");
	    System.out.println("ResponseBody created Date is:" +res_createdAt);
	    
	    //Extracting record created date
	    String res_date=res_createdAt.substring(0,10);
	    System.out.println("created date is:" +res_date);
	    
	    String res_Date=java.time.LocalDate.now().toString();
	    System.out.println("Local system Date is:" +res_Date);
	    
	    //Extracting local system date
	  //  String LocalDate=java.time.LocalDate.now().toString();
	    //System.out.println("Local system Date is:" +LocalDate);
	    
	    //step8- Validate responseBody parameter with requestBody parameter
	    Assert.assertEquals(res_name, req_name);
	    Assert.assertEquals(res_job, req_job);
	    Assert.assertNotNull(res_id);
	    Assert.assertEquals(res_date, res_Date);
	    Assert.assertEquals(status_code, 201);

	    
	}

}
