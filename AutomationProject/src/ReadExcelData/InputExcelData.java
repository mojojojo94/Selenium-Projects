package ReadExcelData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class InputExcelData{
   
   public static String[][] getExcelData(String fileName, int sheetNumber) throws IOException {
	   
   String [][] arrayExcelData;
   
   File src = new File(fileName);
   FileInputStream fis = new FileInputStream(src);
   XSSFWorkbook wb = new XSSFWorkbook(fis);
   XSSFSheet sheet = wb.getSheetAt(sheetNumber);
   
   int totalCols = sheet.getRow(0).getLastCellNum();
   int totalRows = sheet.getLastRowNum();
   
   arrayExcelData = new String[totalRows-1][totalCols];
   
   for(int i = 1; i < totalRows; i++){
       for(int j = 0; j < totalCols; j++){
           arrayExcelData[i][j] = sheet.getRow(i).getCell(j).toString();
           System.out.print(arrayExcelData[i][j]);
       }
       System.out.println();
   }
    return arrayExcelData;
  }
   
   public static void main(String[] args){
	   
	   Object[][] arrayExcelData = null;
	   try{
	   File src = new File("C:\\Users\\sheheryar\\ExcelData\\LoginTestData.xlsx");
	   FileInputStream fis = new FileInputStream(src);
	   XSSFWorkbook wb = new XSSFWorkbook(fis);
	   XSSFSheet sheet = wb.getSheet("Sheet1");
	     System.out.println("test");
	   int totalCols = sheet.getRow(0).getLastCellNum();
	     System.out.println(totalCols);
	   int totalRows = sheet.getLastRowNum();
	   System.out.println(totalRows);
	   arrayExcelData = new Object[totalRows-1][totalCols];
	   System.out.println(arrayExcelData);
	   for(int i=1;i<totalRows; i++){
		     System.out.println("i="+i);
	       for(int j=0;j<totalCols;j++){
	    	   System.out.println("i="+i);
	    	    System.out.println("j="+j);
	   
	           arrayExcelData[i][j] = sheet.getRow(i).getCell(j).toString();
	           System.out.print(arrayExcelData[i][j]);
	       }
	       System.out.println("test");
	   }

   }catch(Exception e){
	   e.printStackTrace();
   }
	  }
}
