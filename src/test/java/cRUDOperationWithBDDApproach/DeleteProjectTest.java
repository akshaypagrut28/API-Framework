package cRUDOperationWithBDDApproach;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DeleteProjectTest 
{

	@Test
	public void deleteProjectTest()
	{
		when()
		.delete("http://rmgtestingserver:8084/projects/TY_PROJ_972")
		
		.then()
		.assertThat().statusCode(204)
		.assertThat().statusLine("HTTP/1.1 204 ")
		.assertThat().time(Matchers.lessThan(2000L), TimeUnit.MILLISECONDS)
		.log().all();
		
	}


}
