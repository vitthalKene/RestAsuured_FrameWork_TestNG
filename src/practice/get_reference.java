package practice;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

import org.testng.Assert;

public class get_reference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//step1- define the baseURI
		RestAssured.baseURI="https://reqres.in";
		
		//step2- create a local variable to store requestBody
	        //here no requestBody parameter
 		
		//trigger the API
		String responseBody=given().when().get("/api/users?page=2").then().extract()
				.response().asString();
		
		System.out.println(responseBody);
		
		//Extract the status code
		int status_code=given().when().get("/api/users?page=2").getStatusCode();
		
		System.out.println("Status code is:" +status_code);
		
		//create a object of JsonPath for responseBody
		JsonPath JSP=new JsonPath(responseBody);
		
		//ResponseBody data size
		int length=JSP.getInt("data.size()");
		System.out.println("Length Is:" +length);
		
		//Storing the attributes of array for validation against expected result
		
		//storing ID
		String[] Array_ID=new String[length];
		     for (int i=0; i<length; i++)
		     {
		    	 Array_ID[i]=JSP.getString("data["+i+"].id");
		    	 System.out.println("ID is:" +Array_ID[i]);
		
		     }
		     
		//storing Email
		 String[] Array_EMAIL=new String[length];
		     for (int i=0; i<length; i++)
		     {
		    	 Array_EMAIL[i]=JSP.getString("data["+i+"].email");
		    	 System.out.println("EMAIL is:" +Array_EMAIL[i]);
		
		     }
		
		//storing First_name
		String[] Array_FIRST_NAME=new String[length];
		     for (int i=0; i<length; i++)
		     {
		    	 Array_FIRST_NAME[i]=JSP.getString("data["+i+"].first_name");
		    	 System.out.println("FIRST_NAME is:" +Array_FIRST_NAME[i]);
		
		     }
		
		//storing Last_name
		 String[] Array_LAST_NAME=new String[length];
		     for (int i=0; i<length; i++)
		     {
		    	 Array_LAST_NAME[i]=JSP.getString("data["+i+"].last_name");
		    	 System.out.println("LAST_NAME is:" +Array_LAST_NAME[i]);
		
		     }
		
		//storing avatar
		  String[] Array_AVATAR=new String[length];
		     for (int i=0; i<length; i++)
		     {
		    	 Array_AVATAR[i]=JSP.getString("data["+i+"].avatar");
		    	 System.out.println("AVATAR is:" +Array_AVATAR[i]);
		
		     }
		
		  //parsing the responseBody
		   for(int i=0; i<length; i++)
		   {
			   String res_id=JSP.getString("data["+i+"].id");
			   System.out.println("id is:" +res_id);
			   
			   String res_email=JSP.getString("data["+i+"].email");
			   System.out.println("email is:" +res_email);
			   
			   String res_first_name=JSP.getString("data["+i+"].first_name");
			   System.out.println("first_name is:" +res_first_name);
			   
			   String res_last_name=JSP.getString("data["+i+"].last_name");
			   System.out.println("last_name is:" +res_last_name);
			   
			   String res_avatar=JSP.getString("data["+i+"].avatar");
			   System.out.println("Avatar is:" +res_avatar);
			   
			   
			   //validate the responseBody
			   
			  Assert.assertEquals(res_id, Array_ID[i]);
			  Assert.assertEquals(res_email, Array_EMAIL[i]);
			  Assert.assertEquals(res_first_name, Array_FIRST_NAME[i]);
			  Assert.assertEquals(res_last_name, Array_LAST_NAME[i]);
			  Assert.assertEquals(res_avatar, Array_AVATAR[i]);
			      
		   }
	}

}
