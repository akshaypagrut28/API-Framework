package cRUDOperationWithBDDApproach;

import static io.restassured.RestAssured.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class AddProjectWithoutProjectName 
{

		@Test
		public void addProjectTest()
		{
			Random ran = new Random();
			int no = ran.nextInt(2000);
	
			JSONObject jobj = new JSONObject();
			jobj.put("createdBy", "Akshay");
			jobj.put("status", "created");
			jobj.put("teamSize", 12);
			
	       given()
	       .body(jobj)
	       .contentType(ContentType.HTML)
	       
	       
	       .when()
	       .post("http://rmgtestingserver:8084/addProject")
	   
	       
	       .then()
	       .assertThat().statusCode(201)
	       .assertThat().statusLine("HTTP/1.1 201 ")
	       .assertThat().contentType(ContentType.HTML)
	       .assertThat().time(Matchers.lessThan(2000L), TimeUnit.MILLISECONDS)
	       .log().all();
	       
	       
			
		}

	


}
