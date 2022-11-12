package serializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoClassForParsing.EmployeeDeatilsWithArray;
import pojoClassForParsing.SpouseDetails;

public class serializationOfEmployeeDetailsWithArrayTest 
{
	@Test
	public void employeeDetailsWithArrayTest() throws JsonGenerationException, JsonMappingException, IOException
	{
		//Step 1:- create object of POJO class
		int[] phoneNo = {1232424,38261685};
		String[] mailId = {"agshh@gmail.com","hghgl@gamil.com"};
		int[] phone = {7689176,19486};
		SpouseDetails sd = new SpouseDetails("SP", "TYSS23", phone, "PUne");
		EmployeeDeatilsWithArray empa = new EmployeeDeatilsWithArray("AP", "Tyss22", phoneNo, 66660, mailId, sd);
		
		//Stpe 2 :- Create object of Objectmapper
		ObjectMapper objm = new ObjectMapper();
		
		//Step 3 :- write the value to json file
		objm.writeValue(new File("employeeDetailsArray.json"), empa);
		
	}

}
