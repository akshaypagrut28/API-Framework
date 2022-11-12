package authenticationApi;


import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import aPIGenericUtility.JavaUtility;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RequestChainingTest 
{
	String projectid ;
	@Test
	public void requestChaining()
	{
		JavaUtility jutil = new JavaUtility();
		baseURI = "http://rmgtestingserver";
		port =8084;
		basePath = "/addProject";
		
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Akshay");
		jobj.put("projectName", "TYSS"+jutil.getRandomNumber());
		jobj.put("status", "complete");
		jobj.put("teamSize", 16);
		
		Response resp = given().body(jobj).contentType(ContentType.JSON).post();
			
		
		String str = resp.asPrettyString();
		projectid = resp.jsonPath().get("projectId");
	
	    resp.then().assertThat().statusCode(201)
	    .log().all();
				
	}

	@Test
	public void readProject()
	{
		baseURI = "http://rmgtestingserver";
		port =8084;
		
       Response resp = when().get("/projects"+projectid);
      //resp.prettyPrint();
       
       resp.then().assertThat().statusCode(200)
       .assertThat().log().all();
	}
}
