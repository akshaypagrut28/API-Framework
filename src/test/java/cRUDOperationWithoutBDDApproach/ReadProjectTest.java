package cRUDOperationWithoutBDDApproach;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSender;

public class ReadProjectTest 
{
	@Test
	public void readAllProject()
	{
		RestAssured rest = new RestAssured();
		RequestSender reqsend = rest.when();
		
		Response resp = reqsend.get("http://rmgtestingserver:8084/projects/TY_PROJ_3793");
		System.out.println(resp.getBody());
		ValidatableResponse validresp = resp.then();
		
		validresp.assertThat().contentType(ContentType.JSON);
		validresp.statusCode(200);
		validresp.log().all();
		
		
	}

}
