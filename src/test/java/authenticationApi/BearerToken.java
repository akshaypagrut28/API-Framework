package authenticationApi;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class BearerToken 
{
	@Test
	public void bearerToken()
	{
		baseURI="https://api.github.com/";
		basePath = "user/repos";
		JSONObject jobj = new JSONObject();
		jobj.put("name", "online framework");
		
		given()
		.auth()
		.oauth2("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")
		.body(jobj)
		.contentType(ContentType.JSON)
		.post()
		
		.then().assertThat().statusCode(201).log().all();
		
		
		
		
		
	}

}
