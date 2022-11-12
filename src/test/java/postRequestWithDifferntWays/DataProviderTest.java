package postRequestWithDifferntWays;

import org.hamcrest.Matchers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import aPIGenericUtility.JavaUtility;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import pojoClassForPostRequest.ProjectDetailsTest;

public class DataProviderTest 
{
	JavaUtility jUtil = new JavaUtility();
	
	@Test(dataProvider = "getData")
	public void createProject(String createdBy, String projectName, String status, int teamSize)
	{
		
		ProjectDetailsTest deatail = new ProjectDetailsTest(createdBy, projectName+jUtil.getRandomNumber(), status, teamSize);
		
		given()
		.body(deatail)
		.contentType(ContentType.JSON)
        .post("http://rmgtestingserver:8084/addProject")
		
		.then()
		.assertThat().statusCode(201)
		.assertThat().statusLine("HTTP/1.1 201 ")
		.assertThat().contentType(ContentType.JSON)
		.assertThat().time(Matchers.lessThan(2000L), TimeUnit.MILLISECONDS)
		.assertThat()
		.log().all();
	}
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[3][4];
		
		data[0][0]="Amit";
		data[0][1]="HCL";
		data[0][2]="ongoing";
		data[0][3]=16;
		
		data[1][0]="Akshay";
		data[1][1]="Dell";
		data[1][2]="ongoing";
		data[1][3]=15;
		
		data[2][0]="Kishor";
		data[2][1]="Infosys";
		data[2][2]="Completed";
		data[2][3]=14;
		
		return data;
	}

}
