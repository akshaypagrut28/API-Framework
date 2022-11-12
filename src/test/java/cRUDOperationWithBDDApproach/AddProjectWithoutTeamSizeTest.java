package cRUDOperationWithBDDApproach;

import static io.restassured.RestAssured.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import aPIGenericUtility.JavaUtility;
import io.restassured.http.ContentType;

public class AddProjectWithoutTeamSizeTest 
{
	@Test
	public void addProjectTest()
	{
		JavaUtility ju = new JavaUtility();
		
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Akshay");
		jobj.put("projectName", "RMG-tyss"+ju.getRandomNumber());
		jobj.put("status", "created");
		
		given()
		.body(jobj)
		.contentType(ContentType.JSON)
		
		.when()
		.put("http://rmgtestingserver:8084/projects/TY_PROJ_4198")
		
		.then()
		.assertThat().statusCode(200)
		.assertThat().statusLine("HTTP/1.1 200 ")
		.assertThat().contentType(ContentType.JSON)
		.assertThat().time(Matchers.lessThan(2000L), TimeUnit.MILLISECONDS)
		.assertThat()
		.log().all();
		
	}

}
