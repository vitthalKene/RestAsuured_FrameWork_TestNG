package Testcase;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common_method.response_extractor;
import Request_repo.baseURL;

public class get_tc {
	
	
	public static void get_executor() {
		
	for (int i=0; i<5; i++) {
		Response compelete_response=get_tc.response_statuscode_executor();
		int status_code=compelete_response.statusCode();
		 String responseBody=compelete_response.getBody().asString();
		 
		 if (status_code==200)
		 {
			 get_tc.get_response_validator(responseBody);
			 System.out.println(responseBody);
		 }
		 else
		 {
			 System.out.println("incorrect status code found");
		 }
	}
	}


		
		public static Response response_statuscode_executor() {
		RestAssured.baseURI=baseURL.base_url();
	
		Response response=response_extractor.get_response(null);
		return response;
	
		}
		
		public static void get_response_validator (String responseBody) {
	
				JsonPath JSP=new JsonPath(responseBody);
				
				//ResponseBody data size
				int length=JSP.getInt("data.size()");
				System.out.println("Length Is:" +length);
		
				String[] Array_ID=new String[length];
				     for (int i=0; i<length; i++)
				     {
				    	 Array_ID[i]=JSP.getString("data["+i+"].id");
				    	 System.out.println("ID is:" +Array_ID[i]);
				
				     }
				     
				 String[] Array_EMAIL=new String[length];
				     for (int i=0; i<length; i++)
				     {
				    	 Array_EMAIL[i]=JSP.getString("data["+i+"].email");
				    	 System.out.println("EMAIL is:" +Array_EMAIL[i]);
				
				     }
				
				String[] Array_FIRST_NAME=new String[length];
				     for (int i=0; i<length; i++)
				     {
				    	 Array_FIRST_NAME[i]=JSP.getString("data["+i+"].first_name");
				    	 System.out.println("FIRST_NAME is:" +Array_FIRST_NAME[i]);
				
				     }
				
				 String[] Array_LAST_NAME=new String[length];
				     for (int i=0; i<length; i++)
				     {
				    	 Array_LAST_NAME[i]=JSP.getString("data["+i+"].last_name");
				    	 System.out.println("LAST_NAME is:" +Array_LAST_NAME[i]);
				
				     }
		
				  String[] Array_AVATAR=new String[length];
				     for (int i=0; i<length; i++)
				     {
				    	 Array_AVATAR[i]=JSP.getString("data["+i+"].avatar");
				    	 System.out.println("AVATAR is:" +Array_AVATAR[i]);
				
				     }
				
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

	
	//int status_code=given().when().get("/api/users?page=2").getStatusCode();
	//String responseBody=given().header("Content-Type", "application/json").when().get("/api/users?page=2").then().extract().response().asString()