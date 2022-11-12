package serializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoClassForParsing.EmployeeDetails;

public class SerializatiojnOfEmployeeTest 
{
	@Test
	public void employeeDetailsTest() throws IOException, JsonMappingException, IOException
	{
		// Step 1 :- create object fot POJO class
		EmployeeDetails empD = new EmployeeDetails("AP", "TYS01", 96655, "bglore", "abc@gmail.com");
		//Step 2 :- create the object for object mapper
		ObjectMapper objm= new ObjectMapper();
		//step 3 :- write the values to json file
		objm.writeValue(new File("employeedetails.json"), empD);
	}

}
