package validationOfAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class DynamicValidationTest 
{
	@Test
	public void dynamicValidation()
	{
		baseURI = "http://rmgtestingserver";
		port =8084;
		basePath = "/projects";
		
	    Response responce = when()
	     .get();
	     String str = responce.prettyPrint();
	     int size = 0;
	     for(int i=0; i<str.length(); i++)
	     {
	    	 if(str.charAt(i)=='{')
	    	 {
	    		 size++;
	    	 }
	     }
	     System.out.println("total projects: "+size);
	     
	    int i=0;
	    while(true)
	    {
	    	Object pid = responce.jsonPath().get("["+i+"].projectId");
	    	//System.out.println(pname);
	    	try
	    	{
	    	Assert.assertEquals(pid, "TY_PROJ_1013");
	    	System.out.println("position of the project: "+i);
	    	break;
	    	}
	    	catch(AssertionError e)
	    	{
	    		if(i<=size)
	    		{
	    		i++;
	    		}
	    		else
	    		{
	    			Assert.fail();
	    		}
	    	}
	    }
	    System.out.println("value is find");
	}

}
