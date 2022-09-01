package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Parametrization {
	public static String getdata(String sheetName, int row, int cell) throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream("C:\\Users\\Acer\\eclipse-workspace\\MyBatch\\KiteZerodha\\src\\main\\resources\\TestData.xlsx");
		
		String value = WorkbookFactory.create(file).getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
		
		return value;
		
	}
	public static double getNumericData(String sheetName, int row, int cell) throws EncryptedDocumentException, IOException  {
		
		FileInputStream file = new FileInputStream("C:\\Users\\Acer\\eclipse-workspace\\MyBatch\\KiteZerodha\\src\\main\\resources\\TestData.xlsx");

		double value = WorkbookFactory.create(file).getSheet(sheetName).getRow(row).getCell(cell).getNumericCellValue();
		return value;
					
	}
}
