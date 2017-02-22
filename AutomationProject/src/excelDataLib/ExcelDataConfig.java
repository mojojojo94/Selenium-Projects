package excelDataLib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {
	
	static XSSFWorkbook wb;
	static XSSFSheet sheet1;
	static XSSFCell Cell;
	static XSSFRow Row;
	
	public ExcelDataConfig(String excelPath) {
		
		try {
			File loginExcelData = new File(excelPath);
			
			FileInputStream FIS = new FileInputStream(loginExcelData);
			
			wb = new XSSFWorkbook(FIS);
			
		} 
		catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
	}
	
	public static String getData(int sheetNumber, int rowNum, int colNum){
		
		sheet1 = wb.getSheetAt(sheetNumber);

		String data = sheet1.getRow(rowNum).getCell(colNum).getStringCellValue();
		
		return data;
		
	}
	
	public static String getAllRowsUsername(int sheetNumber, int colNum){
		
		int rowCount = sheet1.getLastRowNum();
		
		sheet1 = wb.getSheetAt(sheetNumber);
		
		String username = "";
		
		for (int i = 1; i < rowCount + 1; i++){
			
			username = sheet1.getRow(i).getCell(colNum).getStringCellValue();
		
		}
		
		return username;
	}
	

	
	public static String getAllRowsPassword(int sheetNumber, int colNum){
		
		int rowCount = sheet1.getLastRowNum();
		
		sheet1 = wb.getSheetAt(sheetNumber);
		
		String password = "";
		
		
		
		for (int i = 1; i < rowCount + 1; i++){
			
			password = sheet1.getRow(i).getCell(colNum).getStringCellValue();
			
			}
		
		return password;
	}
	
	public static Object[][] getTableArray(String excelPath, int sheetNumber) throws Exception {   
		 
		   String[][] tabArray = null;

		   try {
			   
			   File loginExcelData = new File(excelPath);

			   FileInputStream ExcelFile = new FileInputStream(loginExcelData);

			   // Access the required test data sheet

			   wb = new XSSFWorkbook(ExcelFile);

			   sheet1 = wb.getSheetAt(sheetNumber);

			   int startRow = 1;

			   int startCol = 0;

			   int ci,cj;

			   int totalRows = sheet1.getLastRowNum();

			   // you can write a function as well to get Column count

			   int totalCols = 2;

			   tabArray = new String[totalRows][totalCols];

			   ci = 0;

			   for (int i = startRow; i <= totalRows; i++, ci++) {           	   

				  cj=0;

				   for (int j = startCol; j <= totalCols; j++, cj++){

					   tabArray[ci][cj] = getCellData(i,j);

					   System.out.println(tabArray[ci][cj]);  

						}

					}

				}

			catch (FileNotFoundException e){

				System.out.println("Could not read the Excel sheet");

				e.printStackTrace();

				}

			catch (IOException e){

				System.out.println("Could not read the Excel sheet");

				e.printStackTrace();

				}

			return(tabArray);

			}
	
	public static String getCellData(int RowNum, int ColNum) throws Exception {
		 
		try{

			Cell = sheet1.getRow(RowNum).getCell(ColNum);

			@SuppressWarnings("deprecation")
			int dataType = Cell.getCellType();

			if  (dataType == 3) {

				return "";

			}
			else{

				String CellData = Cell.getStringCellValue();

				return CellData;

			}}
			catch (Exception e){

			System.out.println(e.getMessage());

			throw (e);

			}
		

		}
	
	public static void setExcelFile(String excelPath,int sheetNum) throws Exception {
		 
		   try {

				// Open the Excel file
			   File loginExcelData = new File(excelPath);

				FileInputStream ExcelFile = new FileInputStream(loginExcelData);

				// Access the required test data sheet

				wb = new XSSFWorkbook(ExcelFile);

				sheet1 = wb.getSheetAt(sheetNum);

				} catch (Exception e){

					throw (e);

				}

		}
	
	

}
