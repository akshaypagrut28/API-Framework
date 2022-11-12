package cRUDOperationWithoutBDDApproach;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class AddPojectTest 
{
	@Test
	public void addProjectTest()
	{
		Random ran = new Random();
		int no = ran.nextInt(2000);
		//As we using POST http methd --> creating the body
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Akshay");
		jobj.put("projectName", "RMG-tyss"+no);
		jobj.put("status", "created");
		jobj.put("teamSize", 12);
		
		//precondition
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.body(jobj);
		reqSpec.contentType(ContentType.JSON);
		
		//actions
		Response responce = reqSpec.post("http://rmgtestingserver:8084/addProject");
		Response resp1 = responce.prettyPeek();//all the http response it will given back
		String resp2 = responce.prettyPrint();//only body it will given back to the server
		System.out.println(responce.getContentType());
		System.out.println(responce.getStatusCode());
		System.out.println(responce.getStatusLine());
		System.out.println(responce.getTime());
		System.out.println(responce.getTimeIn(TimeUnit.SECONDS));
		System.out.println(responce.getSessionId());
		System.out.println(responce.getBody().asPrettyString());
		responce.getContentType();
		
		//validation
		ValidatableResponse validateResponce = responce.then();
		validateResponce.assertThat().contentType(ContentType.JSON);
		validateResponce.assertThat().statusCode(201);
		validateResponce.assertThat().statusLine("HTTP/1.1 201 ");
		validateResponce.assertThat().time(org.hamcrest.Matchers.lessThan(2000L), TimeUnit.MILLISECONDS);
		validateResponce.log().all();
	}

}
