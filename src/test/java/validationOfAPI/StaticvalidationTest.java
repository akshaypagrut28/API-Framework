package validationOfAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StaticvalidationTest
{
	@Test
	public void Staticvalidation()
	{
		String pId = "TY_PROJ_1013";
		
		baseURI = "http://rmgtestingserver";
		port =8084;
		basePath = "/projects";
	     
	    
	     
	    Response responce = when()
	     .get();
	     
	     //validate
	     Object actdata = responce.jsonPath().get("[1].projectId");
	    Assert.assertEquals(actdata, pId);
	    System.out.println("data verified");
	     responce.then().log().all();
	        
	}

}
