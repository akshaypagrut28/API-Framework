package pathParameter;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DeleteProjectTest 
{
	@Test
	public void deleteProject()
	{
		baseURI = "http://rmgtestingserver";
		port =8084 ;
		given()
		.pathParam("pid", "TY_PROJ_4198")
		
		.when()
		.delete("/projects/{pid}")
		
		.then()
		.assertThat().statusCode(204)
		.assertThat().statusLine("HTTP/1.1 204 ")
		.assertThat().contentType(ContentType.JSON)
		.assertThat().time(Matchers.lessThan(2000L), TimeUnit.MILLISECONDS)
		.assertThat()
		.log().all();
			
	}

}
