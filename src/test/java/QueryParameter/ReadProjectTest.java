package QueryParameter;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class ReadProjectTest 
{
	@Test
	public void readProject()
	{
		baseURI = "https://reqres.in";
		given()
		.queryParam("page", "2");
		
		when()
		.get("/api/users?page")
		
		.then()
		.assertThat().statusCode(200)
		.log().all();
	}

}
