package postRequestWithDifferntWays;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class WithHashMapTest 
{
	@Test
	public void addProjectTest()
	{
		
		Random ran = new Random();
		int no = ran.nextInt(1000);
		HashMap<Object, Object> hp = new HashMap<Object, Object>();
		hp.put("createdBy","Akshay");
		hp.put("projectName","TYSS"+no);
		hp.put("teamSize",15);
		hp.put("status","Ongoing");
		
		given()
		.body(hp)
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
