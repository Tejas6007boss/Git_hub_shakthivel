package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class ExcelFileUtilities
{

	/**
	 * it is used to read te data from excel
	 * @param sheetname
	 * @param Rowno
	 * @param columnno
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
public String  readdataFromExcelFile(String sheetname,int Rowno,int columnno) throws EncryptedDocumentException, IOException
{
	FileInputStream fss = new FileInputStream(ipathinterface.excelpath);
	 Workbook book = WorkbookFactory.create(fss);
	  Sheet sheet = book.getSheet(sheetname);
	  Row row = sheet.getRow(Rowno);
	  
	     Cell cell = row.getCell(columnno);
	     String value = cell.toString();
	    
	     return value;
	 
}
/**
 * This method is used to write data into excel
 * @param Sheetname
 * @param Rowno
 * @param Columnno
 * @throws EncryptedDocumentException
 * @throws IOException
 */

public void writeDatIntoexcel(String Sheetname,int Rowno,int Columnno) throws EncryptedDocumentException, IOException
{
	FileInputStream fss=new FileInputStream(ipathinterface.excelpath);
	  Workbook book = WorkbookFactory.create(fss);
	  Sheet sheet = book.getSheet(Sheetname);
	 Row row = sheet.createRow(Rowno);
	 Cell cell = row.createCell(Columnno);
	 FileOutputStream fos=new FileOutputStream(ipathinterface.excelpath);
	 book.write(fos);
	
	 
}
/**
 * this method is used to get last row number
 * @param Sheetname
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */

public int  getlastRownum(String Sheetname) throws EncryptedDocumentException, IOException
{
FileInputStream fis = new FileInputStream(ipathinterface.excelpath);
Workbook book = WorkbookFactory.create(fis);
Sheet sheet = book.getSheet(Sheetname);
int lastrow = sheet.getLastRowNum();
return lastrow;

}
public Object[][] readmultipledata(String sheetname ) throws EncryptedDocumentException, IOException
{
	FileInputStream fis = new FileInputStream(ipathinterface.excelpath);
	Workbook book = WorkbookFactory.create(fis);
	Sheet sheet = book.getSheet(sheetname);
	int Lastrow = sheet.getLastRowNum()+1;
	int lastcell = sheet.getRow(0).getLastCellNum();
	
	
	
	Object[][] obj = new Object[Lastrow][lastcell];
	for(int i=0;i<Lastrow;i++)
	{
		for(int j=0;j<lastcell;j++)
		{
			obj[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
		}
	}
	return obj;
}

}
