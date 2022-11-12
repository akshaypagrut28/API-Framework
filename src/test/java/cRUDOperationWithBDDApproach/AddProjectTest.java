package cRUDOperationWithBDDApproach;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import aPIGenericUtility.JavaUtility;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class AddProjectTest 
{
	@Test
	public void addProjectTest()
	{
		JavaUtility ju = new JavaUtility();
		//As we using POST http methd --> creating the body
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Akshay");
		jobj.put("projectName", "RMG-tyss"+ju.getRandomNumber());
		jobj.put("status", "created");
		jobj.put("teamSize", 12);
		
       given()
       .body(jobj)
       .contentType(ContentType.JSON)
       
       
       .when()
       .post("http://rmgtestingserver:8084/addProject")
   
       
       .then()
       .assertThat().statusCode(201)
       .assertThat().statusLine("HTTP/1.1 201 ")
       .assertThat().contentType(ContentType.JSON)
       .assertThat().time(Matchers.lessThan(2000L), TimeUnit.MILLISECONDS)
       .log().all();
       
       
		
	}

}
