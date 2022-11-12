package cRUDOperationWithoutBDDApproach;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UpdateProjectTest 
{
	@Test
	public void updateProject()
	{
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Akshay");
		jobj.put("projectName", "RMG-TYSS098");
		jobj.put("status", "complete");
		jobj.put("teamSize", 44);
		
		RestAssured rest = new RestAssured();
		RequestSpecification reqspec = rest.given();
		reqspec.body(jobj);
		reqspec.contentType(ContentType.JSON);
		Response resp = reqspec.put("http://rmgtestingserver:8084/projects/TY_PROJ_3793");
		
		resp.getContentType();
		ValidatableResponse validresp = resp.then();
		validresp.assertThat().contentType(ContentType.JSON);
		validresp.assertThat().statusCode(200);
		validresp.log().all();
		
		
	}

}
