package serializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoClassForParsing.EmployeeDetails;

public class DeserializationOfEmployeeTest 
{
	@Test
	public void deserializationEmpDetails() throws JsonParseException, JsonMappingException, IOException
	{
		//Step 1:- create the object for object mapper
		ObjectMapper objm = new ObjectMapper();
		//Step 2:- read the value from object mapper
		EmployeeDetails value = objm.readValue(new File("./employeedetails.json"), EmployeeDetails.class);
		
		System.out.println(value.geteName());
		
	}

}
