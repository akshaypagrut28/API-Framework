package pathParameter;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class ReadProjectTest 
{
	@Test
	public void readProject()
	{
		baseURI = "http://rmgtestingserver";
		port =8084 ;
		given()
		.pathParam("pid", "TY_PROJ_4198")
		
		.when()
		.get("/projects/{pid}")
		
		.then()
		.assertThat().statusCode(200)
		.assertThat().statusLine("HTTP/1.1 200 ")
		.assertThat().contentType(ContentType.JSON)
		.assertThat().time(Matchers.lessThan(2000L), TimeUnit.MILLISECONDS)
		.assertThat()
		.log().all();
			
	}

}
