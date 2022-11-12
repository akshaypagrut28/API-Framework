package validationOfAPI;

import static io.restassured.RestAssured.*;

import java.awt.List;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import junit.framework.Assert;

public class Dynamicvalidation1 
{
	@Test
	public void dynamicValidation()
	{
		String actdata = "TY_PROJ_1013";
		baseURI = "http://rmgtestingserver";
		port =8084;
		
		Response res = when().get("/projects");
		boolean flag = false ;
	        Object pid = res.jsonPath().get("projectId");
		
		/*for(Object project : pid)
		{
			if(project.equalsIgnoreCase(actdata))
			{
				flag=true;
			}
		}*/
		Assert.assertTrue(flag);
		System.out.println("tC pass");
		res.then().assertThat().statusCode(200).log().all();
     
	}
}
