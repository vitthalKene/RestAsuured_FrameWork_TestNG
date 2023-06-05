package Testcase;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneOffset;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common_method.evidence_file;
import Common_method.response_extractor;
import Request_repo.Post_request_repo;
import Request_repo.baseURL;
import io.restassured.response.Response;

public class post_tc {

	
	
	public static void post_executer () throws IOException  {
		
	for (int i=0; i<5; i++) {
		Response compelete_response=post_tc.response_status_code_executor();
		int status_code=compelete_response.statusCode();
		 String responseBody=compelete_response.getBody().asString();
		 
		 if (status_code==201)
		 {
			 post_tc.Post_response_validator(responseBody);
			 System.out.println(responseBody);
			 evidence_file.evidence_file("post_tc", Post_request_repo.post_request(), responseBody);
			 break;
		 }
		 else
		 {
			 int k=i+1;
			 if (k<5)
			 System.out.println("incorrect status code found :"+status_code+" in "+i+" iteration, hence retrying for next iteration");
	     } 
		}	
	}
		public static Response response_status_code_executor () {
			
	     RestAssured.baseURI=baseURL.base_url();

		 Response response=response_extractor.post_response(Post_request_repo.post_request());
		 return response;
		 
		}
		
		 public static void Post_response_validator (String responseBody){
 	 
		 JsonPath JSP_res=new JsonPath(responseBody);
		 JsonPath Jsp_req=new JsonPath(Post_request_repo.post_request());
		 
		 String res_name=JSP_res.getString("name");
	     String res_job=JSP_res.getString("job");
	     String res_id=JSP_res.getString("id");
	     String res_createdAt=JSP_res.getString("createdAt");
	    
		 String req_name=Jsp_req.getString("name");
		 String req_job=Jsp_req.getString("job");
		 
	     Assert.assertEquals(req_name, res_name);
	     Assert.assertEquals(req_job, res_job);
         Assert.assertNotNull(res_id);
         Assert.assertEquals(LocalDate.now(ZoneOffset.UTC).toString(), res_createdAt.substring(0,10));
		 
		 
	}
}

