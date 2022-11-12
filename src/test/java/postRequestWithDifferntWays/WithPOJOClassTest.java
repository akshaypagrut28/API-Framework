package postRequestWithDifferntWays;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import pojoClassForPostRequest.ProjectDetailsTest;

public class WithPOJOClassTest 
{
	
	@Test
	public void addProject()
	{
		Random ran = new Random();
		int no = ran.nextInt(1000);
		ProjectDetailsTest details = new ProjectDetailsTest("Akshay", "TYSS"+no, "ongoing", 15);
		
		given()
		.body(details)
		.contentType(ContentType.JSON)
        .post("http://rmgtestingserver:8084/addProject")
		
		.then()
		.assertThat().statusCode(201)
		.assertThat().statusLine("HTTP/1.1 201 ")
		.assertThat().contentType(ContentType.JSON)
		.assertThat().time(Matchers.lessThan(2000L), TimeUnit.MILLISECONDS)
		.log().all();
		
	}

}
