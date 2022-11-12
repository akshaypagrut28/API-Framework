package authenticationApi;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import aPIGenericUtility.constantUtility;

public class basicAuthTest 
{
	@Test
	public void auth()
	{
		baseURI = "http://rmgtestingserver";
		port =8084;
		basePath = "/login";
		given()
		.auth()
		.basic(constantUtility.username, constantUtility.password)
		.get()
		
		.then()
		.assertThat().statusCode(202)
		.log().all();
		
	}

}
