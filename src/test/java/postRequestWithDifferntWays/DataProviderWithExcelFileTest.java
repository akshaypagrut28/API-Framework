package postRequestWithDifferntWays;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import aPIGenericUtility.ExcelFileUtility;
import aPIGenericUtility.JavaUtility;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class DataProviderWithExcelFileTest 
{
	ExcelFileUtility eUtil = new ExcelFileUtility();
	JavaUtility jutil = new JavaUtility();
	
	@Test(dataProvider = "getData")
	public void addProject(String createdBy, String projectName, String status, int teamSize) throws EncryptedDocumentException, IOException
	{
		
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", createdBy);
		jobj.put("projectName", projectName);
		jobj.put("status", status);
		jobj.put("teamSize", teamSize);
		given()
		.body(jobj)
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
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
		return eUtil.readMultipleDataFromExcel("ProjectDetails");
	}
	

}
