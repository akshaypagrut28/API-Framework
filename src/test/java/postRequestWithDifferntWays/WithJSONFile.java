package postRequestWithDifferntWays;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class WithJSONFile 
{
	@Test
	public void addProject() throws FileNotFoundException
	{
		//FileInputStream fis = new FileInputStream("./src/test/resources/empDeatails.json");
		File file = new File("./src/test/resources/empDeatails.json");
		given()
		.body(file)
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
