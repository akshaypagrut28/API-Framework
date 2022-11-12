package cRUDOperationWithBDDApproach;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class UpdateProjectTest 
{
	@Test
	public void updateProjectTest()
	{
		Random ran = new Random();
		int no = ran.nextInt(2000);
		
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Akshay");
		jobj.put("projectName", "RMG-tyss"+no);
		jobj.put("status", "created");
		jobj.put("teamSize", 12);
		
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
