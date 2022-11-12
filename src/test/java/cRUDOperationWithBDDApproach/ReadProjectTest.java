package cRUDOperationWithBDDApproach;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class ReadProjectTest 
{
	@Test
	public void readProjectTest()
	{
		when()
		.get("http://rmgtestingserver:8084/projects/TY_PROJ_4198")
		
		.then()
		.assertThat().statusCode(200)
		.assertThat().statusLine("HTTP/1.1 200 ")
		.assertThat().contentType(ContentType.JSON)
		.assertThat().time(Matchers.lessThan(2000L), TimeUnit.MILLISECONDS)
		.log().all();
		
	}

}
