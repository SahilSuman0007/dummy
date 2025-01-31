package vTiger.GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consist of method related to excel file
 */
public class ExcelFileUtiliy {
	/**
	 * This method is used to read the data from excel by providing sheetname,rowand cell
	 * @param sheetname
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public String toReadDataFromExcel(String sheetname,int row,int cell) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis =new FileInputStream(".\\src\\test\\resources\\testDataA1.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		String work = wb.getSheet(sheetname).getRow(row).getCell(cell).toString();
		return work;
		
		
	}
	

	
	
}
