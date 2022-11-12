package cRUDOperationWithoutBDDApproach;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSender;

public class DeleteProjectTest 
{
	@Test
	public void deleteProject()
	{
		RestAssured rest = new RestAssured();
		RequestSender reqsend = rest.when();
		
		Response resp = reqsend.delete("http://rmgtestingserver:8084/projects/TY_PROJ_968");
		
		resp.contentType();
		ValidatableResponse validresp = resp.then();
		validresp.statusCode(204);
		validresp.log().all();
	}

}
