package aPIGenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;



public class propertyFileUtility 
{
	/**
	 * this method will read the data from property file and return the value
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readDataFromPropertyFile(String key) throws IOException {
		
		FileInputStream fis = new FileInputStream(constantUtility.propertyFilePath);
		Properties pobj = new Properties();
		pobj.load(fis);
		String value = pobj.getProperty(key);
		return value;
		
	}


}
