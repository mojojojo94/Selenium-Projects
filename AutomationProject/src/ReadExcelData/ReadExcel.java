package ReadExcelData;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	public static void main(String[] args) throws Exception {
		
	File loginExcelData = new File("C:\\Users\\sheheryar\\ExcelData\\LoginTestData.xlsx");
	
	FileInputStream FIS = new FileInputStream(loginExcelData);
	
	XSSFWorkbook wb = new XSSFWorkbook(FIS);
	
	XSSFSheet sheet1 = wb.getSheetAt(0);
	
	int rowCount = sheet1.getLastRowNum(); 
	
	System.out.println("Total number of rows is " + rowCount + "\n");
	System.out.println("These are the Usernames:");
	
	for(int i = 1; i < rowCount - 1; i++){
		
		String username = sheet1.getRow(i).getCell(0).getStringCellValue();
		//String password = sheet1.getRow(i).getCell(1).getStringCellValue();
		
		System.out.println("Username is " + username);
		//System.out.println("Test Data from Excel is " + password);

	}
	System.out.println();
	
	System.out.println("These are the Passwords: ");
	
	for(int i = 1; i < rowCount - 1; i++){
		
		String password = sheet1.getRow(i).getCell(1).getStringCellValue();
		System.out.println("Password is " + password);
	}
	
	/*String data1 = sheet1.getRow(1).getCell(0).getStringCellValue();
	
	System.out.println("Data from Excel is " + data1);*/
	
	wb.close();
	}

}
