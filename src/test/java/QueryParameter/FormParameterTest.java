package QueryParameter;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import aPIGenericUtility.JavaUtility;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class FormParameterTest 
{
	JavaUtility jutil = new JavaUtility();
	@Test
	public void addProject()
	{
		given()
		.formParam("createdBy", "Akshay")
		.formParam("projectName", "TYSS"+jutil.getRandomNumber())
		.formParam("status", "ongoing")
		.formParam("teamSize", 15)
		.contentType(ContentType.JSON);
         
		when()
		.post("http://rmgtestingserver:8084/addProject")
		
		.then()
		.assertThat().statusCode(201)
		.assertThat().statusLine("HTTP/1.1 201 ")
		.assertThat().contentType(ContentType.JSON)
		.assertThat().time(Matchers.lessThan(2000L), TimeUnit.MILLISECONDS)
		.assertThat()
		.log().all();		
		
		
		
	}

}
