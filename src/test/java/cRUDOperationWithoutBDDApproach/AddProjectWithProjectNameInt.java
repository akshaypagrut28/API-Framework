package cRUDOperationWithoutBDDApproach;

import java.util.concurrent.TimeUnit;

import org.checkerframework.checker.index.qual.LessThan;
import org.hamcrest.Matcher;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class AddProjectWithProjectNameInt 
{
	@Test
	public void addProject()
	{
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Akshay");
		jobj.put("projectName", 6598321);
		jobj.put("status", "created");
		jobj.put("teamSize", 12);
		
		//precondition
				RequestSpecification reqSpec = RestAssured.given();
				reqSpec.body(jobj);
				reqSpec.contentType(ContentType.JSON);
				
				//actions
				Response responce = reqSpec.post("http://rmgtestingserver:8084/addProject");
				System.out.println(responce.getContentType());
				System.out.println(responce.getStatusCode());
				System.out.println(responce.getStatusLine());
				System.out.println(responce.getTime());
				System.out.println(responce.getTimeIn(TimeUnit.SECONDS));
				System.out.println(responce.getSessionId());
				System.out.println(responce.getBody().asPrettyString());
				
				//validations
				responce.getContentType();
				ValidatableResponse validateResponce = responce.then();
				validateResponce.assertThat().contentType(ContentType.JSON);
				validateResponce.assertThat().statusCode(201);
				validateResponce.assertThat().statusLine("HTTP/1.1 201 ");
				validateResponce.log().all();

	}


}
