package cRUDOperationWithoutBDDApproach;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSender;

public class ReadAllProjectTest 
{
	@Test
	public void readProject()
	{
		
		RestAssured rest = new RestAssured();
		RequestSender reqsend = rest.when();
		Response resp = reqsend.get("http://rmgtestingserver:8084/projects");
		System.out.println(resp.getBody());
		ValidatableResponse validresp = resp.then();
		
		validresp.assertThat().contentType(ContentType.JSON);
		validresp.assertThat().statusCode(200);
		validresp.log().all();
	
	}

}
