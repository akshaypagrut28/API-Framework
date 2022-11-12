package authenticationApi;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Auth2 
{
	@Test
	public void Auth2()
	{
		Response resp = given()
		.formParam("client_id", "OnlineApplication")
		.formParam("client_secret","c3ad3cdb6b8066e64f4c1fd7bc15e4f7")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri", "http://example.com")
		.formParam("code", "authorization_code")
		
		.when().post("http://coop.apps.symfonycasts.com/token");
		
		//Capture the access token from the response of the above request
		String token = resp.jsonPath().get("access_token");
		System.out.println(token);
		
		//Create another request and use the token to access the APIs
		given()
		.auth().oauth2(token)
		.pathParam("USER_ID", 4026)
		.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-count")
		
		.then().log().all();
	}

}
