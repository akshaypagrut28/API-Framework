package aPIGenericUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelFileUtility 
{
	/**
	 * this method will read data from excel sheet and return the value
	 * @param sheet
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public String readDataFromExcel(String sheet ,int rownum , int cellnum) throws EncryptedDocumentException, IOException 
	{
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\APIDataProvider.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet);
		Row row = sh.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		String value = cell.getStringCellValue();
		wb.close();
		return value;
		
	}  
	
	/**
	 * this method is used to execute a test script with multiple set of data.
	 * Hence, it will return two dimensional object[][] so that it can be direct used in dataprovider.
	 * @param sheetname
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public Object[][] readMultipleDataFromExcel(String sheetname) throws EncryptedDocumentException, IOException 
	{
		
		FileInputStream fio = new FileInputStream("./src/test/resources/APIDataProvider.xlsx");
		Workbook wb = WorkbookFactory.create(fio);
		Sheet sh = wb.getSheet(sheetname);
		int lastrow = sh.getLastRowNum();
		short lastcell = sh.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[lastrow][lastcell];
		
		for(int i=0; i<lastrow; i++)
		{
			for(int j=0; j<lastcell; j++)
			{
				data[i][j]=sh.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
		
	}
}
