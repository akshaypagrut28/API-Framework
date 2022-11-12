package pathParameter;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import aPIGenericUtility.JavaUtility;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class UpdateProjectTest 
{
	@Test
	public void updateProject()
	{
		JavaUtility ju = new JavaUtility();
		//As we using POST http methd --> creating the body
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Akshay");
		jobj.put("projectName", "RMG-tyss"+ju.getRandomNumber());
		jobj.put("status", "created");
		jobj.put("teamSize", 12);
		
		baseURI = "http://rmgtestingserver";
		port =8084 ;
		given()
		.body(jobj)
		.contentType(ContentType.JSON)
		.pathParam("pid", "TY_PROJ_4198")
		
		.when()
		.put("/projects/{pid}")
		
		.then()
		.assertThat().statusCode(200)
		.assertThat().statusLine("HTTP/1.1 200 ")
		.assertThat().contentType(ContentType.JSON)
		.assertThat().time(Matchers.lessThan(2000L), TimeUnit.MILLISECONDS)
		.assertThat()
		.log().all();
			

	}

}
