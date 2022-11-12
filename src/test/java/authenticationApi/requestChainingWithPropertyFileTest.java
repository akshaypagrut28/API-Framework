package authenticationApi;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import aPIGenericUtility.JavaUtility;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class requestChainingWithPropertyFileTest
{
	@Test
	public void createProject() throws IOException
	{
		    JavaUtility jutil = new JavaUtility();
			baseURI = "http://rmgtestingserver";
			port =8084;
			basePath = "/addProject";
			
			JSONObject jobj = new JSONObject();
			jobj.put("createdBy", "Akshay");
			jobj.put("projectName", "TYSS"+jutil.getRandomNumber());
			jobj.put("status", "complete");
			jobj.put("teamSize", 16);
			
			Response resp = given().body(jobj).contentType(ContentType.JSON).post();
				
			
			String str = resp.asPrettyString();
		 	String projectid = resp.jsonPath().get("projectId");
		
		    resp.then().assertThat().statusCode(201)
		    .log().all();
		    FileOutputStream fio = new FileOutputStream("./src/test/resources/commndata.Properties.txt");
			Properties pro = new Properties();
			pro.store(fio, projectid);
	}
	@Test
	public void readProject() throws IOException
	{
		baseURI = "http://rmgtestingserver";
		port =8084;
		
       FileInputStream fie = new FileInputStream("./src/test/resources/commndata.Properties.txt");
       Properties pro = new Properties();
       pro.load(fie);
	String project = pro.getProperty("id");
      Response resp = when().get("/projects"+project);
      
      resp.then().assertThat().statusCode(200)
	    .log().all();
      
	}
}
