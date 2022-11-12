package aPIGenericUtility;

import java.util.Random;

public class JavaUtility 
{
	/**
	 * this metod will generate random number for every execution
	 * @return
	 */
	public int getRandomNumber() 
	{
		Random r = new Random();
		int ran = r.nextInt(1000);
		return ran;
	}
	
	

}
