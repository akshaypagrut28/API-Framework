package serializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoClassForParsing.EmployeeDeatilsWithArray;

public class DeSerializationOfEmployeeWithArrayTest 
{
	
	@Test
	public void deserializationOfEmplTest() throws JsonParseException, JsonMappingException, IOException
	{
		//Step 1:- create object of object mapper
		ObjectMapper objm = new ObjectMapper();
		
		//Step 2 :- 
		EmployeeDeatilsWithArray value = objm.readValue(new File("./employeeDetailsArray.json"), EmployeeDeatilsWithArray.class);
		
		System.out.println(value.getSpouseDetails());
		
	}

}
